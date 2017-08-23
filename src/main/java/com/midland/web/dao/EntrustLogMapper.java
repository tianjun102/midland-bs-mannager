package com.midland.web.dao;

import com.midland.web.model.EntrustLog;
import java.util.List;

public interface EntrustLogMapper {

	EntrustLog selectEntrustLogByEntrustLogId(Integer entrustLogId);
	List<EntrustLog> selectEntrustLogByEntrustId(Integer entrustId);

	int deleteEntrustLogByEntrustLogId(Integer entrustLog);

	int updateEntrustLogByEntrustLogId(EntrustLog entrustLog);

	int insertEntrustLog(EntrustLog entrustLog);

	List<EntrustLog> findEntrustLogList(EntrustLog entrustLog);

}
