package com.midland.web.dao;


import com.midland.web.model.AppointLog;

public interface AppointLogMapper {
    int deleteByPrimaryKey(Integer appointLogId);

    int insert(AppointLog record);

    int insertSelective(AppointLog record);

    AppointLog selectByPrimaryKey(Integer appointLogId);

    int updateByPrimaryKeySelective(AppointLog record);

    int updateByPrimaryKey(AppointLog record);
}