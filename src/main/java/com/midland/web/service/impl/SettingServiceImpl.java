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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SettingServiceImpl implements SettingService {

    @Value("APIURL")
    private String APIURL;
    
    @Autowired
    private IBaseRedisTemplate redisTemplate;

    @Autowired
    private PopularMapper popularMapper;

    @Override
    public PageList<Popular> findPopularList(Popular popular, PageBounds pageBounds) {
        return popularMapper.selectPropularList(popular,pageBounds);
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
    public List<Area> queryAreaByRedis(Map<String, String> parem) {
       String data = HttpUtils.get(AppSetting.getAppSetting("APIURL"),parem);
       return MidlandHelper.getPojoList(data, Area.class);
    }


}
