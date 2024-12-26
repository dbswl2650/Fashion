package com.fashion.dao;

import java.sql.SQLException;

import com.fashion.vo.Category;

public class CategoryDAO extends DAO {
	private String selectOneSql = "select sex, type"
			+ "					   from category"
			+ "					   where category_no=?";
	private String insertSql = "insert into category(category_no,"
			+ "					  sex,"
			+ "					  type)"
			+ "					values(category_seq.nextval,"
			+ "					  ?,"
			+ "					  ?)";
	private String updateSql = "update category"
			+ "					set category_no=?,"
			+ "					  sex=?,"
			+ "					  type=?";
	private String deleteSql = "delete from category"
			+ "					where category_no=?";
	
	public Category selectOneCategory(int cno) {
		connect();
		try {
			psmt = conn.prepareStatement(selectOneSql);
			psmt.setInt(1, cno);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				Category category = new Category();
				category.setCategoryNo(cno);
				category.setSex(rs.getString("sex"));
				category.setType(rs.getString("type"));
				
				return category;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}
	
	public boolean insertCategory(Category category) {
		if (connect() == false) {
			System.out.println("연결 에러");
			return false;
		}
		
		try {
			psmt = conn.prepareStatement(insertSql);
			psmt.setString(1, category.getSex());
			psmt.setString(2, category.getType());
			rs = psmt.executeQuery();
			
			if (psmt.executeUpdate() > 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
	
	public boolean updateClothes(Category category) {
		if (connect() == false) {
			System.out.println("연결 에러");
			return false;
		}
		
		try {
			psmt = conn.prepareStatement(updateSql);
			psmt.setInt(1, category.getCategoryNo());
			psmt.setString(2, category.getSex());
			psmt.setString(3, category.getType());

			if (psmt.executeUpdate() > 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
	
	public boolean deleteClothes(int cno) {
		if (connect() == false) {
			System.out.println("연결 에러");
			return false;
		}
		try {
			psmt = conn.prepareStatement(deleteSql);
			psmt.setInt(1, cno);

			if (psmt.executeUpdate() > 1) {
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
