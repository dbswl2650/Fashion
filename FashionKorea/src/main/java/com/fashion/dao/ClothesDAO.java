package com.fashion.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashion.vo.Clothes;
import com.fashion.vo.Review;

public class ClothesDAO extends DAO {
	private String selectAllSql = "select count(clothes_no) as count" 
			+ "					   from clothes"
			+ "					   where clothes_no != 0";
	private String selectSomeSql = "select clothes_no" 
			+ "						from clothes"
			+ "						where clothes_no != 0";
	private String selectOneSql = "select category_no," 
			+ "						 name," 
			+ "						 price,"
			+ "						 color," 
			+ "						 clothes_size," 
			+ "						 image,"
			+ "						 category," 
			+ "						 about,"
			+ "						 image_detail" 
			+ "					   from clothes"
			+ "					   where clothes_no=?";
	private String insertSql = "insert into clothes(clothes_no," 
			+ "					  category_no,"
			+ "					  name," 
			+ "					  price," 
			+ "					  color,"
			+ "					  clothes_size," 
			+ "					  image," 
			+ "					  category,"
			+ "					  about," 
			+ "					  image_detail"
			+ "					values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private String updateSql = "update clothes" 
			+ "					set category_no=?," 
			+ "					  name=?,"
			+ "					  price=?," 
			+ "					  color=?," 
			+ "					  clothes_size=?,"
			+ "					  image=?," 
			+ "					  category=?," 
			+ "					  about=?,"
			+ "					  image_detail=?" 
			+ "					where clothes_no=?";
	private String deleteSql = "delete from clothes" 
			+ "					where clothes_no=?";
	
	public int selectAllClothes() {
		int count = 0;
		if (connect() == false) {
			System.out.println("연결 에러");
			return count;
		}

		try {
			psmt = conn.prepareStatement(selectAllSql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return count;
	}

	public List<Integer> selectSomeClothes(String search) {
		List<Integer> result = new ArrayList<>();
		if (connect() == false) {
			System.out.println("연결 에러");
			return result;
		}

		
		String where = "";
		if (search != null && search != "") {
			where = " and (name like '%'||'" + search + "'||'%'" 
					+ "	or color like '%'||'" + search + "'||'%'"
					+ "	or clothes_size like '%'||'" + search + "'||'%'"
					+ "	or category like '%'||'" + search + "'||'%'"
					+ "	or about like '%'||'" + search + "'||'%')";
		}
		
		try {
			psmt = conn.prepareStatement(selectSomeSql + where);
			rs = psmt.executeQuery();

			while (rs.next()) {
				result.add(rs.getInt("clothes_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}

	
	public Clothes selectOneClothes(int cno) {
		connect();

		try {
			psmt = conn.prepareStatement(selectOneSql);
			psmt.setInt(1, cno);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Clothes clothes = new Clothes();
				clothes.setClothesNo(cno);
				clothes.setCategoryNo(rs.getInt("category_no"));
				clothes.setName(rs.getString("name"));
				clothes.setPrice(rs.getInt("price"));
				clothes.setColor(rs.getString("color"));
				clothes.setClothesSize(rs.getString("clothes_size"));
				clothes.setImage(rs.getString("image"));
				clothes.setCategory(rs.getString("category"));
				clothes.setAbout(rs.getString("about"));
				clothes.setImageDetail(rs.getString("image_detail"));

				return clothes;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	public boolean insertClothes(Clothes clothes) {
		if (connect() == false) {
			System.out.println("연결 에러");
			return false;
		}
		try {
			psmt = conn.prepareStatement("select max(clothes_no) as max_no from clothes");
			rs = psmt.executeQuery();
//<<<<<<< HEAD
//			
//=======
//			int new_cno = rs.getInt("max_no") + 1;
//
//>>>>>>> refs/heads/main
			psmt = conn.prepareStatement(insertSql);
//<<<<<<< HEAD
			psmt.setInt(1, clothes.getCategoryNo());
			psmt.setString(2, clothes.getName());
			psmt.setInt(3, clothes.getPrice());
			psmt.setString(4, clothes.getColor());
			psmt.setString(5, clothes.getClothesSize());
			psmt.setString(6, clothes.getImage());
			psmt.setString(7, clothes.getCategory());
			psmt.setString(8, clothes.getAbout());
			psmt.setString(9, clothes.getImageDetail());
			
//=======
//			psmt.setInt(1, new_cno);
//			psmt.setInt(2, clothes.getCategoryNo());
//			psmt.setString(3, clothes.getName());
//			psmt.setInt(4, clothes.getPrice());
//			psmt.setString(5, clothes.getColor());
//			psmt.setString(6, clothes.getClothesSize());
//			psmt.setString(7, clothes.getImage());
//			psmt.setString(8, clothes.getCategory());
//			psmt.setString(9, clothes.getAbout());
//			psmt.setString(10, clothes.getImageDetail());
//
//>>>>>>> refs/heads/main
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

	public boolean updateClothes(Clothes clothes) {
		if (connect() == false) {
			System.out.println("연결 에러");
			return false;
		}
		try {
			psmt = conn.prepareStatement(updateSql);
			psmt.setInt(10, clothes.getClothesNo());
			psmt.setInt(1, clothes.getCategoryNo());
			psmt.setString(2, clothes.getName());
			psmt.setInt(3, clothes.getPrice());
			psmt.setString(4, clothes.getColor());
			psmt.setString(5, clothes.getClothesSize());
			psmt.setString(6, clothes.getImage());
			psmt.setString(7, clothes.getCategory());
			psmt.setString(8, clothes.getAbout());
			psmt.setString(9, clothes.getImageDetail());

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
