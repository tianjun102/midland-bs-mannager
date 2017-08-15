package com.midland.web.service;

import com.midland.web.dao.SqlMapperDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 'ms.x' on 2017/8/15.
 */
@Service
public class JdbcService {
	@Autowired
	private SqlMapperDao sqlMapperDao;
	public int doSql(String sql){
		return sqlMapperDao.doSql(sql);
	}
	
	public int shiftUp(String orderByColumn, String tableName, int orderByParam){
		StringBuffer sb = new StringBuffer("SELECT ").append(orderByColumn)
				.append(" from ").append(tableName).append(" where ").append(orderByColumn)
				.append("<").append(orderByColumn).append(" order by ")
				.append(orderByColumn).append(" desc limit 1");
		
		return doSql(sb.toString());
	}
	
	
	public int shiftDown(String orderByColumn, String tableName, int orderByParam){
		StringBuffer sb = new StringBuffer("SELECT ").append(orderByColumn)
				.append(" from ").append(tableName).append(" where ").append(orderByColumn)
				.append(">").append(orderByColumn).append(" order by ")
				.append(orderByColumn).append(" asc limit 1");
		return doSql(sb.toString());
		
	}
	
	
	public int stickly(String orderByColumn, String tableName, int orderByParam){
		StringBuffer sb = new StringBuffer("SELECT ").append(orderByColumn)
				.append("-1 from ").append(tableName).append(" order by ")
				.append(orderByColumn).append(" asc limit 1");
		return doSql(sb.toString());
	}
	
}
