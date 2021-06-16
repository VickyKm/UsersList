package com.srishti.demodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srishti.demodb.dao.StudentDao;
import com.srishti.demodb.pojo.Student;

@RestController
public class DemoDatabaseController {
	@Autowired
	StudentDao studentDao;
	@PostMapping("/addValue")
	public String addValue(@RequestBody Student student){
	    studentDao.insertValue(student);
		System.out.println(student.getName());
		return student.getName()+"\'s "+ "department is " + student.getDepartment();
	}
	@PutMapping("/updateValue/{id}")
	public String updateValue(@PathVariable("id") Integer id, @RequestBody Student student) {
		studentDao.updateValue(id,student);
		return student.getId()+" "+ "value updated";
	}
	@DeleteMapping("deleteValue/{id}")
	public String deleteValue(@PathVariable("id") Integer id, @RequestBody Student student) {
		studentDao.deleteValue(id, student);
		return student.getName()+" "+"record deleted";  
	}
	/*@GetMapping("/getValue")
	public  Map<String, Object> getValue(@RequestParam Integer id) {
		return (studentDao.getValue(id));
		// return "Fetched";
	}
	@GetMapping("/getAllValue")
	public List<Map<String, Object>> getAllValue(){
		return (studentDao.getAllValue());
	}*/
	@GetMapping("/getValue")
	public Student getValue(@RequestParam Integer id) {
		return (studentDao.getValue(id));
		// return "Fetched";
	}
	@GetMapping("/getAllValue")
	public  List<Student> getAllValue(){
		return (studentDao.getAllValue());
	}
}
