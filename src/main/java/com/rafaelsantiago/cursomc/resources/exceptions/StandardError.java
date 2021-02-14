package com.rafaelsantiago.cursomc.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String name;
	private Long timeStamp;
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public StandardError(Integer status, String name, Long timeStamp) {
		super();
		this.status = status;
		this.name = name;
		this.timeStamp = timeStamp;
	}
}
