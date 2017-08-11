package com.midland.web.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.midland.web.controller.base.BaseController;
import com.midland.web.enums.ContextEnums;
import com.midland.web.model.appointment.AppointLog;
import com.midland.web.model.appointment.Appointment;
import com.midland.web.model.user.User;
import com.midland.web.service.AppointLogService;
import com.midland.web.service.AppointmentService;
import com.midland.web.service.DingJiangService;
import com.midland.web.service.UserService;
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
public class AppointmentController extends BaseController{
	@Autowired
	private AppointmentService appointmentServiceImpl;
	@Autowired
	private AppointLogService appointLogServiceImpl;
	@Autowired
	private DingJiangService dingJiangServiceImpl;
	
	@Autowired
	private UserService userServiceImpl;
	
	
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
	/**
	 * 用户列表查询（重新分配经纪人）
	 * @param appointId
	 * @return
	 */
	@RequestMapping(value = "/toRedistribute", method = {RequestMethod.GET,RequestMethod.POST})
	public String toRedistribute(String appointId, Model model, HttpServletRequest request){
		model.addAttribute("appointId",appointId);
		return "appointment/redistributeIndex";
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
	
	/**
	 * 重新分配经纪人，把经纪人更新到预约记录里
	 * @param record
	 * @return
	 */
	@RequestMapping("/reset_agent")
	@ResponseBody
	public Object resetAgent(Appointment record) {
		Map map = new HashMap();
		int result = appointmentServiceImpl.updateByPrimaryKeySelective(record);
		if (result >0){
			map.put("state",0);
			return map;
		}
		map.put("state",-1);
		return map;
	}
	
	
	
	@RequestMapping("/to_update")
	public String toUpdateAppointment(int appointId,Model model) {
		Appointment appointment=appointmentServiceImpl.selectByPrimaryKey(appointId);
		List<AppointLog> appointLogs = appointLogServiceImpl.selectAppointLogByAppointId(appointId);
		model.addAttribute("appointment",appointment);
		model.addAttribute("appointLogs",appointLogs);
		return "appointment/updateAppointInfo";
	}
	
	
	
	@RequestMapping("/update")
	@ResponseBody
	public Object updateByPrimaryKeySelective(Appointment record,HttpServletRequest request) {
		Map map = new HashMap();
		int result = appointmentServiceImpl.updateByPrimaryKeySelective(record);
		if (result >0){
			User user = (User)request.getSession().getAttribute("userInfo");
			
			AppointLog appointLog = new AppointLog();
			if (StringUtils.isEmpty(record.getRemark())){
				appointLog.setRemark("无");
			}else{
				appointLog.setRemark(record.getRemark());
			}
			appointLog.setAppointId(record.getId());
			appointLog.setLogTime(MidlandHelper.getCurrentTime());
			appointLog.setOperatorid(user.getId());
			appointLog.setOperatorName(user.getUsername());
			
			appointLog.setState(record.getStatus());
			appointLogServiceImpl.insertSelective(appointLog);
			map.put("state",0);
			return map;
		}
		map.put("state",-1);
		return map;
	}
	
	/**
	 * 预约看房（重新分配经纪人）
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/redistribute_page", method = {RequestMethod.GET,RequestMethod.POST})
	public String getAppointRedistribute(User user, Model model, HttpServletRequest request){
		PageList<User> result = dingJiangServiceImpl.getUserList(user,"5", model, request);
		Paginator paginator = result.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("users", result);
		return "appointment/redistributeList";
	}
	
	
}
