package com.midland.web.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.midland.web.controller.base.BaseController;
import com.midland.web.enums.ContextEnums;
import com.midland.web.model.Questions;
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
@RequestMapping("/questions")
public class QuestionsController extends BaseController{
	@Autowired
	private QuestionsService questionsServiceImpl;
	
	Logger logger = LoggerFactory.getLogger(QuestionsController.class);
	
	@RequestMapping("/index")
	public String showAppointIndex(HttpServletRequest request) {
		
		return "/questions/qeustionsIndex";
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object deleteByPrimaryKey(String ids) {
		Map map = new HashMap<>();
		map.put("state",-1);
		List<String> idlist = MidlandHelper.getStringRemoveEmpty(ids);
		int result = questionsServiceImpl.deleteByIds(idlist);
		if (result>0){
			map.put("state",0);
		}
		return map;
	}
	@RequestMapping("/add")
	@ResponseBody
	public Object addAppointment(Questions record) {
		Map map = new HashMap();
		try {
			questionsServiceImpl.insertSelective(record);
			map.put("state",0);
			return map;
		} catch (Exception e) {
			logger.error("addAppointment {}",record,e);
			map.put("state",-1);
			return map;
		}
	}
	@RequestMapping("/get")
	public Questions selectByPrimaryKey(Integer id) {
		
		
		return questionsServiceImpl.selectByPrimaryKey(id);
	}
	/**
	 * 审核页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/toAudit", method = {RequestMethod.GET,RequestMethod.POST})
	public String toAudit(Integer id, Model model, HttpServletRequest request){
		Questions questions = questionsServiceImpl.selectByPrimaryKey(id);
		model.addAttribute("questions",questions);
		return "questions/auditIndex";
	}
	
	
	
	@RequestMapping("/page")
	public String questionPage(Model model, Questions record, String pageNo, String pageSize) {
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo),Integer.valueOf(pageSize));
		PageList<Questions> result = questionsServiceImpl.questionPage(record,pageBounds);
		Paginator paginator = result.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("questions", result);
		return "questions/questionsList";
	}
	
	
	
	
	@RequestMapping("/to_update")
	public String toUpdateAppointment(int Id,Model model) {
		Questions questions=questionsServiceImpl.selectByPrimaryKey(Id);
		model.addAttribute("appointment",questions);
		return "appointment/updateAppointInfo";
	}
	
	
	
	@RequestMapping("/update")
	@ResponseBody
	public Object updateByPrimaryKeySelective(Questions record,HttpServletRequest request) {
		Map map = new HashMap();
		User user = (User)request.getSession().getAttribute("userInfo");
		record.setAuditor(user.getUsername());
		int result = questionsServiceImpl.updateByPrimaryKeySelective(record);
		if (result >0){
			map.put("state",0);
			return map;
		}
		map.put("state",-1);
		return map;
	}
}
