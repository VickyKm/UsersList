package com.srishti.demodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.srishti.demodb.pojo.Student;

public class StudentMapper implements RowMapper<Object> {  
 public Student mapRow(ResultSet rs, int rowNum) throws SQLException {  
  Student student = new Student();  
  student.setId(rs.getInt("id"));  
  student.setName(rs.getString("name"));  
  student.setAge(rs.getInt("age"));  
  student.setGender(rs.getString("gender").charAt(0));
  student.setEmailId(rs.getString("email"));
  student.setDepartment(rs.getString("department"));
  student.setCity(rs.getString("city")); 
  return student;  
 }  
}  
