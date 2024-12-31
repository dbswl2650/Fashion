package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.LoginDAO;
import com.fashion.dao.ReviewDAO;
import com.fashion.vo.MemberVO;
import com.fashion.vo.Review;

public class ReviewFormControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("member_id");

        if (memberId == null) {
            request.getRequestDispatcher("WEB-INF/html/login.jsp").forward(request, response);
            return;
        }

        if (request.getMethod().equals("GET")) {
            // 작성 폼으로 이동
            request.getRequestDispatcher("WEB-INF/html/reviewForm.jsp").forward(request, response);
        }
	}
}
