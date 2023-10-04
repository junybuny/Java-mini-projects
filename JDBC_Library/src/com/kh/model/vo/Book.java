package com.kh.model.vo;

public class Book {
	private String code;
	private String title;
	private String author;
	private String publisher;
	private boolean isRent = false;
	private String mem_id;

	
	public Book(String code, String title, String author, String publisher) {
		// super();
		this.code = code;
		this.title = title;
		this.author = author;
		this.publisher = publisher;

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
	
	public boolean getIsRent() {
		return isRent;
	}

	public void setIsRent(boolean isRent) {
		this.isRent = isRent;
	}


	@Override
	public String toString() {
		return code + "\t" + title + "\t" + author + "\t" + publisher;
	}
	
	
}
