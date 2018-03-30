package com.microsilver.im.client.packet;

public class Content {
	private Integer status;
	private String message;
	private String data;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Content [status=" + status + ", packet=" + message + ", data=" + data + "]";
	}
	
}
