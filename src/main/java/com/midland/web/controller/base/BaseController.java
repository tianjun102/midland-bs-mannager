package com.midland.web.controller.base;

import com.midland.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 'ms.x' on 2017/7/27.
 */
@Controller
public abstract class BaseController {
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		InitStringToNull stringEditor = new InitStringToNull();
		binder.registerCustomEditor(String.class, stringEditor);
	}
}
