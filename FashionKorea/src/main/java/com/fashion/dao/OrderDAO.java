package com.fashion.dao;

import java.net.ConnectException;
import java.sql.SQLException;

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


}
