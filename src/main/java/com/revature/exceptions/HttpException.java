package com.revature.exceptions;

public class HttpException extends RuntimeException {
	private String message;
	private int statusCode;
	public HttpException(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
