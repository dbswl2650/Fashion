//package com.fashion.dao;
//
//import java.sql.SQLException;
//
//public class CartDAO extends DAO{
//	private String selectCartSql = "SELECT c.image AS product_image,"//
//			+ "                            c.name AS product_name,"//
//			+ "                            c.price AS product_price,"//
//			+ "                            ca.quantity AS product_quantity,"//
//			+ "                            (c.price * ca.quantity) AS total_price"//
//			+ "                     FROM   cart ca"//
//			+ "                            JOIN clothes c ON ca.clothes_no = c.clothes_no"//
//			+ "                     WHERE  ca.member_no = ?";
//	//public int selectCartSql() {
//		
//		
//	}
//}
