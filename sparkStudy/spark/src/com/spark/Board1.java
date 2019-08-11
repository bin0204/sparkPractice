package com.spark;

public class Board1 {
	private int no = 0;
	private String title = null;
	private String content = null;
	private String writer = null;
	private int hit = 0;
	private String date = null;
	
	//�⺻ ������
	public Board1() {
	}
	
	public Board1(int no, String title, String content, String writer, int hit, String date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hit = hit;
		this.date = date;
	}
	
	//get/setter 
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	//toString
	@Override //���� get�� ���ص� �̰��� ����� ������ Ȯ���� �� �ִ�
	public String toString() {
		return "Board1 [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", hit=" + hit
				+ ", date=" + date + "]";
	}
}
