package com.vicky.springbootdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentDAO {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Value("${createuser.query}")
	String insertQuery;
	
	public void addUser(String id, String name, String email) {
		
		jdbctemplate.update(insertQuery, id,name,email);
	}
}
