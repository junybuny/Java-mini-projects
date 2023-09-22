package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.BookDao;
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;

public class BookService {

	public int insertBook(Book b) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new BookDao().insertBook(conn, b);
	
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int insertMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new BookDao().insertMember(conn, m);
	
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int deleteBook(String code) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new BookDao().deleteBook(conn, code);
	
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int deleteMember(String mem_id) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new BookDao().deleteMember(conn, mem_id);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public ArrayList<Book> bookList() {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> bookList = new BookDao().bookList(conn);
		JDBCTemplate.close(conn);
		
		return bookList;
	}

	public int bookList(Book b) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BookDao().bookList(conn, b);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
