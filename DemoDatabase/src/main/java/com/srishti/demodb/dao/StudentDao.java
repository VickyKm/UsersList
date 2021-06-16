package com.srishti.demodb.dao;

import java.util.List;

//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.srishti.demodb.mapper.StudentMapper;
import com.srishti.demodb.pojo.Student;

@Repository
public class StudentDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate template;
	
	@Value("${insert.query}")
	String insert;
	
	@Value("${update.query}")
	String update;
	
	@Value("${delete.query}")
	String delete;
	
	@Value("${get.query}")
	String get;
	
	@Value("${getall.query}")
	String getall;

	
	public void insertValue(Student stud) {
        jdbcTemplate.update(insert, stud.getId(), stud.getName(),
                stud.getAge(), stud.getGender(), stud.getEmail(), stud.getDepartment(),stud.getCity());
        System.out.println("The name is of the added entry is"+" "+stud.getName());
    }
	public void updateValue(Integer id,Student stud) {
		jdbcTemplate.update(update,stud.getId(), stud.getName(),
                stud.getAge(), stud.getGender(), stud.getEmail(), stud.getDepartment(),stud.getCity(),id);
		System.out.println("Updated Record with ID = " + stud.getId() );
	}
	public void deleteValue(Integer id,Student stud) {
		jdbcTemplate.update(delete,id);
		System.out.println(stud.getName()+" "+"Record Deleted");
	}
	/* Using namedparam
    public Map<String, Object> getValue(Integer id) {
			MapSqlParameterSource mapParameters = new MapSqlParameterSource();
			mapParameters.addValue("id", id);
			return template.queryForMap(get, mapParameters);	
	}
	public List<Map<String, Object>> getAllValue(){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.getValues();
		//return template.queryForMap(getall, parameters);
		return template.queryForList(getall,parameters);
	}*/
	
	public Student getValue(Integer id) {
		Student student = (Student) jdbcTemplate.query(get, new StudentMapper(),id ).get(0);
		    return student;
	}
	public List<Student> getAllValue(){
		  return (jdbcTemplate.query(getall,
		   new BeanPropertyRowMapper<Student>(Student.class)));
		}
}
