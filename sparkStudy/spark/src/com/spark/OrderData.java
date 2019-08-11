package com.spark;

public class OrderData {
	private int ordNum = 0;
	private String order = null;
	private int ordQty = 0;
	private int itmNum = 0;
	private String ordDate = null;
	
	
	public OrderData(int ordNum, String order, int ordQty, int itmNum, String ordDate) {
		super();
		this.ordNum = ordNum;
		this.order = order;
		this.ordQty = ordQty;
		this.itmNum = itmNum;
		this.ordDate = ordDate;
	}
	public int getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(int ordNum) {
		this.ordNum = ordNum;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getOrdQty() {
		return ordQty;
	}
	public void setOrdQty(int ordQty) {
		this.ordQty = ordQty;
	}
	public int getItmNum() {
		return itmNum;
	}
	public void setItmNum(int itmNum) {
		this.itmNum = itmNum;
	}
	public String getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	
	
}
