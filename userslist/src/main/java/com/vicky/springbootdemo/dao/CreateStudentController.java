package com.vicky.springbootdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateStudentController {
	
	@Autowired
	CreateStudentDAO createStudentDao;
	
	@PostMapping(path = "/createUser")
	public String createStudentDao(@RequestBody Student student) {
	
		//createStudentDao.addUser(id,name,gender,);
		createStudentDao.addUser(student.getName(),student.getGender(), student.getEmail(), student.getDept(), student.getCgpa(), student.getPlacement(), student.getArrears());
		return "Student " + student.getName() + " added successfully";
	}
	
	
	@DeleteMapping(path="/deleteuser/{id}")
	public String deleteStudent(@PathVariable String id) {
		createStudentDao.deleteUser2(id);
		return "Student " + id + " deleted successfully";
	}
	
	
	
	@PutMapping(path="/updateUser/{id}")
    public String updateStudent(@RequestBody Student student,@PathVariable("id") String id) {
        createStudentDao.updateUser2(student.getName(),student.getId());
        return "student " + student.getName() + " Updated Successfully";
        }
   
    
    /*@PutMapping(path="/updateuser1/{id}")
    public String updateUser1(@PathVariable String id, @RequestBody Student student){
        createStudentDao.updateuser1(student.getName(), id);
        return "Student " + id + " updated successfully";
    }*/
   
   /* @GetMapping("/students")
    public List<Student> findAllStudents(){
        List<Student> list = createStudentDao.findAllStudents();
        return list;
    }*/
}



