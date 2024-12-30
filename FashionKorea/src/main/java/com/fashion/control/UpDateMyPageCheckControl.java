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
		System.out.println(member);
		
		if (member != null) {
			String memberPw = member.getMemberPw();
			System.out.println(memberPw);

			String inputPw = request.getParameter("member_pw");
			System.out.println(inputPw);
			String confirmPw = request.getParameter("confirm_pw");
			System.out.println(confirmPw);
			if (inputPw != null && !inputPw.equals(memberPw)) {
				System.out.println("Password does not match.");
				request.setAttribute("error", "비밀번호가 일치하지 않습니다.");
				request.getRequestDispatcher("WEB-INF/html/upDateMyPageCheck.jsp").forward(request, response);
				return;
			}

			if (confirmPw != null && !confirmPw.equals(inputPw)) {
				System.out.println("Confirm Password does not match.");
				request.setAttribute("error", "비밀번호 재확인 값이 일치하지 않습니다.");
				request.getRequestDispatcher("WEB-INF/html/upDateMyPageCheck.jsp").forward(request, response);
				return;
			}
			if (inputPw.equals(memberPw)) {
				request.setAttribute("memberInfo", member);
				request.getRequestDispatcher("WEB-INF/html/upDateMember.jsp").forward(request, response);
			}

		} else {
			System.out.println("Member not found.");
			request.setAttribute("error", "회원 정보를 찾을 수 없습니다.");
			request.getRequestDispatcher("WEB-INF/html/myPage.jsp").forward(request, response);
		}
	}
}
