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
	
	@DeleteMapping(path="/createUser/{id}")
	public String  deleteStudent(@PathVariable("id") String id) {
		
		createStudentDao.deleteUser(id);
		return "student " + id + "  deleted  successfully";
		
	}
	
	@PutMapping(path="/createUser/{id}")
	public String updateStudent(@RequestBody CreateStudent student,@PathVariable("id") String id) {
		createStudentDao.updateUser(student.getName(),student.getId());
		return "student " + student.getName() + " Updated Successfully"; 
		}
	
}
