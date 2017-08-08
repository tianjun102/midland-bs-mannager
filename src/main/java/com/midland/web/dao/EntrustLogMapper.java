package com.midland.web.dao;


import com.midland.web.model.EntrustLog;

import java.util.List;

public interface EntrustLogMapper {
    int deleteByPrimaryKey(Integer entrustLogId);

    int insert(EntrustLog record);

    int insertSelective(EntrustLog record);
    
    EntrustLog selectByPrimaryKey(Integer appointLogId);
    
    List<EntrustLog> selectEntrustLogByEntrustId(Integer entrustId);

    int updateByPrimaryKeySelective(EntrustLog record);

    int updateByPrimaryKey(EntrustLog record);
}