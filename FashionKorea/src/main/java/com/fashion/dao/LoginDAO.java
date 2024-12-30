package com.fashion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.fashion.vo.MemberVO;

public class LoginDAO extends DAO {
	
	public MemberVO login(String id, String pw) {
	    connect();
	    String sql = "SELECT * FROM member WHERE member_id = ? AND member_pw = ?";
	    MemberVO member = null;

	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setString(1, id);
	        psmt.setString(2, pw);

	        rs = psmt.executeQuery();
	        if (rs.next()) {
	            member = new MemberVO();
	            member.setMemberNo(rs.getInt("member_no"));
	            member.setMemberName(rs.getString("member_name"));
	            member.setMemberId(rs.getString("member_id"));
	            member.setMemberPw(rs.getString("member_pw"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disConnect();
	    }

	    return member;
	}
	
	public boolean insertMember(MemberVO member) {
		connect(); // sql 회원가입 등록 메서드
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
		public MemberVO getMemberInfo(String memberId) {
		    String sql = "SELECT * FROM member WHERE member_id = ?";
		    MemberVO member = null;
		    
		    try {
		        connect();
		        psmt = conn.prepareStatement(sql);
		        psmt.setString(1, memberId);

		        rs = psmt.executeQuery();
		        
		        while (rs.next()) {
		            member = new MemberVO();
		            member.setMemberNo(rs.getInt("member_no"));
		            member.setMemberName(rs.getString("member_name"));
		            member.setMemberId(rs.getString("member_id"));
		            member.setMemberPw(rs.getString("member_pw"));
		            member.setMemberMail(rs.getString("member_mail"));
		            member.setMemberPhone(rs.getString("member_phone"));
		            member.setMemberAge(rs.getString("member_age"));
		            member.setMemberAdd(rs.getString("member_add"));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        disConnect();
		    }
		    return member;
		}
//		 회원정보 수정..
		public boolean updateMember(MemberVO member) {
		    connect();
		    String sql = "UPDATE member " +
		                 "SET member_name = ?, member_mail = ?, member_pw = ?, " +
		                 "member_add = ?, member_phone = ?, member_age = ? " +
		                 "WHERE member_id = ?";

		    try {
		        psmt = conn.prepareStatement(sql);
		        psmt.setString(1, member.getMemberName());
		        psmt.setString(2, member.getMemberMail());
		        psmt.setString(3, member.getMemberPw());
		        psmt.setString(4, member.getMemberAdd());
		        psmt.setString(5, member.getMemberPhone());
		        psmt.setString(6, member.getMemberAge());
		        psmt.setString(7, member.getMemberId());

		        return psmt.executeUpdate() > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        disConnect();
		    }
		    return false;
		}
		
		 //id 중복검사 같은 id가 있는지 없는지 검증하는 함수	
		public boolean selectSameId(String id) {
	    	connect();
	    	String sql = "select member_id from member where member_id=?";
	    	
	    	try {
	    		psmt = conn.prepareStatement(sql);
	    		psmt.setString(1, id);
	    		rs = psmt.executeQuery();
	    		
	    		while (rs.next()) {
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

