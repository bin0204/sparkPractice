package com.spark;

import java.io.Serializable;

public class Member1 implements Serializable{//직렬화
	//필드 생성
	private String id = null;
	private int age = 0;
	private String tel = null;
	
	//기본 생성자 추가
	public Member1() {
		super();
	}
	//생성자 추가
	public Member1(String id, int age, String tel) {
		super();
		this.id = id;
		this.age = age;
		this.tel = tel;
	}
	
	//get, setter 만들기
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
