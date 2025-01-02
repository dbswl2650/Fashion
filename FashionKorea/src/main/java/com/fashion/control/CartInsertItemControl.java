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
		Integer mno = (Integer) req.getSession().getAttribute("member_no");
		if(mno == null || mno <= 0)
			return;
		
		String cno = req.getParameter("cno"); //사용자한테 cno정보를 받음
		String price = req.getParameter("price");
		String stockQuantity = req.getParameter("stockQuantity");
		String quantity = req.getParameter("quantity");
		
//		System.out.println("mno is " + mno);
//		System.out.println("cno is " + cno);
//		System.out.println("price is " + price);
//		System.out.println("stockQuantity is " + stockQuantity);
//		System.out.println("quantity is " + quantity);
		
		Cart cart = new Cart();
		cart.setClothesNo(Integer.parseInt(cno));
		cart.setQuantity(Integer.parseInt(quantity));
		cart.setMemberNo(mno);
		
//		System.out.println(cart);
		
		CartDAO cartDAO = new CartDAO(); // cartDAO변수 생성, DB에 정보를 저장
		Cart cartNo = cartDAO.insertCart(cart);
		
		req.setAttribute("cart", cartNo);
		req.getRequestDispatcher("cartForm.ko").forward(req, resp);
	}

}
