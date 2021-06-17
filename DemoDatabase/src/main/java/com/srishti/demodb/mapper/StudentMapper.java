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
  student.setGender(rs.getString("gender")); 
  student.setEmail(rs.getString("email"));
  student.setDepartment(rs.getString("department"));
  student.setCgpa(rs.getDouble("cgpa"));
  student.setPlacement(rs.getString("placement"));
  student.setArrears(rs.getInt("arrears"));
  return student;  
 }  
}  
