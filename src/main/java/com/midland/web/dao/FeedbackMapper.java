package com.midland.web.dao;

import com.midland.web.model.Feedback;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKeyWithBLOBs(Feedback record);

    int updateByPrimaryKey(Feedback record);
}