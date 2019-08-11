package com.spark;

public class StudentData {
	private String year = null;
	private String div = null;
	private double maEleHeight = 0L;
	private double feEleHeight = 0L;
	private double maEleWeight = 0L;
	private double feEleWeight = 0L;
	private double maMidHeight = 0L;
	private double feMidHeight = 0L;
	private double maMidWeight = 0L;
	private double feMidWeight = 0L;
	private double maHighHeight = 0L;
	private double feHighHeight = 0L;
	private double maHighWeight = 0L;
	private double feHighWeight = 0L;
	
	public StudentData() {
		super();
	}

	public StudentData(String year, String div, double maEleHeight, double feEleHeight, double maEleWeight,
			double feEleWeight, double maMidHeight, double feMidHeight, double maMidWeight, double feMidWeight,
			double maHighHeight, double feHighHeight, double maHighWeight, double feHighWeight) {
		super();
		this.year = year;
		this.div = div;
		this.maEleHeight = maEleHeight;
		this.feEleHeight = feEleHeight;
		this.maEleWeight = maEleWeight;
		this.feEleWeight = feEleWeight;
		this.maMidHeight = maMidHeight;
		this.feMidHeight = feMidHeight;
		this.maMidWeight = maMidWeight;
		this.feMidWeight = feMidWeight;
		this.maHighHeight = maHighHeight;
		this.feHighHeight = feHighHeight;
		this.maHighWeight = maHighWeight;
		this.feHighWeight = feHighWeight;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public double getMaEleHeight() {
		return maEleHeight;
	}

	public void setMaEleHeight(double maEleHeight) {
		this.maEleHeight = maEleHeight;
	}

	public double getFeEleHeight() {
		return feEleHeight;
	}

	public void setFeEleHeight(double feEleHeight) {
		this.feEleHeight = feEleHeight;
	}

	public double getMaEleWeight() {
		return maEleWeight;
	}

	public void setMaEleWeight(double maEleWeight) {
		this.maEleWeight = maEleWeight;
	}

	public double getFeEleWeight() {
		return feEleWeight;
	}

	public void setFeEleWeight(double feEleWeight) {
		this.feEleWeight = feEleWeight;
	}

	public double getMaMidHeight() {
		return maMidHeight;
	}

	public void setMaMidHeight(double maMidHeight) {
		this.maMidHeight = maMidHeight;
	}

	public double getFeMidHeight() {
		return feMidHeight;
	}

	public void setFeMidHeight(double feMidHeight) {
		this.feMidHeight = feMidHeight;
	}

	public double getMaMidWeight() {
		return maMidWeight;
	}

	public void setMaMidWeight(double maMidWeight) {
		this.maMidWeight = maMidWeight;
	}

	public double getFeMidWeight() {
		return feMidWeight;
	}

	public void setFeMidWeight(double feMidWeight) {
		this.feMidWeight = feMidWeight;
	}

	public double getMaHighHeight() {
		return maHighHeight;
	}

	public void setMaHighHeight(double maHighHeight) {
		this.maHighHeight = maHighHeight;
	}

	public double getFeHighHeight() {
		return feHighHeight;
	}

	public void setFeHighHeight(double feHighHeight) {
		this.feHighHeight = feHighHeight;
	}

	public double getMaHighWeight() {
		return maHighWeight;
	}

	public void setMaHighWeight(double maHighWeight) {
		this.maHighWeight = maHighWeight;
	}

	public double getFeHighWeight() {
		return feHighWeight;
	}

	public void setFeHighWeight(double feHighWeight) {
		this.feHighWeight = feHighWeight;
	}
	
	
}
