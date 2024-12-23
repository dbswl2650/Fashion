package com.fashion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.fashion.vo.MemberVO;

public class LoginDAO extends DAO {
	// 로그인 페이지
	public String login(String id, String pw) {
		System.out.println(id + pw);
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
	// 회원가입 페이지
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
	
	// 마이패이지 나타내기..
	public MemberVO selectMember(int memberNo) {
		connect();
		String sql = "select * from member where member_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memberNo);
			rs = psmt.executeQuery(); // 조회.

			while (rs.next()) {
				MemberVO mrd = new MemberVO();
				mrd.setMemberNo(rs.getInt("member_no"));
				mrd.setMemberName(rs.getString("member_name"));
				mrd.setMemberId(rs.getString("member_id"));
				mrd.setMemberPw(rs.getString("member_pw"));
				mrd.setMemberMail(rs.getString("member_mail"));
				mrd.setMemberAge(rs.getString("member_age"));
				mrd.setMemberAdd(rs.getString("member_add"));
				mrd.setMemberPhone(rs.getString("member_phone"));
				return mrd;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}
	
	// 회원 정보 수정
	public boolean updateMember(MemberVO member) {
		connect();
		String sql = "update member set member_id = ?,"
				+ " member_pw = ?,"
				+ " member_mail = ?,"
				+ " member_add = ?,"
				+ " member_phone"
				+ " where board_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getMemberId());
			psmt.setString(2, member.getMemberPw());
			psmt.setString(3, member.getMemberMail());
			psmt.setString(4, member.getMemberAdd());
			psmt.setString(5, member.getMemberPhone());
			psmt.setInt(6, member.getMemberNo());
			
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
