package com.fashion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.fashion.vo.MemberVO;

public class LoginDAO extends DAO {
	public String login(String id, String pw) {
		connect();
		String sql = "select * from member where member_id = ? and  member_pw = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			// 결과조회.
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString("member_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}
	
	public boolean insertMember(MemberVO member) {
		connect();
		String sql = "insert into member " //
				+ "(member_no, member_name, member_id, member_pw, member_mail, member_age, member_add, member_phone) " //
				+ "values(member_seq.nextval, ?, ?, ?, ?, ?, ?, ?) ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getMemberName());
			psmt.setString(2, member.getMemberId());
			psmt.setString(3, member.getMemberPw());
			psmt.setString(4, member.getMemberMail());
			psmt.setString(5, member.getMemberAge());
			psmt.setString(6, member.getMemberAdd());
			psmt.setString(7, member.getMemberPhone());
			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
}
