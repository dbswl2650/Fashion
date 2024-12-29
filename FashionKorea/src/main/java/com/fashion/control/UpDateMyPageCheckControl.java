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
			// DB에 저장된 비밀번호 가져오기
			String memberPw = member.getMemberPw(); // DB에서 가져온 비밀번호

			// JSP에서 전달된 사용자가 입력한 비밀번호 가져오기
			String inputPw = request.getParameter("member_pw"); // 사용자가 입력한 비밀번호
			String confirmPw = request.getParameter("confirm_pw"); // 사용자가 입력한 비밀번호 재확인

			// 비밀번호 확인
			if (inputPw != null && !inputPw.equals(memberPw)) {
				// 비밀번호가 일치하지 않으면, 에러 메시지 출력 후 페이지 그대로
				System.out.println("Password does not match.");
				request.setAttribute("error", "비밀번호가 일치하지 않습니다.");
				request.getRequestDispatcher("WEB-INF/html/upDateMyPageCheck.jsp").forward(request, response);
				return;
			}

			// 비밀번호 재확인 확인
			if (confirmPw != null && !confirmPw.equals(inputPw)) {
				// 비밀번호 재확인 값이 일치하지 않으면, 에러 메시지 출력 후 페이지 그대로
				System.out.println("Confirm Password does not match.");
				request.setAttribute("error", "비밀번호 재확인 값이 일치하지 않습니다.");
				request.getRequestDispatcher("WEB-INF/html/upDateMyPageCheck.jsp").forward(request, response);
				return;
			}

			// 비밀번호가 일치하고, 재확인도 일치하면 수정 페이지로 이동
			request.getRequestDispatcher("WEB-INF/html/upDateMyPageCheck.jsp").forward(request, response);

		} else {
			// 회원 정보를 찾을 수 없는 경우
			System.out.println("Member not found.");
			request.setAttribute("error", "회원 정보를 찾을 수 없습니다.");
			request.getRequestDispatcher("WEB-INF/html/myPage.jsp").forward(request, response);
		}
	}
}
