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
import com.fashion.control.LoginControl;
import com.fashion.control.LoginFormControl;
import com.fashion.control.MainControl;
import com.fashion.control.MyPageControl;
import com.fashion.control.ProductListControl;
import com.fashion.control.productDetailControl;
import com.fashion.control.productDetailFormControl;

public class FrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, Control> map;

	public FrontControl() {
		map = new HashMap<>(); // 필드의 값을 초기화
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.ko", new MainControl());	// 목록보기
		
		map.put("/loginForm.ko", new LoginFormControl());
		map.put("/login.ko", new LoginControl()); // 로그인 페이지 보기
		
		map.put("/myPage.ko", new MyPageControl()); // 마이페이지 보기

		map.put("/productList.ko", new ProductListControl());
		map.put("/productDetailForm.ko", new productDetailFormControl());
		map.put("/productDetail.ko", new productDetailControl());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:80/fashion_lje/*
		String context = request.getContextPath();
		String path = request.getRequestURI().substring(context.length());

		System.out.println(path);

		// 요청url === 실행할 컨트롤
		Control control = map.get(path);
		control.exec(request, response);
	}
}