package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.LoginDAO;
import com.fashion.vo.MemberVO;

public class MyPageControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원정보를 불러오고 => 회원정보를 담고 => myPage.jsp 넘긴다
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("member_id");
		LoginDAO login = new LoginDAO();
		MemberVO mvo = login.selectMember(Integer.parseInt(id));
		request.setAttribute("loginInfo", mvo);
		
	    request.getRequestDispatcher("WEB-INF/html/myPage.jsp").forward(request, response);
	    }

}
