package com.spark;

import java.io.Serializable;

public class Member1 implements Serializable{//����ȭ
	//�ʵ� ����
	private String id = null;
	private int age = 0;
	private String tel = null;
	
	//�⺻ ������ �߰�
	public Member1() {
		super();
	}
	//������ �߰�
	public Member1(String id, int age, String tel) {
		super();
		this.id = id;
		this.age = age;
		this.tel = tel;
	}
	
	//get, setter �����
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
