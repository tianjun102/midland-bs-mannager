package com.midland.web.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.model.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 'ms.x' on 2017/8/7.
 */
public interface DingJiangService {
	PageList<User> getUserList(User user, String pageSize, Model model, HttpServletRequest request);
}
