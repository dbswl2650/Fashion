package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.LoginDAO;
import com.fashion.vo.MemberVO;

public class DeleteMyPageCheckControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("member_id");
		
		LoginDAO ldao = new LoginDAO();
		MemberVO member = ldao.getMemberInfo(memberId);
		
		System.out.println(member.getMemberId());
		String name = member.getMemberName();
		
		if (member != null) {	
			request.setAttribute("memberInfo", member);
			request.getRequestDispatcher("WEB-INF/html/deleteMyPageCheck.jsp").forward(request, response);
		}
	}
}


