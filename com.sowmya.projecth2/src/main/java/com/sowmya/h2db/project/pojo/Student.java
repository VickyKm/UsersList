package com.sowmya.h2db.project.pojo;

public class Student {
	private Integer id;
	private String name;
	private String gender;
	private String email;
	private String dept;
	private String cgpa;
	private String placement;
	private Integer arrears;

public Student() {
	
}
	public Student(int id, String name, String gender, String email, String dept, String cgpa,
			String placement, int arrears) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.email=email;
		this.dept=dept;
		this.cgpa=cgpa;
		this.placement=placement;
		this.arrears=arrears;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCgpa() {
		return cgpa;
	}
	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}
	public String getPlacement() {
		return placement;
	}
	public void setPlacement(String placement) {
		this.placement = placement;
	}
	public Integer getArrears() {
		return arrears;
	}
	public void setArrears(Integer arrears) {
		this.arrears = arrears;
	}
	
	
}
