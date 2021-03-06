package com.midland.web.service;

import com.midland.web.model.SpecialPage;
import java.util.List;
public interface SpecialPageService {

	/**
	 * 主键查询
	 **/
	SpecialPage selectSpecialPageById(Integer id);

	/**
	 * 主键删除
	 **/
	void deleteSpecialPageById(Integer id) throws Exception;

	/**
	 * 主键更新
	 **/
	void updateSpecialPageById(SpecialPage specialPage) throws Exception;

	/**
	 * 插入
	 **/
	void insertSpecialPage(SpecialPage specialPage) throws Exception;

	/**
	 * 分页，这里建议使用插件（com.github.pagehelper.PageHelper）
	 **/
	List<SpecialPage> findSpecialPageList(SpecialPage specialPage) throws Exception;

}
