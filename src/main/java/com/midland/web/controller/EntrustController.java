package com.midland.web.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.midland.web.controller.base.BaseController;
import com.midland.web.enums.ContextEnums;
import com.midland.web.model.*;
import com.midland.web.model.user.User;
import com.midland.web.service.DingJiangService;
import com.midland.web.service.EntrustLogService;
import com.midland.web.service.EntrustService;
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
@RequestMapping("/entrust")
public class EntrustController extends BaseController{
	@Autowired
	private EntrustService entrustServiceImpl;
	@Autowired
	private EntrustLogService entrustLogServiceImpl;
	
	@Autowired
	private DingJiangService dingJiangServiceImpl;
	
	Logger logger = LoggerFactory.getLogger(EntrustController.class);
	
	@RequestMapping("/index")
	public String showAppointIndex(HttpServletRequest request)
	{
		return "/entrust/entrustIndex";
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object deleteByPrimaryKey(Integer id) {
		Map map = new HashMap<>();
		int result = entrustServiceImpl.deleteByPrimaryKey(id);
		if (result>0){
			map.put("state",0);
		}
		map.put("state",-1);
		return map;
	}
	@RequestMapping("/add")
	@ResponseBody
	public Object addAppointment(Entrust record) {
		Map map = new HashMap();
		try {
			entrustServiceImpl.insertSelective(record);
			map.put("state",0);
			return map;
		} catch (Exception e) {
			logger.error("addEntrust {}",record,e);
			map.put("state",-1);
			return map;
		}
	}
	@RequestMapping("/get")
	public Entrust selectByPrimaryKey(Integer id) {
		
		return entrustServiceImpl.selectByPrimaryKey(id);
	}

	
	
	@RequestMapping("/page")
	public String entrustPage(Model model, Entrust record, String pageNo, String pageSize) {
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize = ContextEnums.PAGESIZE;
		}
		PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo),Integer.valueOf(pageSize));
		PageList<Entrust> result = entrustServiceImpl.entrustPage(record,pageBounds);
		Paginator paginator = result.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("entrusts", result);
		return "entrust/entrustList";
	}
	

	
	@RequestMapping("/to_update")
	public String toUpdateAppointment(int entrustId, Model model) {
		Entrust entrust=entrustServiceImpl.selectByPrimaryKey(entrustId);
		List<EntrustLog> entrustLogs = entrustLogServiceImpl.selectEntrustLogByEntrustId(entrustId);
		model.addAttribute("entrust",entrust);
		model.addAttribute("entrustLogs",entrustLogs);
		return "entrust/updateEntrust";
	}
	
	
	
	@RequestMapping("/update")
	@ResponseBody
	public Object updateByPrimaryKeySelective(Entrust entrust, HttpServletRequest request) {
		Map map = new HashMap();
		int result = entrustServiceImpl.updateByPrimaryKeySelective(entrust);
		if (result >0){
			User user = (User)request.getSession().getAttribute("userInfo");
			
			EntrustLog appointLog = new EntrustLog();
			if (StringUtils.isEmpty(entrust.getRemark())){
				appointLog.setRemark("无");
			}else{
				appointLog.setRemark(entrust.getRemark());
			}
			appointLog.setEntrustId(entrust.getId());
			appointLog.setLogTime(MidlandHelper.getCurrentTime());
			appointLog.setOperatorid(user.getId());
			appointLog.setOperatorName(user.getUsername());
			
			appointLog.setState(entrust.getStatus());
			entrustLogServiceImpl.insertSelective(appointLog);
			map.put("state",0);
			return map;
		}
		map.put("state",-1);
		return map;
	}
	
	/**
	 * 用户列表查询（重新分配经纪人）
	 * @param entrustId
	 * @return
	 */
	@RequestMapping(value = "/toRedistribute", method = {RequestMethod.GET,RequestMethod.POST})
	public String toRedistribute(String entrustId, Model model, HttpServletRequest request){
		model.addAttribute("entrustId",entrustId);
		return "entrust/redistributeIndex";
	}
	
	/**
	 * 重新分配经纪人，把经纪人更新到委托记录里
	 * @param record
	 * @return
	 */
	@RequestMapping("/reset_agent")
	@ResponseBody
	public Object resetAgent(Entrust record) {
		logger.info("resetAgent ： 重新分配经纪人，{}",record);
		Map map = new HashMap();
		int result = entrustServiceImpl.updateByPrimaryKeySelective(record);
		if (result >0){
			map.put("state",0);
			return map;
		}
		map.put("state",-1);
		return map;
	}
	/**
	 * 委托看房（重新分配经纪人）
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/redistribute_page", method = {RequestMethod.GET,RequestMethod.POST})
	public String getEntrustRedistribute(User user, Model model, HttpServletRequest request){
		PageList<User> result = dingJiangServiceImpl.getUserList(user,"5", model, request);
		Paginator paginator = result.getPaginator();
		model.addAttribute("paginator", paginator);
		model.addAttribute("users", result);
		return "entrust/redistributeList";
	}
	
	
}
