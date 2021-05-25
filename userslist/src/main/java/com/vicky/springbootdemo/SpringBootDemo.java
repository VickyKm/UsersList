package com.vicky.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;

import com.vicky.springbootdemo.dao.CreateStudentDAO;
import com.vicky.springbootdemo.pojo.CreateStudent;  
@SpringBootApplication
public class SpringBootDemo {

	public static void main(String[] args) {
	SpringApplication.run(SpringBootDemo.class, args);
		 
	}
	
}
