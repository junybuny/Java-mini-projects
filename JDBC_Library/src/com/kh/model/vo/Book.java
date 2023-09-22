package com.kh.model.vo;

public class Book {
	private String code;
	private String title;
	private String author;
	private String publisher;
	private String rent_TF;
	
	public Book(String code, String title, String author, String publisher, String rent_TF) {
		// super();
		this.code = code;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.rent_TF = rent_TF;
	}
	
	public Book() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getRent_TF() {
		return rent_TF;
	}

	public void setRent_TF(String rent_TF) {
		this.rent_TF = rent_TF;
	}

	@Override
	public String toString() {
		return code + "\t" + title + "\t" + author + "\t" + publisher + "\t" + rent_TF;
	}
	
	
}
