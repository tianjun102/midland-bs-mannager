package com.midland.web.controller;

import com.midland.web.model.Area;
import com.midland.web.model.Category;
import com.midland.web.model.Menu;
import com.midland.web.service.CategoryService;
import com.midland.web.controller.base.BaseController;
import com.midland.web.service.JdbcService;
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
@RequestMapping("/category/")
public class CategoryController extends BaseController  {

	private Logger log = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private CategoryService categoryServiceImpl;
	@Autowired
	private SettingService settingService;
	@Autowired
	private JdbcService jdbcService;
	/**
	 * 分类控制层
	 **/
	@RequestMapping("index")
	public String categoryIndex(Category category,Model model) throws Exception {
		Map<String,String> parem = new HashMap<>();
		parem.put("flag","city");
		parem.put("id","*");
		Map<String, List<Area>> cityMap = settingService.queryCityByRedis(parem);
		List<Area> cityList = cityMap.get("city");
		model.addAttribute("cityList",cityList);
		return "category/categoryIndex";
	}

	/**
	 * 
	 **/
	@RequestMapping("to_add")
	public String toAddCategory(Category category,Model model) throws Exception {
		Map<String,String> parem = new HashMap<>();
		parem.put("flag","city");
		parem.put("id","*");
		Map<String, List<Area>> cityMap = settingService.queryCityByRedis(parem);
		List<Area> cityList = cityMap.get("city");
		model.addAttribute("cityList",cityList);
		return "category/addCategory";
	}

	/**
	 * 新增
	 **/
	@RequestMapping("add")
	@ResponseBody
	public Object addCategory(Category category) throws Exception {
		Map map = new HashMap<>();
		try {
			log.info("addCategory {}",category);
			categoryServiceImpl.insertCategory(category);
			map.put("state",0);
		} catch(Exception e) {
			log.error("addCategory异常 {}",category,e);
			map.put("state",-1);
		}
		return map;
	}

	/**
	 * 查询
	 **/
	@RequestMapping("get_category")
	public String getCategoryById(Integer id,Model model) {
		log.info("getCategoryById  {}",id);
		Category result = categoryServiceImpl.selectCategoryById(id);
		model.addAttribute("item",result);
		return "category/updateCategory";	}

	/**
	 * 删除
	 **/
	@RequestMapping("delete")
	@ResponseBody
	public Object deleteCategoryById(Integer id)throws Exception {
		Map map = new HashMap<>();
		try {
			log.info("deleteCategoryById  {}",id);
			categoryServiceImpl.deleteCategoryById(id);
			map.put("state",0);
		} catch(Exception e) {
			log.error("deleteCategoryById  {}",id,e);
			map.put("state",-1);
		}
		return map;
	}
	/**
	 * 
	 **/
	@RequestMapping("to_update")
	public String toUpdateCategory(Integer id,Model model) throws Exception {
		Map<String,String> parem = new HashMap<>();
		parem.put("flag","city");
		parem.put("id","*");
		Map<String, List<Area>> cityMap = settingService.queryCityByRedis(parem);
		List<Area> cityList = cityMap.get("city");
		Category result = categoryServiceImpl.selectCategoryById(id);
		model.addAttribute("cityList",cityList);
		model.addAttribute("item",result);
		return "category/updateCategory";
	}

	/**
	 * 更新
	 **/
	@RequestMapping("update")
	@ResponseBody
	public Object updateCategoryById(Category category) throws Exception {
		Map map = new HashMap<>();
		try {
			log.info("updateCategoryById  {}",category);
			categoryServiceImpl.updateCategoryById(category);
			map.put("state",0);
		} catch(Exception e) {
			log.error("updateCategoryById  {}",category,e);
			map.put("state",-1);
		}
		return map;
	}

	/**
	 * 分页，这里建议使用插件（com.github.pagehelper.PageHelper）
	 **/
	@RequestMapping("list")
	public String findCategoryList(Category category,Model model, HttpServletRequest request) {
		try {
			log.info("findCategoryList  {}",category);
			MidlandHelper.doPage(request);
			Page<Category> result = (Page<Category>)categoryServiceImpl.findCategoryList(category);
			Paginator paginator=result.getPaginator();
			model.addAttribute("paginator",paginator);
			model.addAttribute("items",result);
		} catch(Exception e) {
			log.error("findCategoryList  {}",category,e);
			model.addAttribute("paginator",null);
			model.addAttribute("items",null);
		}
		return "category/categoryList";
	}


	@RequestMapping("sort")
	@ResponseBody
	public Map listDesc(Category category, int sort, Model model, HttpServletRequest request) throws Exception {
		String primaryKeyName="id";
		String primaryParam=String.valueOf(category.getId());
		String tableName="category";
		String orderByColumn="order_by";
		String orderByParam=String.valueOf(category.getOrderBy());
		jdbcService.listDesc(primaryKeyName,primaryParam,orderByColumn,tableName,orderByParam,sort);
		Map map = new HashMap();
		map.put("state",0);
		return map;
	}

}


