package com.sowmya.h2db.project.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.sowmya.h2db.project.dao.StudentDao;
import com.sowmya.h2db.project.pojo.Student;
@RestController
public class StudentController {
	
	
	@Autowired
	StudentDao studentDao;


		@PostMapping("/createstudent")
		public String createstudent(@RequestBody Student student) {
		
			studentDao.createstudent(student);
			return "Student data created Successfully";
		}

		
			@DeleteMapping("/deletestudent/{id}")
			public String deletestudent(@PathVariable("id") Integer id, @RequestBody Student student ) {
				// TODO: delete logic goes here
				studentDao.deletestudent(id,student);
				return " delete student data from database.";
				 
			} 
	 
		@PutMapping("/updatestudent/{id}")
	    public String updatestudent(@PathVariable("id") Integer id, @RequestBody Student student) {
	        studentDao.updatestudent(id,student);
	        return student.getId()+" "+ "value updated";
	    }
	
	/*	@GetMapping("/student/{id}")
	
			public Student getStudent(@PathVariable int id, @RequestBody Student student) {
			studentDao.getStudent(id);
			
			return student;
		}*/

@GetMapping(value="/student")
@ResponseBody
public Student getstudent(@RequestParam("id") int id, @RequestBody Student student){
	//return "student with id= "+id;
	studentDao.getStudent(id);
	return student;
}
	@GetMapping("/students")
	
		public List<Student> getStudent(@RequestBody Student student) {
			List<Student> students = studentDao.getStudents();
		
			return students;
		}
}
		
