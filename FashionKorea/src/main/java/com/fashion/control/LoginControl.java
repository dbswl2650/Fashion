package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.LoginDAO;
import com.fashion.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id + pw);
		LoginDAO ldao = new LoginDAO();
		MemberVO member = ldao.login(id, pw);
		
		if (ldao.login(id, pw) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member_id", id); // 서버존재.
//			session.setAttribute("loginInfo", member);

			
			// 목록이동.
			response.sendRedirect("main.ko");
			
		} else {
			response.sendRedirect("loginForm.ko");
		}
	}

}
