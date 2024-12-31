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
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  HttpSession session = request.getSession();
	       String memberId = (String) session.getAttribute("member_id");
	       
	       LoginDAO loginDao = new LoginDAO();
	       MemberVO member = loginDao.getMemberInfo(memberId);
	       
	       CartDAO cartDao = new CartDAO();
	       List<CartItem> cartItems = cartDao.selectCart(memberId);
	       
	       // 회원정보를 화면에 보여주기 위해 저장
	       request.setAttribute("member", member);
	       // 장바구니 상품들을 화면에 보여주기 위해 저장  
	       request.setAttribute("items", cartItems);
	       // 총 금액
	       int total = 0;
	       for(CartItem item : cartItems) {
	           total += item.getPrice() * item.getQuantity(); 
	       }
	       request.setAttribute("total", total);
	       
	       request.getRequestDispatcher("WEB-INF/html/order.jsp").forward(request, response);

	}

}
