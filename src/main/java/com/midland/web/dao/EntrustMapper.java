package com.midland.web.dao;

import com.midland.web.model.Entrust;

import java.util.List;

public interface EntrustMapper {
    int deleteByPrimaryKey(Integer id);
    
    List<Entrust> entrustPage(Entrust record);

    int insertSelective(Entrust record);

    Entrust selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Entrust record);

}