package com.fashion.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fashion.vo.CartItem;
public class CartDAO extends DAO{
	
	public List<CartItem> selectCart(String member_no) {
	connect();
	String sql = "SELECT c.image AS image,"//
			+ "          c.name AS name,"//
			+ "          c.price AS price,"//
			+ "          ca.quantity AS quantity,"//
			+ "          (c.price * ca.quantity) AS totalPrice"//
			+ " FROM     cart ca"//
			+ "          JOIN clothes c ON ca.clothes_no = c.clothes_no"//
			+ " WHERE    ca.member_no = ?";
	List<CartItem> clist = new ArrayList<>();
	try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, member_no);
		
		rs = psmt.executeQuery();
		while (rs.next()) {
			CartItem cvo = new CartItem();
			cvo.setImage(rs.getString("image"));
			cvo.setName(rs.getString("name"));
			cvo.setPrice(rs.getInt("price"));
			cvo.setQuantity(rs.getInt("quantity"));
			cvo.setTotalPrice(rs.getInt("totalPrice"));
			
			clist.add(cvo);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disConnect();
	}
	return clist;
}
	
	
	public boolean deleteReply(int clothes_no) {
		connect();
		String sql = "delete "
				+ "   from     cart "
				+ "   where    clothes_no = ?";
		

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, clothes_no);
			int r = psmt.executeUpdate();
			if(r > 0) {		
					return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return false;
	}
}
