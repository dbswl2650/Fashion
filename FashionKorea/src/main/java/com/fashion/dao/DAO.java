package com.fashion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAO {
	// 쿼리실행 위한 필드 선언.
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	// 연결.
	public boolean connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 드라이버 로드
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "fashion", "fashion");	// Connection 객체를 반환
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.8:1521:xe", "fashion", "fashion");	// Connection 객체를 반환
			return true;
		}
		catch (Exception e) {
			// 예외발생시 명령
			System.out.println("연결 중 에러.");
			e.printStackTrace();
			return false;
		}
	}
	
	// 연결해제.
	public void disConnect() {
		try {
			if (conn != null)
				conn.close();
			if (psmt != null)
				psmt.close();
			if (rs != null)
				rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}