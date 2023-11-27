package com.darden.dardenrestapi.model;

public class Student {
	private long id;
	private String firstName;
	private String role;
	//public Student() {
	//	super();
		// TODO Auto-generated constructor stub
	//}
	public Student(long id, String firstName, String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.role = role;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
