package com.microsilver.mrcard.cloud.finance.dto;

public class RespBaseDto<T> {
	private int state = 0;
	private String message;
	private T data;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
