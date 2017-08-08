package com.midland.web.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.model.Questions;

import java.util.List;
import java.util.Map;

public interface QuestionsMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteByIds(Map<String,Object> map);
    int insertSelective(Questions record);
    Questions selectByPrimaryKey(Integer id);
    PageList<Questions> questionPage(Questions questions,PageBounds pageBounds);
    int updateByPrimaryKeySelective(Questions record);

}