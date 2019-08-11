package com.spark;

public class CsvFile1 {
	
	private int id = 0;
	private String name = null;
	private int age = 0;
	private String email = null;
	private String date = null;
	
	
	
	public CsvFile1() {
		super();
	}
	
	public CsvFile1(int id, String name, int age, String email, String date) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
