package com.fashion.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.CartDAO;
import com.fashion.vo.CartItem;

public class CartInfoUpdateControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");
		String quantity = req.getParameter("quantity");
		String cartNo = req.getParameter("cartNo");
		CartDAO cartDAO = new CartDAO();
		//boolean cartUpdate = cartDAO.updateCartItem(cartNo,quantity);
	}

}
