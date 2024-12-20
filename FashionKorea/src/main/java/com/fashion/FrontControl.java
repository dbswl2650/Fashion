package com.fashion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.control.Control;
import com.fashion.control.MainControl;
import com.fashion.control.loginControl;


public class FrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, Control> map;
	public FrontControl() {
		map = new HashMap<>();	// 필드의 값을 초기화
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.ko", new MainControl());	// 목록보기
		map.put("/login.do", new loginControl()); // 로그인 링크
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:80/fashion_lje/*
		String context = request.getContextPath();
		String path = request.getRequestURI().substring(context.length());
		
		System.out.println(path);
		
		// 요청url === 실행할 컨트롤
		Control control = map.get(path);
		control.exec(request, response);
	}
}