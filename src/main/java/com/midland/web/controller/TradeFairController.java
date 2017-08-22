package com.midland.web.controller;

import com.midland.web.model.TradeFair;
import com.midland.web.service.TradeFairService;
import com.midland.web.controller.base.BaseController;
import org.slf4j.Logger;
import java.util.Map;
import java.util.HashMap;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import com.midland.web.util.MidlandHelper;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/tradeFair")
public class TradeFairController extends BaseController  {

	private Logger log = LoggerFactory.getLogger(TradeFairController.class);
	@Autowired
	private TradeFairService tradeFairServiceImpl;

	/**
	 * 
	 **/
	@RequestMapping("index")
	public String tradeFairIndex(TradeFair tradeFair,Model model) throws Exception {
		return "tradeFair/tradeFairIndex";
	}

	/**
	 * 新增
	 **/
	@RequestMapping("add_tradeFair")
	@ResponseBody
	public Object addTradeFair(TradeFair tradeFair) throws Exception {
		Map map = new HashMap<>();
		try {
			log.info("addTradeFair {}",tradeFair);
			tradeFairServiceImpl.insertTradeFair(tradeFair);
			map.put("state",0);
		} catch(Exception e) {
			log.error("addTradeFair异常 {}",tradeFair,e);
			map.put("state",-1);
		}
		return map;
	}

	/**
	 * 查询
	 **/
	@RequestMapping("get_tradeFair")
	public String getTradeFairById(Integer id,Model model) {
		log.info("getTradeFairById  {}",id);
		TradeFair result = tradeFairServiceImpl.selectTradeFairById(id);
		model.addAttribute("item",result);
		return "tradeFair/updateTradeFair";	}

	/**
	 * 删除
	 **/
	@RequestMapping("delete_tradeFair")
	@ResponseBody
	public Object deleteTradeFairById(Integer id)throws Exception {
		Map map = new HashMap<>();
		try {
			log.info("deleteTradeFairById  {}",id);
			tradeFairServiceImpl.deleteTradeFairById(id);
			map.put("state",0);
		} catch(Exception e) {
			log.error("deleteTradeFairById  {}",id,e);
			map.put("state",-1);
		}
		return map;
	}
	/**
	 * 更新
	 **/
	@RequestMapping("update_tradeFair")
	@ResponseBody
	public Object updateTradeFairById(TradeFair tradeFair) throws Exception {
		Map map = new HashMap<>();
		try {
			log.info("updateTradeFairById  {}",tradeFair);
			tradeFairServiceImpl.updateTradeFairById(tradeFair);
			map.put("state",0);
		} catch(Exception e) {
			log.error("updateTradeFairById  {}",tradeFair,e);
			map.put("state",-1);
		}
		return map;
	}

	/**
	 * 分页，这里建议使用插件（com.github.pagehelper.PageHelper）
	 **/
	@RequestMapping("tradeFairList")
	public String findTradeFairList(TradeFair tradeFair,Model model, HttpServletRequest request) {
		try {
			log.info("findTradeFairList  {}",tradeFair);
			MidlandHelper.doPage(request);
			List<TradeFair> result = tradeFairServiceImpl.findTradeFairList(tradeFair);
			model.addAttribute("items",result);
		} catch(Exception e) {
			log.error("findTradeFairList  {}",tradeFair,e);
			model.addAttribute("items",null);
		}
		return "tradeFair/tradeFairList";
	}
}
