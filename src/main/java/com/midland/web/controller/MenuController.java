package com.midland.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Paginator;
import com.midland.web.controller.base.BaseController;
import com.midland.web.enums.ContextEnums;
import com.midland.web.model.Menu;
import com.midland.web.model.appointment.AppointLog;
import com.midland.web.model.appointment.Appointment;
import com.midland.web.model.user.User;
import com.midland.web.service.*;
import com.midland.web.util.MidlandHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 'ms.x' on 2017/8/1.
 */
@Controller
@RequestMapping("/appoint")
public class MenuController extends BaseController{
	@Autowired
	private MenuService menuServiceImpl;
	
	@RequestMapping("/root")
	public String getRootMenu(Model model ,HttpServletRequest request){
		
		return "/left";
	}
	
	
}
