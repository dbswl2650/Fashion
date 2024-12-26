package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.LoginDAO;
import com.fashion.vo.MemberVO;

public class SignupControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		

		request.getRequestDispatcher("WEB-INF/html/signup.jsp").forward(request, response);

	
  }
}
