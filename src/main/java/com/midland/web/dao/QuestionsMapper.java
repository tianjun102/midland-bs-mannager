package com.midland.web.dao;

import com.midland.web.model.Questions;

public interface QuestionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Questions record);

    int insertSelective(Questions record);

    Questions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Questions record);

    int updateByPrimaryKeyWithBLOBs(Questions record);

    int updateByPrimaryKey(Questions record);
}