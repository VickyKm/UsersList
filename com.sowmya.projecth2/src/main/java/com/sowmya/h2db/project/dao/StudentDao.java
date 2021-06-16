package com.sowmya.h2db.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.sowmya.h2db.project.Controller.StudentController;
import com.sowmya.h2db.project.pojo.Student;

@Repository
public class StudentDao {
	

		@Autowired
		JdbcTemplate  jdbcTemplate;
		
		@Value( "${createstudent.query}" )
		String createUserQuery;

		@Value("${updatestudent.query}")
		String updateUserQuery;

	    @Value("${deletestudent.query}")
		String deleteUserQuery;
		
	    @Value("${getstudent.query}")
		String getUserQuery;
	    @Value("${student.query}")
		String UserQuery;
	public void createstudent(Student student) {
					jdbcTemplate.update(createUserQuery,student.getId(),student.getName(),student.getGender(),student.getEmail(),student.getDept(),student.getCgpa(),student.getPlacement(),student.getArrears());
		
	}
	public void updatestudent(Integer id,Student student) {
	       
	        jdbcTemplate.update(updateUserQuery,student.getId(), student.getName(),
	                 student.getGender(), student.getEmail(), student.getDept(),student.getCgpa(),student.getPlacement(),student.getArrears(),id);
	        System.out.println("Updated Record with ID = " + student.getId() );
	    }
	
	  
	    public void deletestudent(Integer id,Student student){
		         jdbcTemplate.update(deleteUserQuery,id);
		         System.out.println("Deleted Sucessfully");
	    }
	   
	  /*  public Student getStudent(final int id) {
			@SuppressWarnings("deprecation")
			Student student = jdbcTemplate.queryForObject("select * from student where id = ?", new Object[] { id },
					new StudentRowMapper());
			return student;
		}
	   
	/*	public List<Student> getStudents() {
			List<Student> students = jdbcTemplate.query("select * from student", new StudentRowMapper());
		return students;
		}*/
		
	
public List<Student> getStudents(){
		       

		        return jdbcTemplate.query(UserQuery, BeanPropertyRowMapper.newInstance(Student.class));
		    }

		    
		 
			public Student getStudent(int id) {


		        return jdbcTemplate.query(getUserQuery,
		                BeanPropertyRowMapper.newInstance(Student.class),id).get(0);
		    }
		
		  
    public void updatestudent(String dept,int id, JdbcTemplate namedParameterjdbcTemplate) {
    	MapSqlParameterSource  paramSource = new MapSqlParameterSource();
    	paramSource.addValue("branch",dept); 
    	paramSource.addValue("id",id);
   
    	namedParameterjdbcTemplate.update(updateUserQuery,paramSource);
    }

	
}