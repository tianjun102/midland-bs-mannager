package com.midland.web.service.impl;

import com.midland.web.model.Menu;
import com.midland.web.dao.MenuMapper;
import com.midland.web.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {

	private Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);
	@Autowired
	private MenuMapper menuMapper;

	/**
	 * 插入
	 **/
	@Override
	public void insertMenu(Menu menu) throws Exception {
		try {
			log.info("insert {}",menu);
			menuMapper.insertMenu(menu);
		} catch(Exception e) {
			log.error("insertMenu异常 {}",menu,e);
			throw e;
		}
	}

	/**
	 * 查询
	 **/
	@Override
	public Menu selectById(Integer id) {
		log.info("selectById  {}",id);
		return menuMapper.selectById(id);
	}
	
	@Override
	public List<Menu> selectByParentId(Integer parentId) {
		log.info("selectByParentId  {}",parentId);
		return menuMapper.selectByParentId(parentId);
	}
	
	/**
	 * 删除
	 **/
	@Override
	public void deleteById(Integer id)throws Exception {
		try {
			log.info("deleteById  {}",id);
			int result = menuMapper.deleteById(id);
			if (result < 1) {
				throw new Exception("deleteById失败");
			}
		} catch(Exception e) {
			log.error("deleteById  {}",id,e);
			throw e;
		}
	}
	/**
	 * 更新
	 **/
	@Override
	public void updateById(Menu menu) throws Exception {
		try {
			log.info("updateById  {}",menu);
			int result = menuMapper.updateById(menu);
			if (result < 1) {
				throw new Exception("updateById失败");
			}
		} catch(Exception e) {
			log.error("updateById  {}",menu,e);
			throw e;
		}
	}

	/**
	 * 分页，这里建议使用插件（com.github.pagehelper.PageHelper）
	 **/
	@Override
	public List<Menu> findMenuList(Menu menu) throws Exception {
		try {
			log.info("findMenuList  {}",menu);
			return menuMapper.findMenuList(menu);
		} catch(Exception e) {
			log.error("findMenuList  {}",menu,e);
			throw e;
		}
	}
}
