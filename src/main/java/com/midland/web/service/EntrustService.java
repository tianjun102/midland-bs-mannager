package com.midland.web.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.model.Entrust;

public interface EntrustService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Entrust record);

    Entrust selectByPrimaryKey(Integer id);
    
    PageList<Entrust> entrustPage(Entrust record, PageBounds pageBounds);
    
    int updateByPrimaryKeySelective(Entrust record);

}