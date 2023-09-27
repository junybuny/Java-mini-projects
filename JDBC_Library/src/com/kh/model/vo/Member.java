package com.kh.model.vo;

public class Member {
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private int mem_age;
	private String mem_phone;
	private String mem_address;
	
	// Alt + Shift + s + o
	public Member(String mem_id, String mem_pwd, String mem_name, int mem_age, String mem_phone, String mem_address) {
		super();
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_name = mem_name;
		this.mem_age = mem_age;
		this.mem_phone = mem_phone;
		this.mem_address = mem_address;
	}

	// Alt + Shift + s + r
	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public int getMem_age() {
		return mem_age;
	}

	public void setMem_age(int mem_age) {
		this.mem_age = mem_age;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_address() {
		return mem_address;
	}

	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}

	// Alt + Shift + s + s
	@Override
	public String toString() {
		return "Member [mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_age=" + mem_age + ", mem_phone="
				+ mem_phone + ", mem_address=" + mem_address + "]";
	}
	
	
	
}