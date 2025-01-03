package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.DAO;
import com.fashion.dao.LoginDAO;
import com.fashion.vo.MemberVO;


public class DeleteMyPageServiceImplControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 고유 번호 가져오기
        HttpSession session = request.getSession();
        int memberNo = (int) session.getAttribute("member_no");

        // DB에 있는 지 확인하기
        LoginDAO dao = new LoginDAO();
        boolean result = dao.deleteMember(memberNo);

        // 탈퇴 성공시 메인페이지로 이동
        if (result) {
            session.invalidate();
            response.sendRedirect("main.ko");
        } else {
            // 탈퇴 실패시 오류 메시지화면에 표시
            request.setAttribute("error", "회원 탈퇴에 실패했습니다.");
            request.getRequestDispatcher("WEB-INF/html/deleteMyPageCheck.jsp").forward(request, response);
        }
    }
}


