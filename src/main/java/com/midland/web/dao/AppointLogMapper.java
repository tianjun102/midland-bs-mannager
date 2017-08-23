package com.midland.web.dao;

import com.midland.web.model.AppointLog;
import java.util.List;

public interface AppointLogMapper {

	AppointLog selectAppointLogByAppointLogId(Integer appointLogId);
	List<AppointLog> selectAppointLogByAppointId(Integer appointId);
	
	
	

	int deleteAppointLogByAppointLogId(Integer appointLogId);

	int updateAppointLogByAppointLogId(AppointLog appointLog);

	int insertAppointLog(AppointLog appointLog);

	List<AppointLog> findAppointLogList(AppointLog appointLog);

}
