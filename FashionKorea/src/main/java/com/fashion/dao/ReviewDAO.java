package com.fashion.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashion.vo.Review;

public class ReviewDAO extends DAO {

	public List<Review> review(String review) {
		List<Review> result = new ArrayList<>();
		String sql = "select re.comments, " //
				+ "re.wdate, " //
				+ "re.r_score, " //
				+ "re.n_title, " //
				+ "re.n_image, " //
				+ "m.member_name " //
				+ "from review re " //
				+ "join member m on re.member_no = m.member_no "
				+ "where re.clothes_no = ? ";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, review);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Review rv = new Review();
				rv.setComments(rs.getString("comments"));
				rv.setRScore(rs.getString("r_score"));
				rv.setNTitle(rs.getString("n_title"));
//				rv.setNImage(rs.getString("n_image"));

				result.add(rv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}

}
