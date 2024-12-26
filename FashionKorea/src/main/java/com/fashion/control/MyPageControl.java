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
        HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("member_id");

        if (memberId == null) {
            response.sendRedirect("loginForm.ko");
            return;
        }

        LoginDAO ldao = new LoginDAO();
        MemberVO member = ldao.getMemberInfo(memberId);

        if (member != null) {
            request.setAttribute("memberInfo", member);
            request.getRequestDispatcher("WEB-INF/html/myPage.jsp").forward(request, response);
        } else {
            response.sendRedirect("loginForm.ko");
        }
    }
}
