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
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;

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
			pstmt.setString(5, b.getRent_TF());
			
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
			pstmt.setString(2, m.getMem_name());
			pstmt.setInt(3, m.getMem_age());
			pstmt.setString(4, m.getMem_phone());
			pstmt.setString(5, m.getMem_address());
			
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
				b.setRent_TF(rset.getString("rent_TF"));
				
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
	
	public ArrayList<Book> rentY_bookList(Connection conn) {
		
		ArrayList<Book> rentY_bookList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("rentY_bookList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				// rentBook rb = new rentBook(); 
				
				// 여기서 부터 수정!
//				b.setCode(rset.getString("book_code"));
//				b.setTitle(rset.getString("book_title"));
//				b.setAuthor(rset.getString("book_author"));
//				b.setPublisher(rset.getString("book_publisher"));
//				b.setRent_TF(rset.getString("rent_TF"));
				
//				rentY_bookList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt); 
		}
		
		return rentY_bookList;
	}

	public int rent_bookList(Connection conn, Book b) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("rent_bookList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getRent_TF());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int return_bookList(Connection conn, Book b) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("return_bookList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getRent_TF());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	
	
	
	
} // class BookDao