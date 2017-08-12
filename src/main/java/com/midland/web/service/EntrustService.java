package com.midland.web.service;

import com.midland.web.model.Entrust;

import java.util.List;

public interface EntrustService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Entrust record);

    Entrust selectByPrimaryKey(Integer id);
    
    List<Entrust> entrustPage(Entrust record);
    
    int updateByPrimaryKeySelective(Entrust record);

}