package com.fashion.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashion.vo.Review;

public class ReviewDAO extends DAO {

	public List<Review> review(int review) {
		connect();
		List<Review> result = new ArrayList<>();
		String sql = "select re.review_no, " + "re.comments, " //
				+ "re.wdate, " //
				+ "re.score, " //
				+ "re.title, " //
				+ "re.image, " //
				+ "m.member_name " //
				+ "from review re " //
				+ "join member m on re.member_no = m.member_no " + "where re.clothes_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, review);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Review rv = new Review();
				rv.setReviewNo(rs.getInt("review_no"));
				rv.setComments(rs.getString("comments"));
				rv.setWdateDate(rs.getDate("wdate"));
				rv.setScore(rs.getString("score"));
				rv.setTitle(rs.getString("title"));
				rv.setImage(rs.getString("image"));
				rv.setMemberName(rs.getString("member_name"));

				result.add(rv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		System.out.println(result);
		return result;
	}

	public Integer selectCountReview(int cno) {
		int result = 0;
		String sql = "select count(review_no) as count from review where clothes_no=?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cno);
			rs = psmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}
	
	public Integer selectCountAllReview() {
		int result = 0;
		String sql = "select count(review_no) as count from review";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}

	public List<Review> searchReviews(String keyword) {
		// TODO Auto-generated method stub
		connect();
		List<Review> reviews = new ArrayList<>();
		String sql = "SELECT * FROM review WHERE (title LIKE ? OR comments LIKE ?) AND type = '게시글'";
		try {
			psmt = conn.prepareStatement(sql);
			String searchKeyword = "%" + keyword + "%";
			psmt.setString(1, searchKeyword);
			psmt.setString(2, searchKeyword);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Review review = new Review();
				review.setReviewNo(rs.getInt("review_no"));
				review.setTitle(rs.getString("title"));
				review.setComments(rs.getString("comments"));
				review.setWdateDate(rs.getDate("wdate"));
				review.setImage(rs.getString("image"));
				reviews.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return reviews;
	}

	public List<Review> getAllReviews() {
		connect();
		List<Review> reviews = new ArrayList<>();
		String sql = "SELECT * FROM review WHERE type = '게시글'";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Review review = new Review();
				review.setReviewNo(rs.getInt("review_no"));
				review.setTitle(rs.getString("title"));
				review.setComments(rs.getString("comments"));
				review.setWdateDate(rs.getDate("wdate"));
				review.setImage(rs.getString("image"));
				reviews.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return reviews;
	}

	public List<Review> selectReviews(String keyword, int page) {
		// TODO Auto-generated method stub
		connect();
		List<Review> reviews = new ArrayList<>();
		String sql = "select * from review where review_no >= " + (page * 10 - 9);
		
		if (keyword != null && !keyword.isEmpty()) {
			// 검색어가 있으면 검색
			sql += " and (title like '%'||'" + keyword + "'||'%' "
				+ " or comments like '%'||'" + keyword + "'||'%')";
		}
		
		System.out.println("the sql is " + sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			int count = 0;
			while (rs.next() && count < 10) {
				Review review = new Review();
				review.setReviewNo(rs.getInt("review_no"));
				review.setTitle(rs.getString("title"));
				review.setComments(rs.getString("comments"));
				review.setWdateDate(rs.getDate("wdate"));
				review.setImage(rs.getString("image"));
				reviews.add(review);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return reviews;
	}
	public boolean insertReview(Review review) {
		connect();
		String sql = "INSERT INTO review (review_no, title, comments, member_no, clothes_no, image, type, wdate, score) "
				+ "VALUES (review_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, review.getTitle());
			psmt.setString(2, review.getComments() != null ? review.getComments() : "");
			psmt.setInt(3, review.getMemberNo());
			psmt.setInt(4, 0);
			psmt.setString(5, review.getImage());
			psmt.setString(6, "게시글");
			psmt.setDate(7, new java.sql.Date(System.currentTimeMillis()));
			psmt.setString(8, review.getScore());

			int rs = psmt.executeUpdate();
			return rs > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	public Review selectReview(int reviewNo) {
		connect();
		String sql = "select * from review where review_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, reviewNo);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Review rvo = new Review();
				rvo.setReviewNo(rs.getInt("review_no"));
				rvo.setComments(rs.getString("comments"));
				rvo.setTitle(rs.getString("title"));
				rvo.setImage(rs.getString("image"));
				rvo.setWdateDate(rs.getDate("wdate"));

				return rvo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	public boolean updateReview(Review review) {
		connect();
		String sql = "UPDATE review SET title = ?, comments = ? WHERE review_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, review.getTitle());
			psmt.setString(2, review.getComments());
			psmt.setInt(3, review.getReviewNo());
			
			return psmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
	
	public boolean deleteReview(int reviewNo) {
	    connect();
	    String sql = "DELETE FROM review WHERE review_no = ?";
	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setInt(1, reviewNo);

	        return psmt.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disConnect();
	    }
	    return false;
	}
	
}
