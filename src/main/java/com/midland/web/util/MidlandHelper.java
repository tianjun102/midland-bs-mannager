package com.midland.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.helpers.DateTimeDateFormat;

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
	 *
	 * @param str
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List getPojoList(String str, Class<T> clazz)  {
		List resList = new ArrayList<T>();
		JSONObject rootJsonObject = JSON.parseObject(str);

		String messageStr = rootJsonObject.getString("DATA");

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
}
