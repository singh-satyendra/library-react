package com.ibm.library.common.aop;

import java.util.Date;

/**
 * @author 
 * 
 * This class is used to send the error response to the caller i.e. front end system
 *
 */

public class ErrorResponseMessage {
	
	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	  	  
	public ErrorResponseMessage() {
		  
	}

	public ErrorResponseMessage(int status, String message, String path) {
		this.timestamp = new Date();
		this.status = status;
		this.error = "";
		this.message = message;
		this.path = path;
	}
	
	public ErrorResponseMessage(int status, String error, String message, String path) {
		this.timestamp = new Date();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}