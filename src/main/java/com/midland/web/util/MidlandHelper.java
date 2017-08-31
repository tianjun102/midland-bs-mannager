package com.midland.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.midland.web.enums.ContextEnums;
import com.midland.web.model.user.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 'ms.x' on 2017/7/31.
 */
public class MidlandHelper {
	
	private static final String COMMON_DATE = "yyyy-MM-dd hh:mm:ss";

	public static String getCurrentTime(){
		long intTime = System.currentTimeMillis();
		DateFormat format = new SimpleDateFormat(COMMON_DATE);
		return format.format(intTime);
	}
	
	
	/**
	 * request 包含 pageNo，pageSize
	 * @param request
	 */
	public  static void doPage(HttpServletRequest request) {
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		
		if(pageNo==null||pageNo.equals("")){
			pageNo = ContextEnums.PAGENO;
		}
		if(pageSize==null||pageSize.equals("")){
			
			pageSize = ContextEnums.PAGESIZE;
		}
		PageHelper.startPage(Integer.valueOf(pageNo),Integer.valueOf(pageSize));
	}

	/**
	 *
	 * @param str
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List getPojoList(String str, Class<T> clazz)  {
		List resList = new ArrayList<T>();
		JSONObject rootJsonObject = null;
		try {
			rootJsonObject = JSON.parseObject(str);
		}catch (Exception e){
			return null;
		}
		String messageStr;
		if(rootJsonObject!=null && rootJsonObject.getString("STATE").equals("SUCCESS")){
			messageStr = rootJsonObject.getString("DATA");
		}else{
			return null;
		}

		List lists = JSON.parseObject(messageStr,List.class);
		for (Object obj : lists){
			T t = JSON.parseObject(obj.toString(),clazz);
			resList.add(t);
		}
		return resList;
	}


	/**
	 *
	 * @param str
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T getPojo(String str, Class<T> clazz)  {
		JSONObject rootJsonObject = JSON.parseObject(str);
		String messageStr = rootJsonObject.getString("data");
		T t = JSON.parseObject(messageStr,clazz);
		return t;
	}
	
	
	
	
	public static List<String> getStringRemoveEmpty(String ids){
		if (StringUtils.isEmpty(ids)){
			return null;
		}
		String[] array = ids.split(",");
		List<String> list = new ArrayList<>();
		for (String str : array){
			if (StringUtils.isNotEmpty(str)){
				list.add(str);
			}
		}
		return list;
	}
	
	public static User getCurrentUser(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("userInfo");
		return user;
	}
	
	public static String getNameById(Integer id, List<ParamObject> paramObjects) {
		String source = null;
		for (ParamObject paramObject : paramObjects){
			if (paramObject.getId().equals(String.valueOf(id))){
				source=paramObject.getName();
				break;
			}
		}
		return source;
	}
	
	
}
