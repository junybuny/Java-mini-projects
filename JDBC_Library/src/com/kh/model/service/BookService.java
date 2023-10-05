package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.BookDao;
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.model.vo.RentBook;

public class BookService {
	
	static public Member loginMember;
	
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
		int result;
		ArrayList<RentBook> rentY_bookList = new BookDao().rentY_bookList(conn);
		
		if (rentY_bookList.size() > 0) {
			result = 999;
		} else {
			result = new BookDao().deleteMember(conn, mem_id);	
		}
		
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
	
	public ArrayList<RentBook> rentY_bookList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<RentBook> rentY_bookList = new BookDao().rentY_bookList(conn);
		JDBCTemplate.close(conn);
		
		return rentY_bookList;
	}

	public int rent_bookList(String code) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BookDao().rent_bookList(conn, code);
		
		if (result >0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int return_bookList(String code) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BookDao().return_bookList(conn, code);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public Member loginMember(String mem_id, String mem_pwd) {
		
		Connection conn = JDBCTemplate.getConnection();
		loginMember = new BookDao().loginMember(conn, mem_id, mem_pwd);
		
		if (loginMember != null) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return loginMember;
	}

	public int updateMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new BookDao().updateMember(conn, m);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

} // class BookService
