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
        // 세션에서 로그인한 ID를 가져옴
        HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("member_id");

        // 비밀번호 요청 파라미터에서 가져옴
        String inputPw = request.getParameter("member_pw");
        String confirmPw = request.getParameter("confirm_pw");

        // 비밀번호 입력이 안된경우
        if (inputPw == null || confirmPw == null) {
            request.setAttribute("error", "비밀번호를 입력하세요.");
            request.getRequestDispatcher("WEB-INF/html/deleteMyPageCheck.jsp").forward(request, response);
            return;
        }

        // 입력한 비밀번호가 일치하지 않는경우
        if (!inputPw.equals(confirmPw)) {
            request.setAttribute("error", "비밀번호가 일치하지 않습니다.");
            request.getRequestDispatcher("WEB-INF/html/deleteMyPageCheck.jsp").forward(request, response);
            return;
        }

        // 데이터베이스에서 ID와 비밀번호를 검증
        LoginDAO dao = new LoginDAO();
        MemberVO member = dao.login(memberId, inputPw);

        // 데이터베이스에 일치하지 않는경우
        if (member == null) {
            request.setAttribute("error", "비밀번호가 잘못되었습니다.");
            request.getRequestDispatcher("WEB-INF/html/deleteMyPageCheck.jsp").forward(request, response);
        } else {
        //성공하면 저장하고 탈퇴 페이지로 이동
            session.setAttribute("memberInfo", member);
            response.sendRedirect("deleteMyPageServiceImpl.ko");
        }
    }
}


