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
	
	public void addUser(String name, String gender, String email, String dept, String cgpa, String placement, String arrears) {
		
		jdbctemplate.update(insertQuery,name,gender,email,dept,cgpa,placement,arrears);
	}
	
	@Value("${deleteuser.query}")
	String deleteQuery;
	public void deleteuser(String id) {
		jdbctemplate.update(deleteQuery,id);
	}
	
	@Value("${updateuser.query}")
    String updateQuery;
   
    public void updateUser(String name, String gender, String email, String dept, String cgpa, String placement, String arrears, String id){
        jdbctemplate.update(updateQuery,name,gender,email,dept,cgpa,placement,arrears,id);
    }
}
