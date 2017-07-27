package com.midland.web.dao;

import com.midland.web.model.SpecialPage;
import com.midland.web.model.SpecialPageWithBLOBs;

public interface SpecialPageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpecialPageWithBLOBs record);

    int insertSelective(SpecialPageWithBLOBs record);

    SpecialPageWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpecialPageWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SpecialPageWithBLOBs record);

    int updateByPrimaryKey(SpecialPage record);
}