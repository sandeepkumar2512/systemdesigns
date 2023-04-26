package com.example.systemdesigns.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Department {
	private int id;
	private String name;
	private String code;
	private String dptHead;
	public Department(int id, String name, String code, String dptHead) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.dptHead = dptHead;
	}
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDptHead() {
		return dptHead;
	}
	public void setDptHead(String dptHead) {
		this.dptHead = dptHead;
	}
	
}
