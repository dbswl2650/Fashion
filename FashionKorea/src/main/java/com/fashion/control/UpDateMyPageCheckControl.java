package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.LoginDAO;
import com.fashion.vo.MemberVO;

public class UpDateMyPageCheckControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("member_id");

		LoginDAO ldao = new LoginDAO();
		MemberVO member = ldao.getMemberInfo(memberId);

		if (member != null) {
			System.out.println("Member Info: " + member);
			request.setAttribute("memberInfo", member);
			request.getRequestDispatcher("WEB-INF/html/upDateMyPageCheck.jsp").forward(request, response);
		}

	}
}
