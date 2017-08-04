package com.midland.web.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.model.Area;
import com.midland.web.model.Popular;

import java.util.List;
import java.util.Map;

public interface SettingService {

    public PageList<Popular> findPopularList(Popular popular , PageBounds pageBounds);

    public Popular findPopular(Popular popular);

    public int updatePopular(Popular popular);

    public int insertPopular(Popular popular);

    public Map<String, List<Area>> queryCityByRedis(Map<String,String> parem);

    public Map<String, List<Area>> queryAreaByRedis(Map<String,String> parem);




}
