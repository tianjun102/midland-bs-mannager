package com.midland.web.dao;

import com.midland.web.model.FooterWithBLOBs;

public interface FooterMapper {
    int insert(FooterWithBLOBs record);

    int insertSelective(FooterWithBLOBs record);
}