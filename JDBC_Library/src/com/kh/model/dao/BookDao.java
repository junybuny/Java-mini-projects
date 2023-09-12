package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			pstmt.setString(5, b.getGenre());
			
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
}
