package com.fashion.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikeItDAO extends DAO {
	public List<Integer> selectLikes(int memberNo) {
		connect();
		List<Integer> result = new ArrayList<>();
		String sql = "select clothes_no from like_it where member_no=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memberNo);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				result.add(rs.getInt("clothes_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}
	public boolean hasLike(int mno, int clothesNo) {
		connect();
		boolean result = false;
		String sql = "select count(*) from like_it where member_no=? and clothes_no=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mno);
			psmt.setInt(2, clothesNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}
	public boolean insertLike(int memberNo, int clothesNo) {
		connect();
		boolean result = false;
		String sql = "insert into like_it(member_no, clothes_no) values(?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memberNo);
			psmt.setInt(2, clothesNo);
			
			if(psmt.executeUpdate() > 0) {
				result = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}
	public boolean deleteLike(int memberNo, int clothesNo) {
		connect();
		boolean result = false;
		String sql = "delete from like_it where member_no=? and clothes_no=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memberNo);
			psmt.setInt(2, clothesNo);
			
			if(psmt.executeUpdate() > 0) {
				result = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}
}
