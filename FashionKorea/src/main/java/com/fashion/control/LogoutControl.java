package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesstion = request.getSession();
		sesstion.invalidate();
		
		response.sendRedirect("WEB-INF/html/main.jsp");
		
		// 로그인한 사용자 번호 삭제후 로그아웃 기능하기
	}

}
