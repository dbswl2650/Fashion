package com.fashion.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashion.vo.Cart;
import com.fashion.vo.CartItem;
import com.fashion.vo.Clothes;

public class CartDAO extends DAO {

	public List<CartItem> selectCart(String memberId) {

	       connect();
	       String sql = "SELECT ca.cart_no, c.image, c.name, c.price, ca.quantity, (c.price * ca.quantity) AS total_price "
	                  + "FROM cart ca "
	                  + "JOIN clothes c ON ca.clothes_no = c.clothes_no "
	                  + "JOIN member m ON ca.member_no = m.member_no "
	                  + "WHERE m.member_id = ?";

	       List<CartItem> cartItems = new ArrayList<>();
	       try {
	           psmt = conn.prepareStatement(sql);
	           psmt.setString(1, memberId); 
	           rs = psmt.executeQuery();
	           
	           while (rs.next()) {
	               CartItem cartItem = new CartItem();
	               cartItem.setCartNo(rs.getInt("cart_no"));
	               cartItem.setImage(rs.getString("image"));
	               cartItem.setName(rs.getString("name"));
	               cartItem.setPrice(rs.getInt("price"));
	               cartItem.setQuantity(rs.getInt("quantity"));
	               cartItem.setTotalPrice(rs.getInt("total_price"));
	               cartItems.add(cartItem);
	           }
	       } catch (SQLException e) {
	           e.printStackTrace();
	       } finally {
	           disConnect();
	       }
	       return cartItems;
	   }
	
	
	public boolean deleteCartItem(int cart_no) {
	       connect(); 
	       String sql = "DELETE "
	       		+ "      FROM    cart "
	       		+ "      WHERE   cart_no = ?";
	       
	       try {
	           psmt = conn.prepareStatement(sql);
	           psmt.setInt(1, cart_no);  
	           int r = psmt.executeUpdate(); 
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
	
	
	public boolean updateCartItem(int cartNo, int quantity) {
		connect();
		String sql = "UPDATE cart "
				+ "   SET    quantity = ? "
				+ "   WHERE  cart_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, quantity); 
	        psmt.setInt(2, cartNo); 
			int r = psmt.executeUpdate();
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

	
	



	public Cart insertCart(Cart cart) {
		connect();
		String sql = "insert into cart(cart_no, clothes_no, quantity, member_no) " //
				   + "values (cart_seq.nextval, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, cart.getCartNo());
			psmt.setInt(1, cart.getClothesNo());
			psmt.setInt(2, cart.getQuantity());
			psmt.setInt(3, cart.getMemberNo());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return cart;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

}
