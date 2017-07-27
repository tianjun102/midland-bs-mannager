package com.midland.web.dao;

import com.midland.web.model.HotSearch;

public interface HotSearchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HotSearch record);

    int insertSelective(HotSearch record);

    HotSearch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HotSearch record);

    int updateByPrimaryKey(HotSearch record);
}