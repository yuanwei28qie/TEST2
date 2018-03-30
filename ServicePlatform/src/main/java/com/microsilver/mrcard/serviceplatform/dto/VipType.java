package com.microsilver.mrcard.serviceplatform.dto;

import java.io.Serializable;

public class VipType implements Serializable{
	private int id;
	private String name;
	private String costPrice;
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
	public String getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}
}
