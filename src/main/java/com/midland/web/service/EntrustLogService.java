package com.midland.web.service;

import com.midland.web.model.EntrustLog;

import java.util.List;

public interface EntrustLogService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(EntrustLog record);

    EntrustLog selectByPrimaryKey(Integer id);
    
    List<EntrustLog> selectEntrustLogByEntrustId(Integer entrustId);
    
    int updateByPrimaryKeySelective(EntrustLog record);

}