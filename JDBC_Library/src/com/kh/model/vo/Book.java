package com.kh.model.vo;

public class Book {
	private String code;
	private String title;
	private String author;
	private String publisher;
	private String genre;
	
	public Book(String code, String title, String author, String publisher, String genre) {
		super();
		this.code = code;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [code=" + code + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", genre=" + genre + "]";
	}
	
	
}
