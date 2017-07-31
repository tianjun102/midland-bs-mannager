package com.midland.web.util;

import org.apache.log4j.helpers.DateTimeDateFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
}
