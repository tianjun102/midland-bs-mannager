package com.midland.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hxin.common.cache.client.api.standalone.IBaseRedisTemplate;
import com.midland.core.util.HttpUtils;
import com.midland.web.dao.PopularMapper;
import com.midland.web.model.Area;
import com.midland.web.model.Popular;
import com.midland.web.service.SettingService;
import com.midland.web.util.MidlandHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SettingServiceImpl implements SettingService {
    public static final String APIURL = "http://218.18.9.171:8183/dingjian/website/api/city/list";

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
    public String queryAreaByRedis(Map<String, String> parem) {
        return   HttpUtils.get(APIURL,parem);

    }

    public static void main(String[] args) {
        SettingServiceImpl aa = new SettingServiceImpl();
        String et=aa.queryAreaByRedis(null);
        List<Area> area = MidlandHelper.getPojoList(et,Area.class);
    }





}
