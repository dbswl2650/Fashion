package com.fashion.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.LoginDAO;
import com.fashion.dao.OrderDAO;
import com.fashion.vo.MemberVO;
import com.fashion.vo.Order;

public class OrderHistoryControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("member_id");
        
        if (memberId != null) {
            LoginDAO loginDao = new LoginDAO();
            MemberVO member = loginDao.getMemberInfo(memberId);
            int memberNo = member.getMemberNo();
            
            OrderDAO orderDao = new OrderDAO();
            List<Order> orderList = orderDao.getOrderHistory(memberNo);
            
            request.setAttribute("orderList", orderList);
            request.getRequestDispatcher("WEB-INF/html/orderHistory.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
	}

}
