package com.fashion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.control.CartControl;
import com.fashion.control.CartFormControl;
import com.fashion.control.Control;
import com.fashion.control.LoginControl;
import com.fashion.control.LoginFormControl;
import com.fashion.control.LogoutControl;
import com.fashion.control.MainControl;
import com.fashion.control.MyPageControl;
import com.fashion.control.ProductDetailControl;
import com.fashion.control.ProductDetailFormControl;
import com.fashion.control.ProductListControl;
import com.fashion.control.SignupControl;
import com.fashion.control.SignupProcessControl;

public class FrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, Control> map;

	public FrontControl() {
		map = new HashMap<>(); // 필드의 값을 초기화
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		map.put("/main.ko", new MainControl()); // 목록보기
		map.put("/myPage.ko", new MyPageControl()); // 마이페이지 보기

		map.put("/loginForm.ko", new LoginFormControl());
		map.put("/login.ko", new LoginControl()); // 로그인 페이지 보기
		map.put("/logout.ko", new LogoutControl()); // 로그아웃

		map.put("/signup.ko", new SignupControl()); // 회원가입 페이지
		map.put("/signupProcess.ko", new SignupProcessControl()); // 회원가입 프로세스 제어

		map.put("/myPage.ko", new MyPageControl()); // 마이페이지 보기

		map.put("/productList.ko", new ProductListControl()); // 상품 목록
		
		map.put("/cartForm.ko", new CartFormControl());
		map.put("/cart.ko", new CartControl());
		
		map.put("/productDetail.ko", new ProductDetailControl());
		
		map.put("/cartForm.ko", new CartFormControl());
		map.put("/cart.ko", new CartControl()); 
		
		map.put("/productDetailForm.ko", new ProductDetailFormControl());
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