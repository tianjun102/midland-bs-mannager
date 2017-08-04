package com.midland.web.dao;


import com.midland.web.model.AppointLog;

import java.util.List;

public interface AppointLogMapper {
    int deleteByPrimaryKey(Integer appointLogId);

    int insert(AppointLog record);

    int insertSelective(AppointLog record);

    AppointLog selectByPrimaryKey(Integer appointLogId);
    
    List<AppointLog> selectAppointLogByAppointId(Integer appointLogId);

    int updateByPrimaryKeySelective(AppointLog record);

    int updateByPrimaryKey(AppointLog record);
}