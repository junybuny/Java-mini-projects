package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.service.BookService;
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.model.vo.RentBook;

public class BookDao {
	
	private Properties prop = new Properties();
	
	public BookDao() {
		try {
			prop.loadFromXML(new FileInputStream("book_resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertBook(Connection conn, Book b) {
		
		int result= 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getCode());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getAuthor());
			pstmt.setString(4, b.getPublisher());		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertMember(Connection conn, Member m) {
		
		int result= 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMem_id());
			pstmt.setString(2, m.getMem_pwd());
			pstmt.setString(3, m.getMem_name());
			pstmt.setString(4, m.getMem_email());
			pstmt.setString(5, m.getMem_phone());
			pstmt.setString(6, m.getMem_address());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteBook(Connection conn, String code) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteBook");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String mem_id) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Book> bookList(Connection conn) {
		
		ArrayList<Book> bookList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("bookList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book b = new Book();
				
				b.setCode(rset.getString("book_code"));
				b.setTitle(rset.getString("book_title"));
				b.setAuthor(rset.getString("book_author"));
				b.setPublisher(rset.getString("book_publisher"));
				
				bookList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt); 
		}
		
		return bookList;
	}
	
	public ArrayList<RentBook> rentY_bookList(Connection conn) {
		
		ResultSet rset = null;
		ArrayList<RentBook> rentY_bookList = new ArrayList<>();
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("rentY_bookList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, BookService.loginMember.getMem_id());
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				RentBook rb = new RentBook(rset.getString("BOOK_CODE"),
						rset.getString("book_title"),
						rset.getString("rent_member"),
						rset.getDate("rent_date")
						); 
				rentY_bookList.add(rb);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(pstmt); 
		}
		
		return rentY_bookList;
	}

	public int rent_bookList(Connection conn, String code) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("rent_bookList");
		String sql2 = prop.getProperty("rent_bookList2");
		
		try {
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, code);
			pstmt.setString(2, BookService.loginMember.getMem_id());
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				result = 0;
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				result = pstmt.executeUpdate();
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int return_bookList(Connection conn, String code) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("return_bookList");
		String sql2 = prop.getProperty("return_bookList2");
		
		try {
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, code);
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				result = 0;
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				result = pstmt.executeUpdate();
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Member loginMember(Connection conn, String mem_id, String mem_pwd) {
		
		Member member = null;
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setMem_id(rset.getString("mem_id"));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return member;
	}

	public int updateMember(Connection conn, Member m) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMem_pwd());
			pstmt.setString(2, m.getMem_email());
			pstmt.setString(3, m.getMem_phone());
			pstmt.setString(4, m.getMem_address());
			pstmt.setString(5, m.getMem_id());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	
	
	
	
} // class BookDao