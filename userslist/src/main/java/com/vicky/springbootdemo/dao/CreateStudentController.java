package com.vicky.springbootdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateStudentController {
	
	@Autowired
	CreateStudentDAO createStudentDao;

	@PostMapping(path = "/createUser")
	public String createStudent(@RequestParam String id, @RequestParam String name, @RequestParam String email) {
		
		createStudentDao.addUser("INSERT INTO STUDENT VALUES ('" + id + "' , '" + name + "' , '" + email + "')");
		return "Student " + name + " added successfully";
	}
}
