package com.midland.web.dao;

import com.midland.web.model.Menu;
import java.util.List;

public interface MenuMapper {

	Menu selectById(Integer menu);
	List<Menu> selectByParentId(Integer menu);

	int deleteById(Integer menu);

	int updateById(Menu menu);

	int insertMenu(Menu menu);

	List<Menu> findMenuList(Menu menu);

}
