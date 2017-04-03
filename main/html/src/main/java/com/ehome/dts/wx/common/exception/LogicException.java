package com.ehome.dts.wx.common.exception;

import org.springframework.http.HttpStatus;

public class LogicException  extends Exception{
	private static final long serialVersionUID = -8201589350356820794L;
	public HttpStatus status;
	public String message;
	public LogicException(String message) {
		this.status = HttpStatus.INTERNAL_SERVER_ERROR;
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
