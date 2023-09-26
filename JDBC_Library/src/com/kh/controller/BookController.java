package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.BookService;
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.view.BookMenu;



public class BookController {

	public void insertBook(String code, String title, String author, String publisher, String rent_TF ) {
		
		Book b = new Book(code, title, author, publisher, rent_TF);
		
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

	public void deleteBook(String code) {
		
		int result = new BookService().deleteBook(code);
		
		if (result > 0) {
			new BookMenu().displaySuccess(code + "도서 삭제에 완료하였습니다.");
		} else {
			new BookMenu().displayFail(code + "도서 삭제에 실패하였습니다.");
		}
	}

	public void deleteMember(String mem_id) {
		
		int result = new BookService().deleteMember(mem_id);
		
		if (result > 0) {
			new BookMenu().displaySuccess(mem_id + "회원을 삭제 완료하였습니다.");
		} else {
			new BookMenu().displayFail(mem_id + "회원 삭제에 실패하였습니다.");
		}
	}
	
	public void bookList() {
		ArrayList<Book> bookList = new BookService().bookList();
		
		if (bookList.isEmpty()) {
			new BookMenu().displayNoData("대여할수 있는 도서가 없습니다.");
		} else {
			new BookMenu().displayBookList(bookList);
		}
	}
	
	public void rentY_bookList() {
		ArrayList<Book> rentY_bookList = new BookService().rentY_bookList();
		
		if (rentY_bookList.isEmpty()) {
			new BookMenu().displayNoData("대여중인 도서가 없습니다.");
		} else {
			new BookMenu().displayRentBookList(rentY_bookList);
		}
	}

	public void rent_bookList(String rent_TF) {
		
		Book b = new Book();
		
		b.setRent_TF(rent_TF);
		
		int result = new BookService().rent_bookList(b);
		
		if (result > 0) {
			new BookMenu().displaySuccess("도서 대여를 완료하였습니다.");
		} else {
			new BookMenu().displayFail("도서 대여에 실패하였습니다.");
		}
		
	}

	public void return_bookList(String rent_TF) {
		
		Book b = new Book();
		
		b.setRent_TF(rent_TF);
		
		int result = new BookService().return_bookList(b);
		
		if (result > 0) {
			new BookMenu().displaySuccess("도서 반납을 완료하였습니다.");
		} else {
			new BookMenu().displayFail("도서 반납에 실패하였습니다.");
		}
		
	}

	
//	public void selectList() {
//		ArrayList<Member> list = new MemberService().selectList();
//		
//		if (list.isEmpty()) {
//			new MemberMenu().displayNoData("전체 조회 결과가 없습니다.");
//		} else {
//			new MemberMenu().displayMemberList(list);
//		}
//		
//	}
		
	
	
} // class BookController