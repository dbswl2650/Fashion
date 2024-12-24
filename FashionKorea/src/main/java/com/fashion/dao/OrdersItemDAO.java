package com.fashion.dao;

import java.sql.SQLException;

public class OrdersItemDAO extends DAO {
	private String selectClothesNoCountSql = "select count(clothes_no) as count"
			+ "								  from orders_item"
			+ "								  where clothes_no=?";
	public int selectClothesNoCount(int cno) {
		connect();
		int count = 0;
		try {
			psmt = conn.prepareStatement(selectClothesNoCountSql);
			psmt.setInt(1, cno);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				++count;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return count;
	}
}
