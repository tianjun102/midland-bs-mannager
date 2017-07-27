package com.midland.web.dao;

import com.midland.web.model.LiaisonRecord;

public interface LiaisonRecordMapper {
    int insert(LiaisonRecord record);

    int insertSelective(LiaisonRecord record);
}