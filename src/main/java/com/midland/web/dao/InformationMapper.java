package com.midland.web.dao;

import com.midland.web.model.Information;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKeyWithBLOBs(Information record);

    int updateByPrimaryKey(Information record);
}