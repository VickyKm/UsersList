package com.vicky.springbootdemo.dao;

import com.vicky.springbootdemo.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("user")
public class CreateStudentController {
	
	@Autowired
	CreateStudentDAO createStudentDao;
	
	@PostMapping(path = "/createUser")
	public String createStudent(@RequestBody CreateStudent student) {
		
   createStudentDao.addUser(student.getName(),student.getGender(),student.getEmail(),student.getDept(),student.getCgpa(),student.getPlacement(),student.getArrears());
   
   return "Student " + student.getName() + " Successfully";	
	}
	
	@DeleteMapping(path="/deleteUser/{id}")
	public String  deleteStudent(@PathVariable("id") String id) {
		
		createStudentDao.deleteUser(id);
		return "student " + id + "  deleted  successfully"; 
		
	}
	
	//NamedParameter
	@DeleteMapping(path="/deleteUser1/{id}")
	public String  deleteStudent1(@PathVariable("id") String id) {
		
		createStudentDao.deleteUser1(id);
		return "student " + id + "  deleted  successfully"; 
		
	}
	
	//PreparedStatementSetter
	@DeleteMapping(path="/deleteUser2/{id}")
	public String  deleteStudent2(@PathVariable("id") String id) {
		
		createStudentDao.deleteUser2(id);
		return "student " + id + "  deleted  successfully"; 
		
	}
	
	
	@PutMapping(path="/updateUser/{id}")
	public String updateStudent(@RequestBody CreateStudent student,@PathVariable("id") String id) {
		createStudentDao.updateUser(student.getName(),student.getId());
		return "student " + student.getName() + " Updated Successfully"; 
		}
	
	
	//NamedParameter
		@PutMapping(path="/updateUser1/{id}")
	public String updateStudent1(@RequestBody CreateStudent student,@PathVariable("id") String id) {
		createStudentDao.updateUser1(student.getName(),student.getId());
		return "student " + student.getName() + " Updated Successfully"; 
		}
	
	//PreparedStatementSetter
	@PutMapping(path="/updateUser2/{id}")
	public String updateStudent2(@RequestBody CreateStudent student,@PathVariable("id") String id) {
		createStudentDao.updateUser2(student.getName(),student.getId());
		return "student " + student.getName() + " Updated Successfully"; 
		}
	
	
}
