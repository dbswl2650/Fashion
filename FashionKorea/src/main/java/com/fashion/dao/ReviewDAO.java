package com.fashion.dao;

import java.sql.SQLException;

import com.fashion.vo.Review;

public class ReviewDAO extends DAO {

	private String selectReviewSql = "select * "
			+ " from review "
			+ " where clothes_no = ? ";
	
	public Review review(int cno) {
		connect();
		String sql = "select * from review where clothes_no = ? ";
				
		try {
			psmt = conn.prepareStatement(selectReviewSql);
			psmt.setInt(1, cno);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Review review = new Review();
				review.setReviewNo(cno);
				review.setMemberNo(rs.getInt("member_no"));
				review.setClothesNo(rs.getInt("clothes_no"));
				review.setType(rs.getString("type"));
				review.setComments(rs.getString("comments"));
				review.setWDate(rs.getDate("date"));
				review.setRScore(rs.getString("score"));
				review.setNTitle(rs.getString("title"));
				review.setNImage(rs.getString("image"));
				
				return review;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return null;
	}
	
}
