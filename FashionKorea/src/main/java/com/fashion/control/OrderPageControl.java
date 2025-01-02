package com.fashion.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.CartDAO;
import com.fashion.dao.LoginDAO;
import com.fashion.vo.CartItem;
import com.fashion.vo.MemberVO;

public class OrderPageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  HttpSession session = req.getSession();
	       String memberId = (String) session.getAttribute("member_id");
	       
	       LoginDAO login = new LoginDAO();
	       MemberVO member = login.getMemberInfo(memberId);
	       
	       CartDAO cartDao = new CartDAO();
	       List<CartItem> cartItems = cartDao.selectCart(memberId);
	       
	       
	       
	       // 총 금액
	       int total = 0;
	       for(CartItem item : cartItems) {
	           total += item.getPrice() * item.getQuantity(); 
	       }
	       req.setAttribute("total", total);
	       // 회원정보
	       req.setAttribute("member", member);
	       // 장바구니  
	       req.setAttribute("items", cartItems);
	       req.getRequestDispatcher("WEB-INF/html/order.jsp").forward(req, resp);

	}

}
