package com.kh.model.vo;

import java.sql.Date;

public class RentBook {
	private String book_code;
	private String rent_title;
	private String rent_member;
	private Date rent_date;
	
	
	
	public RentBook(String book_code, String rent_title, String rent_member, Date rent_date) {
		super();
		this.book_code = book_code;
		this.rent_title = rent_title;
		this.rent_member = rent_member;
		this.rent_date = rent_date;
	}

	

	public String getBook_code() {
		return book_code;
	}



	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}



	public String getRent_title() {
		return rent_title;
	}

	public void setRent_title(String rent_title) {
		this.rent_title = rent_title;
	}

	public String getRent_member() {
		return rent_member;
	}

	public void setRent_member(String rent_member) {
		this.rent_member = rent_member;
	}

	public Date getRent_date() {
		return rent_date;
	}

	public void setRent_date(Date rent_date) {
		this.rent_date = rent_date;
	}
	
	@Override
	public String toString() {
		return book_code + "\t" + rent_title + "\t" + rent_member + "\t" + rent_date;
	}
	
	
	
	
	
	
	
}
