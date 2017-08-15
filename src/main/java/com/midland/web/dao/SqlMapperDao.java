package com.midland.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by 'ms.x' on 2017/8/15.
 */
@Repository
public class SqlMapperDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int doSql(String sql){
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}
	
}
