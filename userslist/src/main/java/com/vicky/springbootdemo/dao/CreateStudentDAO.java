package com.vicky.springbootdemo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Service;

import com.vicky.springbootdemo.pojo.*;
@Service
public class CreateStudentDAO {
	
	
	private DataSource datasource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	JdbcTemplate jdbctemplate;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Value("${createuser.query}")
	String insertQuery;
	
	

	
	public void addUser(String name, String gender, String email, String dept, String cgpa,  String placement, String arrears) {
		
		jdbctemplate.update(insertQuery, name,gender,email,dept,cgpa,placement,arrears);
	}


	@Value("${deleteuser.query}")
	String deleteQuery;

	public void deleteUser(String id) {
		
		jdbctemplate.update(deleteQuery, id);
		
	}

	
	@Value("${updateuser.query}")
	String updateQuery;
	

	public void updateUser(String name,String id) {
	jdbctemplate.update(updateQuery, name,id); 
	
	}
	
	
	//NamedParameter 
	public void deleteUser1(String id) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id",id);

		namedParameterJdbcTemplate.execute(deleteQuery,map,new PreparedStatementCallback<Object>() {
		@Override
		public Object doInPreparedStatement(PreparedStatement ps)
		throws SQLException, DataAccessException {
		return ps.executeUpdate();
		}
		});
		}
	
	
	public void updateUser1(String name,String id) {
		Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("name", name);
		map.put("id", id);
		
		 namedParameterJdbcTemplate.execute(updateQuery,map,new PreparedStatementCallback<Object>() {  
		    @Override  
		    public Object doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		        return ps.executeUpdate();  
		    }  
		});  
	}
	
	
	
	//PreparedStatementSetter 
	public void deleteUser2(String id) {
		jdbctemplate.update(deleteQuery, new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, id); 
			}
		});
	}
	
	
	public void updateUser2(String name, String id) {
		jdbctemplate.update(updateQuery, new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, name);
				ps.setString(2, id);
			}
		});
	}
	 
	
	
	
	
	
	
}
	

	

