package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyPageControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("login") != null) {
	        response.sendRedirect("myPage.ko");
	    } else {
	        request.getRequestDispatcher("WEB-INF/html/myPage.jsp").forward(request, response);
	    }
		
	}

}
