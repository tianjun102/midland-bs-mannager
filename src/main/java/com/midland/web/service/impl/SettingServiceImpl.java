package com.midland.web.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.core.redis.IBaseRedisTemplate;
import com.midland.core.util.AppSetting;
import com.midland.core.util.HttpUtils;
import com.midland.web.dao.PopularMapper;
import com.midland.web.model.Area;
import com.midland.web.model.Popular;
import com.midland.web.service.SettingService;
import com.midland.web.util.MidlandHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private IBaseRedisTemplate baseRedisTemplate;

    @Autowired
    private PopularMapper popularMapper;

    @Override
    public PageList<Popular> findPopularList(Popular popular, PageBounds pageBounds) {
        return popularMapper.selectPropularList(popular, pageBounds);
    }

    @Override
    public Popular findPopular(Popular popular) {
        return popularMapper.selectByPrimaryKey(popular.getId());
    }

    @Override
    public int updatePopular(Popular popular) {
        return popularMapper.updateByPrimaryKeySelective(popular);
    }

    @Override
    public int insertPopular(Popular popular) {
        return popularMapper.insert(popular);
    }

    @Override
    public Map<String, List<Area>> queryCityByRedis(Map<String, String> parem) {
        //先在缓存中查询
        Map<String, List<Area>> areaMap = this.getArea(parem.get("flag"),parem.get("id"),parem.get("parentId"));
        //如果缓存查不到再调接口查
        if (areaMap == null){

            String data = HttpUtils.get(AppSetting.getAppSetting("APIURL"), parem);
            List<Area> areaList = MidlandHelper.getPojoList(data, Area.class);
            String parentId = "";
            for (Area area : areaList) {
                if (!parentId.equals(area.getParentId())) {
                    parentId = area.getParentId();
                    baseRedisTemplate.saveValue("province:" + area.getParentId(), area);
                }
                    baseRedisTemplate.saveValue("city:" + area.getId() + ":" + area.getParentId(), area);
            }

            areaMap = this.getArea(parem.get("flag"),parem.get("id"),parem.get("parentId"));
        }

        return areaMap;

    }

    /**
     *
     * @param parem flag = province(省) , city(市) ,area(区), sheet(片区) id 或 parentId
     * @return
     */
    @Override
    public Map<String, List<Area>> queryAreaByRedis(Map<String, String> parem) {
        //先在缓存中查询
        Map<String, List<Area>> areaMap = this.getArea(parem.get("flag"),parem.get("cityId"),parem.get("areaId"));

        if (areaMap == null){

            String data = HttpUtils.get(AppSetting.getAppSetting("AREAURL"), parem);
            List<Area> areaList = MidlandHelper.getPojoList(data, Area.class);
            String parentId = "";
            for (Area area : areaList) {
                if(StringUtils.isNotEmpty(parem.get("cityId")) &&StringUtils.isEmpty (parem.get("areaId"))){
                    baseRedisTemplate.saveValue("area:" + area.getId() + ":" + parem.get("cityId"), area);
                }else if (StringUtils.isNotEmpty(parem.get("cityId")) && StringUtils.isNotEmpty(parem.get("areaId"))){
                    baseRedisTemplate.saveValue("sheet:" + area.getId() + ":" + area.getParentId(), area);
                }
            }

            areaMap = this.getArea(parem.get("flag"),parem.get("cityId"),parem.get("areaId"));
        }

        return areaMap;
    }

    /**
     * 根据省份id获取下级市区
     * @param flag = province(省) , city(市)
     * @param id
     * @return
     */
    private Map<String, List<Area>> getArea(String flag, String id,String parentId) {
        Map<String, List<Area>> result = new HashMap<>();
        List<Area> areaList = new LinkedList<>();
        Set<byte[]> keys = null;
        if ("provice".equals(flag)) {
             keys = baseRedisTemplate.getKeysLike("provice:*");
             if(keys==null||keys.size()<=0){
                 return null;
             }
        }else if ("city".equals(flag)){
             keys = baseRedisTemplate.getKeysLike("city:*:"+id);
            if(keys==null||keys.size()<=0){
                return null;
            }
        }else if("area".equals(flag)){
            keys = baseRedisTemplate.getKeysLike("area:*:"+id);
            if(keys==null||keys.size()<=0){
                return null;
            }
        }else if("sheet".equals(flag)){
            keys = baseRedisTemplate.getKeysLike("sheet:*:"+parentId);
            if(keys==null||keys.size()<=0){
                return null;
            }
        }

        for (byte[] a : keys) {
            String key = "";
            try {
                key = StringUtils.toString(a, null);
                Area area = (Area) baseRedisTemplate.getValueByKey(key);
                areaList.add(area);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        result.put(flag,areaList);

        return  result;
    }

}