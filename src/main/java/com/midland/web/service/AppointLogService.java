package com.midland.web.service;

import com.midland.web.model.appointment.AppointLog;

import java.util.List;

public interface AppointLogService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(AppointLog record);
    
    AppointLog selectByPrimaryKey(Integer id);
    
    
    List<AppointLog> selectAppointLogByAppointId(Integer id);
    
    int updateByPrimaryKeySelective(AppointLog record);
}