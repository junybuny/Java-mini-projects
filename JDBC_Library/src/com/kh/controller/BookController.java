package com.kh.controller;

import com.kh.model.service.BookService;
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.view.BookMenu;

public class BookController {

	public void insertBook(String code, String title, String author, String publisher, String genre) {
		
		Book b = new Book(code, title, author, publisher, genre);
		
		int result = new BookService().insertBook(b);
		
		if (result > 0) {
			new BookMenu().displaySuccess("\n도서가 추가되었습니다.");
		} else {
			new BookMenu().displayFail("\n도서 추가에 실패하였습니다.");
		}
		
	}

	public void insertMember(String mem_id, String mem_name, String mem_age, String mem_phone, String mem_address) {
		
		Member m = new Member(mem_id, mem_name, Integer.parseInt(mem_age), mem_phone, mem_address);
		
		int result = new BookService().insertMember(m);
		
		if (result > 0) {
			new BookMenu().displaySuccess("\n회원이 추가되었습니다.");
		} else {
			new BookMenu().displayFail("\n회원 추가에 실패하였습니다.");
		}
		
	}

}