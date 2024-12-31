package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.CartDAO;
import com.fashion.vo.Cart;

public class CartInsertItemControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cno = req.getParameter("cno"); //사용자한테 cno정보를 받음
		String price = req.getParameter("price");
		String stockQuantity = req.getParameter("stockQuantity");
		String quantity = req.getParameter("quantity");
		
		CartDAO cartDAO = new CartDAO(); // cartDAO변수 생성, DB에 정보를 저장
		Cart cart = new Cart();
		cart.setClothesNo(Integer.parseInt(cno));
//		System.out.println(cart);
		Cart cartNo = cartDAO.insertCart(cart);
		
		
		req.setAttribute("cart", cartNo);
		req.getRequestDispatcher("WEB-INF/html/cart.jsp").forward(req, resp);
	}

}
