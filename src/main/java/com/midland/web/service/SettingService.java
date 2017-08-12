package com.midland.web.service;

import com.midland.web.model.Area;
import com.midland.web.model.Popular;

import java.util.List;
import java.util.Map;

public interface SettingService {

    public List<Popular> findPopularList(Popular popular );

    public Popular findPopular(Popular popular);

    public int updatePopular(Popular popular);

    public int insertPopular(Popular popular);

    public Map<String, List<Area>> queryCityByRedis(Map<String,String> parem);

    public Map<String, List<Area>> queryAreaByRedis(Map<String,String> parem);




}
