package com.vicky.springbootdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentDAO {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	public void addUser(String query) {
		jdbctemplate.update(query);
	}
}
