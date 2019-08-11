package com.spark;

import java.io.Serializable;

public class ItemData implements Serializable{
	//필드 생성
	private int itmNum = 0;
	private String itmName = null;
	private int itmPrice = 0;
	private int itmQty = 0;
	private String itmDate = null;
	
	
	public ItemData(int itmNum, String itmName, int itmPrice, int itmQty, String itmDate) {
		super();
		this.itmNum = itmNum;
		this.itmName = itmName;
		this.itmPrice = itmPrice;
		this.itmQty = itmQty;
		this.itmDate = itmDate;
	}
	public int getItmNum() {
		return itmNum;
	}
	public void setItmNum(int itmNum) {
		this.itmNum = itmNum;
	}
	public String getItmName() {
		return itmName;
	}
	public void setItmName(String itmName) {
		this.itmName = itmName;
	}
	public int getItmPrice() {
		return itmPrice;
	}
	public void setItmPrice(int itmPrice) {
		this.itmPrice = itmPrice;
	}
	public int getItmQty() {
		return itmQty;
	}
	public void setItmQty(int itmQty) {
		this.itmQty = itmQty;
	}
	public String getItmDate() {
		return itmDate;
	}
	public void setItmDate(String itmDate) {
		this.itmDate = itmDate;
	}
	
	
}
