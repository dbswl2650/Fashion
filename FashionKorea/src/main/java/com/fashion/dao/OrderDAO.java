package com.fashion.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashion.vo.Order;

public class OrderDAO extends DAO {

	public boolean insertOrder(int memberNo, int total) {
	    connect();
	    String sql = "INSERT INTO orders "
	    		+ "(orders_no, member_no, or_total, or_date, or_status) "
	    		+ "VALUES (orders_seq.nextval, ?, ?, sysdate, '주문완료')";
	    
	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setInt(1, memberNo);
	        psmt.setInt(2, total);
	        int r = psmt.executeUpdate();
	        if(r > 0) {
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disConnect();
	    } 
	    return false;
	}

	public List<Order> getOrderHistory(int memberNo) {
	    connect();
	    String sql = "SELECT orders_no, or_date, or_total, or_status "
	               + "FROM orders "
	               + "WHERE member_no = ? "
	               + "ORDER BY or_date DESC";

	    List<Order> orderList = new ArrayList<>();
	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setInt(1, memberNo);
	        rs = psmt.executeQuery();

	        while (rs.next()) {
	            Order order = new Order();
	            order.setOrdersNo(rs.getInt("orders_no"));
	            order.setOrDate(rs.getString("or_date"));
	            order.setOrTotal(rs.getInt("or_total"));
	            order.setOrStatus(rs.getString("or_status"));
	            orderList.add(order);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disConnect();
	    }
	    return orderList;
	}
	
}
