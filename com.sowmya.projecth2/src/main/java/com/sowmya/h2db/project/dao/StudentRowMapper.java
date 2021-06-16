package com.sowmya.h2db.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
/*
public class StudentRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}*/


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sowmya.h2db.project.pojo.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int row) throws SQLException {
		//return new Student();
	return	new Student(rs.getInt("id"), rs.getString("name"), rs.getString("gender"), rs.getString("email"),
                rs.getString("dept"), rs.getString("cgpa"), rs.getString("placement"),rs.getInt("arrears"));

	}

}