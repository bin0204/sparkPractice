package com.spark;

import java.io.Serializable;

public class Person1 implements Serializable{
	
	private double height = 0L; 
	private double weight = 0L;
	private int age = 0;
	private double label = 0L; //성별
	
	
	public Person1() {
		super();
	}
	
	public Person1(double height, double weight, int age, double label) {
		super();
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.label = label;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getLabel() {
		return label;
	}
	public void setLabel(double label) {
		this.label = label;
	}
	
	
}
