package com.midland.web.controller;

import com.midland.web.model.Area;
import com.midland.web.model.FilmLibrary;
import com.midland.web.model.user.User;
import com.midland.web.service.FilmLibraryService;
import com.midland.web.controller.base.BaseController;
import com.midland.web.service.SettingService;
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
@RequestMapping("/filmLibrary/")
public class FilmLibraryController extends BaseController  {

	private Logger log = LoggerFactory.getLogger(FilmLibraryController.class);
	@Autowired
	private FilmLibraryService filmLibraryServiceImpl;
	@Autowired
	private SettingService settingService;

	/**
	 * 
	 **/
	@RequestMapping("index")
	public String filmLibraryIndex(FilmLibrary filmLibrary,Model model) throws Exception {
		List<Area> list = settingService.queryAllCityByRedis();
		model.addAttribute("citys",list);
		return "filmLibrary/filmLibraryIndex";
	}

	/**
	 * 
	 **/
	@RequestMapping("to_add")
	public String toAddFilmLibrary(FilmLibrary filmLibrary,Model model) throws Exception {
		List<Area> list = settingService.queryAllCityByRedis();
		model.addAttribute("citys",list);
		return "filmLibrary/addFilmLibrary";
	}

	/**
	 * 新增
	 **/
	@RequestMapping("add")
	@ResponseBody
	public Object addFilmLibrary(FilmLibrary filmLibrary,HttpServletRequest request) throws Exception {
		Map<String,Object> map = new HashMap<>();
		try {
			User user = MidlandHelper.getCurrentUser(request);
			filmLibrary.setOperatorName(user.getUserCnName());
			filmLibrary.setOperatorId(user.getId());
			log.info("addFilmLibrary {}",filmLibrary);
			filmLibraryServiceImpl.insertFilmLibrary(filmLibrary);
			map.put("state",0);
		} catch(Exception e) {
			log.error("addFilmLibrary异常 {}",filmLibrary,e);
			map.put("state",-1);
		}
		return map;
	}

	/**
	 * 查询
	 **/
	@RequestMapping("get_filmLibrary")
	public String getFilmLibraryById(Integer id,Model model) {
		log.info("getFilmLibraryById  {}",id);
		FilmLibrary result = filmLibraryServiceImpl.selectFilmLibraryById(id);
		model.addAttribute("item",result);
		return "filmLibrary/updateFilmLibrary";	}

	/**
	 * 删除
	 **/
	@RequestMapping("delete")
	@ResponseBody
	public Object deleteFilmLibraryById(Integer id)throws Exception {
		Map<String,Object> map = new HashMap<>();
		try {
			log.info("deleteFilmLibraryById  {}",id);
			filmLibraryServiceImpl.deleteFilmLibraryById(id);
			map.put("state",0);
		} catch(Exception e) {
			log.error("deleteFilmLibraryById  {}",id,e);
			map.put("state",-1);
		}
		return map;
	}
	/**
	 * 
	 **/
	@RequestMapping("to_update")
	public String toUpdateFilmLibrary(Integer id,Model model) throws Exception {
		FilmLibrary result = filmLibraryServiceImpl.selectFilmLibraryById(id);
		model.addAttribute("item",result);
		List<Area> list = settingService.queryAllCityByRedis();
		model.addAttribute("citys",list);
		return "filmLibrary/updateFilmLibrary";
	}

	/**
	 * 更新
	 **/
	@RequestMapping("update")
	@ResponseBody
	public Object updateFilmLibraryById(FilmLibrary filmLibrary) throws Exception {
		Map<String,Object> map = new HashMap<>();
		try {
			log.info("updateFilmLibraryById  {}",filmLibrary);
			filmLibraryServiceImpl.updateFilmLibraryById(filmLibrary);
			map.put("state",0);
		} catch(Exception e) {
			log.error("updateFilmLibraryById  {}",filmLibrary,e);
			map.put("state",-1);
		}
		return map;
	}

	/**
	 * 分页，这里建议使用插件（com.github.pagehelper.PageHelper）
	 **/
	@RequestMapping("list")
	public String findFilmLibraryList(FilmLibrary filmLibrary,Model model, HttpServletRequest request) {
		try {
			log.info("findFilmLibraryList  {}",filmLibrary);
			MidlandHelper.doPage(request);
			Page<FilmLibrary> result = (Page<FilmLibrary>)filmLibraryServiceImpl.findFilmLibraryList(filmLibrary);
			Paginator paginator=result.getPaginator();
			model.addAttribute("paginator",paginator);
			model.addAttribute("items",result);
		} catch(Exception e) {
			log.error("findFilmLibraryList  {}",filmLibrary,e);
			model.addAttribute("paginator",null);
			model.addAttribute("items",null);
		}
		return "filmLibrary/filmLibraryList";
	}
}
