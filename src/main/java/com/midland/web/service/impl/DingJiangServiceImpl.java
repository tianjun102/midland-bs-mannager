package com.midland.web.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.enums.ContextEnums;
import com.midland.web.model.user.User;
import com.midland.web.service.DingJiangService;
import com.midland.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 'ms.x' on 2017/8/7.
 */
@Service
public class DingJiangServiceImpl implements DingJiangService{
	
	@Autowired
	private UserService userServiceImpl;
	
	@Override
	public PageList<User> getUserList(User user, String pageSize, Model model, HttpServletRequest request) {
		String pageNo = request.getParameter("pageNo");
		
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
		
		return userServiceImpl.selectByExampleAndPage(user,pageBounds);
		
	}
}
