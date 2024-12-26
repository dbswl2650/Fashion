package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.LoginDAO;
import com.fashion.vo.MemberVO;

public class UpDateMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	HttpSession session = request.getSession();
		    String memberId = request.getParameter("memberId");
		    String name = request.getParameter("memberName");
		    String mail = request.getParameter("memberMail");
		    String password = request.getParameter("memberPw");
		    String phone = request.getParameter("memberPhone");
		    String address = request.getParameter("memberAdd");

		    // 비밀번호가 비어 있다면 기존 비밀번호 유지
		    if (password == null || password.trim().isEmpty()) {
		        password = null;
		    }

		    MemberVO member = new MemberVO();
		    member.setMemberId(memberId);
		    member.setMemberName(name);
		    member.setMemberMail(mail);
		    member.setMemberPw(password);
		    member.setMemberPhone(phone);
		    member.setMemberAdd(address);

		    LoginDAO ldao = new LoginDAO();
		    boolean isUpdated = ldao.updateMember(member);

		    if (isUpdated) {
		        session.setAttribute("loginInfo", member); 
		        response.sendRedirect("myPage.ko");
		    } else {
		    	request.getRequestDispatcher("/WEB-INF/html/upDateMember.jsp").forward(request, response);
		    }
	}
}
