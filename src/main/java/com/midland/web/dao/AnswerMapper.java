package com.midland.web.dao;

import com.midland.web.model.Answer;

import java.util.List;

public interface AnswerMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Integer id);
    
    List<Answer> selectByQuestionId(Integer questionId);

    int updateByPrimaryKeySelective(Answer record);

}