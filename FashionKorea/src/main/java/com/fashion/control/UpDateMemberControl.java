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
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("member_id");

		LoginDAO ldao = new LoginDAO();
		MemberVO member = ldao.getMemberInfo(memberId);

		if (member != null) {
			member.setMemberName(
					request.getParameter("member_name") != null && !request.getParameter("member_name").isEmpty()
							? request.getParameter("member_name")
							: member.getMemberName());

			member.setMemberMail(
					request.getParameter("member_mail") != null && !request.getParameter("member_mail").isEmpty()
							? request.getParameter("member_mail")
							: member.getMemberMail());

			member.setMemberAdd(
					request.getParameter("member_add") != null && !request.getParameter("member_add").isEmpty()
							? request.getParameter("member_add")
							: member.getMemberAdd());

			member.setMemberPhone(
					request.getParameter("member_phone") != null && !request.getParameter("member_phone").isEmpty()
							? request.getParameter("member_phone")
							: member.getMemberPhone());

			member.setMemberAge(
					request.getParameter("member_age") != null && !request.getParameter("member_age").isEmpty()
							? request.getParameter("member_age")
							: member.getMemberAge());

			member.setMemberPw(request.getParameter("member_pw") != null && !request.getParameter("member_pw").isEmpty()
					? request.getParameter("member_pw")
					: member.getMemberPw());

			boolean isUpdated = ldao.updateMember(member);

			if (isUpdated) {
				session.setAttribute("loginInfo", member);
			}

			request.setAttribute("memberInfo", member);
			request.getRequestDispatcher("WEB-INF/html/upDateMember.jsp").forward(request, response);
		}
	}
}
