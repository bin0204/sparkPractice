package com.spark;

import java.io.Serializable;

public class ScoreData implements Serializable {
	//필드 생성
	private String name = null;
	private String schoolLevel = null;
	private int koreanScore = 0;
	private int mathScore = 0;
	private int engScore = 0;
	
	public ScoreData() {
		super();
	}
	public ScoreData(String name, String schoolLevel, int koreanScore, int mathScore, int engScore) {
		super();
		this.name = name;
		this.schoolLevel = schoolLevel;
		this.koreanScore = koreanScore;
		this.mathScore = mathScore;
		this.engScore = engScore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchoolLevel() {
		return schoolLevel;
	}
	public void setSchoolLevel(String schoolLevel) {
		this.schoolLevel = schoolLevel;
	}
	public int getKoreanScore() {
		return koreanScore;
	}
	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}	
}
