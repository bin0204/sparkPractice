package com.spark;

public class CsvFile2 {
	private int no = 0;
	private String title = null;
	private int id = 0;
	private int score = 0;
	private String date = null;
	
	public CsvFile2() {
		super();
	}
	
	

	public CsvFile2(int no, String title, int id, int score, String date) {
		super();
		this.no = no;
		this.title = title;
		this.id = id;
		this.score = score;
		this.date = date;
	}



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
