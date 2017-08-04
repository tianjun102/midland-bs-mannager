package com.midland.web.service;

import com.midland.web.model.AppointLog;

public interface AppointLogService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(AppointLog record);
    
    AppointLog selectByPrimaryKey(Integer id);
    
    
    int updateByPrimaryKeySelective(AppointLog record);
}