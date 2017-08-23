package com.midland.web.controller;

import com.midland.web.model.Information;
import com.midland.web.service.InformationService;
import com.midland.web.controller.base.BaseController;
import org.slf4j.Logger;
import java.util.Map;
import java.util.HashMap;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.Page;
import com.github.pagehelper.Paginator;
import java.util.List;
import com.midland.web.util.MidlandHelper;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
@Controller
@SuppressWarnings("all")
@RequestMapping("/information/")
public class InformationController extends BaseController  {

	private Logger log = LoggerFactory.getLogger(InformationController.class);
	@Autowired
	private InformationService informationServiceImpl;

	/**
	 * 
	 **/
	@RequestMapping("index")
	public String informationIndex(Information information,Model model) throws Exception {
		return "information/informationIndex";
	}

	/**
	 * 
	 **/
	@RequestMapping("to_add")
	public String toAddInformation(Information information,Model model) throws Exception {
		return "information/addInformation";
	}

	/**
	 * 新增
	 **/
	@RequestMapping("add")
	@ResponseBody
	public Object addInformation(Information information) throws Exception {
		Map<String,Object> map = new HashMap<>();
		try {
			log.info("addInformation {}",information);
			informationServiceImpl.insertInformation(information);
			map.put("state",0);
		} catch(Exception e) {
			log.error("addInformation异常 {}",information,e);
			map.put("state",-1);
		}
		return map;
	}

	/**
	 * 查询
	 **/
	@RequestMapping("get_information")
	public String getInformationById(Integer id,Model model) {
		log.info("getInformationById  {}",id);
		Information result = informationServiceImpl.selectInformationById(id);
		model.addAttribute("item",result);
		return "information/updateInformation";	}

	/**
	 * 删除
	 **/
	@RequestMapping("delete")
	@ResponseBody
	public Object deleteInformationById(Integer id)throws Exception {
		Map<String,Object> map = new HashMap<>();
		try {
			log.info("deleteInformationById  {}",id);
			informationServiceImpl.deleteInformationById(id);
			map.put("state",0);
		} catch(Exception e) {
			log.error("deleteInformationById  {}",id,e);
			map.put("state",-1);
		}
		return map;
	}
	/**
	 * 
	 **/
	@RequestMapping("to_update")
	public String toUpdateInformation(Integer id,Model model) throws Exception {
		Information result = informationServiceImpl.selectInformationById(id);
		model.addAttribute("item",result);
		return "information/updateInformation";
	}

	/**
	 * 更新
	 **/
	@RequestMapping("update")
	@ResponseBody
	public Object updateInformationById(Information information) throws Exception {
		Map<String,Object> map = new HashMap<>();
		try {
			log.info("updateInformationById  {}",information);
			informationServiceImpl.updateInformationById(information);
			map.put("state",0);
		} catch(Exception e) {
			log.error("updateInformationById  {}",information,e);
			map.put("state",-1);
		}
		return map;
	}

	/**
	 * 分页，这里建议使用插件（com.github.pagehelper.PageHelper）
	 **/
	@RequestMapping("list")
	public String findInformationList(Information information,Model model, HttpServletRequest request) {
		try {
			log.info("findInformationList  {}",information);
			MidlandHelper.doPage(request);
			Page<Information> result = (Page<Information>)informationServiceImpl.findInformationList(information);
			Paginator paginator=result.getPaginator();
			model.addAttribute("paginator",paginator);
			model.addAttribute("items",result);
		} catch(Exception e) {
			log.error("findInformationList  {}",information,e);
			model.addAttribute("paginator",null);
			model.addAttribute("items",null);
		}
		return "information/informationList";
	}
}
