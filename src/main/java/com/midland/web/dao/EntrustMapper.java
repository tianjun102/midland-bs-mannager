package com.midland.web.dao;

import com.midland.web.model.Entrust;

public interface EntrustMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Entrust record);

    int insertSelective(Entrust record);

    Entrust selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Entrust record);

    int updateByPrimaryKey(Entrust record);
}