package com.midland.web.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.model.Entrust;

public interface EntrustMapper {
    int deleteByPrimaryKey(Integer id);
    
    PageList<Entrust> entrustPage(Entrust record, PageBounds pageBounds);

    int insertSelective(Entrust record);

    Entrust selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Entrust record);

}