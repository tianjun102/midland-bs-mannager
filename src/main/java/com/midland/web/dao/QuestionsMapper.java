package com.midland.web.dao;

import com.midland.web.model.Questions;

import java.util.List;
import java.util.Map;

public interface QuestionsMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteByIds(Map<String,Object> map);
    int insertSelective(Questions record);
    Questions selectByPrimaryKey(Integer id);
    List<Questions> questionPage(Questions questions);
    int updateByPrimaryKeySelective(Questions record);

}