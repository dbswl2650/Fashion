package com.fashion.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.CartDAO;
import com.fashion.dao.OrderDAO;
import com.fashion.vo.CartItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class OrderControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    resp.setContentType("text/json;charset=utf-8");
		    // 세션에서 회원번호 가져오기
		    HttpSession session = req.getSession();
		    
		    
		    
		    int memberNo = (Integer) session.getAttribute("member_no");
		    int total = Integer.parseInt(req.getParameter("total"));
		    
		    OrderDAO dao = new OrderDAO();
		    boolean insertOrders = dao.insertOrder(memberNo, total);
		    
		    Gson gson = new GsonBuilder().create();
		    String json = gson.toJson(insertOrders);
		    resp.getWriter().print(json);



	}

}
