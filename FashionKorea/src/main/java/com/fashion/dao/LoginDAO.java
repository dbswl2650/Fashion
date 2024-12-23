package com.fashion.dao;

import java.sql.SQLException;

public class LoginDAO extends DAO {
	public String login(String id, String pw) {
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
}
