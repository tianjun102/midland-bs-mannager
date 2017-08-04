package com.midland.web.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.midland.web.controller.base.BaseController;
import com.midland.web.enums.ContextEnums;
import com.midland.web.model.Appointment;
import com.midland.web.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 'ms.x' on 2017/8/1.
 */
@Controller
@RequestMapping("/appoint")
public class AppointmentController extends BaseController{
	@Autowired
	private AppointmentService appointmentServiceImpl;
	Logger logger = LoggerFactory.getLogger(AppointmentController.class);
	
	@RequestMapping("/index")
	public String showAppointIndex(HttpServletRequest request) {
		return "/appointment/appointIndex";
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object deleteByPrimaryKey(Integer id) {
		Map map = new HashMap<>();
		int result = appointmentServiceImpl.deleteByPrimaryKey(id);
		if (result>0){
			map.put("state",0);
		}
		map.put("state",-1);
		return map;
	}
	@RequestMapping("/add")
	@ResponseBody
	public Object addAppointment(Appointment record) {
		Map map = new HashMap();
		try {
			appointmentServiceImpl.insertSelective(record);
			map.put("state",0);
			return map;
		} catch (Exception e) {
			logger.error("addAppointment {}",record,e);
			map.put("state",-1);
			return map;
		}
	}
	@RequestMapping("/get")
	public Appointment selectByPrimaryKey(Integer id) {
		return appointmentServiceImpl.selectByPrimaryKey(id);
	}
	
	
	@RequestMapping("/page")
	public String appointmentPage(Model model, Appointment record, String pageNo, String pageSize) {
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo),Integer.valueOf(pageSize));
		PageList<Appointment> result = appointmentServiceImpl.appointmentPage(record,pageBounds);
		Paginator paginator = result.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("appoint", result);
		return "appointment/appointlist";
	}
	@RequestMapping("/update")
	@ResponseBody
	public Object updateByPrimaryKeySelective(Appointment record) {
		Map map = new HashMap();
		int result = appointmentServiceImpl.updateByPrimaryKeySelective(record);
		if (result >0){
			map.put("state",0);
			return map;
		}
		map.put("state",-1);
		return map;
	}
}
