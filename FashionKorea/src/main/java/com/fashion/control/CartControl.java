package com.fashion.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.CartDAO;
import com.fashion.vo.CartItem;

public class CartControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");
		HttpSession session = req.getSession();
		String memberNo = (String) session.getAttribute("member_id");
		CartDAO cartdao = new CartDAO();
		
		List<CartItem> cart = cartdao.selectCart(memberNo);
		req.setAttribute("cartList", cart);	
		req.getRequestDispatcher("WEB-INF/html/cart.jsp").forward(req, resp);
	}

}
