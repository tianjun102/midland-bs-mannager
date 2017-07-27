package com.midland.web.dao;

import com.midland.web.model.QrCode;

public interface QrCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrCode record);

    int insertSelective(QrCode record);

    QrCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrCode record);

    int updateByPrimaryKey(QrCode record);
}