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

public class CartFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");
		HttpSession session = req.getSession();
		String memberid = (String) session.getAttribute("member_id");
		LoginDAO ldao = new LoginDAO();
		MemberVO mvo=ldao.getMemberInfo(memberid);
		System.out.println(mvo.getMemberNo());
		
		req.getRequestDispatcher("WEB-INF/html/cart.jsp").forward(req, resp);
	}

}
