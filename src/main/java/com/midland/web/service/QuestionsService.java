package com.midland.web.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.core.generic.GenericService;
import com.midland.web.model.Permission;
import com.midland.web.model.Questions;

import java.util.List;

/**
 *
 * 
 * @author 
 * @since 2016年6月10日 下午12:02:39
 **/
public interface QuestionsService {
    int deleteByPrimaryKey(Integer id);
	
	int deleteByIds(List<String> ids);
	
	int insertSelective(Questions record);
    Questions selectByPrimaryKey(Integer id);
    PageList<Questions> questionPage(Questions questions, PageBounds pageBounds);
    int updateByPrimaryKeySelective(Questions record);
}
