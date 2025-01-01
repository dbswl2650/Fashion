package com.fashion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.control.CartInfoUpdateControl;
import com.fashion.control.CartFormControl;

import com.fashion.control.CartInfoDeleteControl;

import com.fashion.control.CartInsertItemControl;

import com.fashion.control.Control;

import com.fashion.control.DeleteMyPageCheckControl;
import com.fashion.control.DeleteMyPageServiceImplControl;

import com.fashion.control.LikeItDeleteControl;
import com.fashion.control.LikeItInsertControl;
import com.fashion.control.LikeItListControl;

import com.fashion.control.LoginControl;
import com.fashion.control.LoginFormControl;
import com.fashion.control.LogoutControl;
import com.fashion.control.MainControl;
import com.fashion.control.MyPageControl;
import com.fashion.control.MyPageFormControl;
import com.fashion.control.OrderControl;
import com.fashion.control.OrderHistoryControl;
import com.fashion.control.OrderPageControl;
import com.fashion.control.ProductDetailControl;
import com.fashion.control.ProductDetailFormControl;
import com.fashion.control.ProductListControl;
import com.fashion.control.ReviewControl;
import com.fashion.control.ReviewDeleteControl;
import com.fashion.control.ReviewFormControl;
import com.fashion.control.ReviewListControl;
import com.fashion.control.ReviewUpDateControl;
import com.fashion.control.SelectSameIdcontrol;
import com.fashion.control.SignupControl;
import com.fashion.control.SignupProcessControl;
import com.fashion.control.UpDateMemberControl;
import com.fashion.control.UpDateMyPageCheckControl;

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
		map.put("/myPageForm.ko", new MyPageFormControl());
		map.put("/upDateMyPageCheck.ko", new UpDateMyPageCheckControl()); // 수정전 인증
		map.put("/upDateMember.ko", new UpDateMemberControl()); // 회원정보 수정
		
		map.put("/review.ko", new ReviewControl()); // 게시글 추가
		map.put("/reviewForm.ko", new ReviewFormControl());
		map.put("/reviewList.ko", new ReviewListControl()); // 게시글 목록
		map.put("/reviewUpDate.ko", new ReviewUpDateControl());// 게시글 수정
		map.put("/reviewDelete.ko", new ReviewDeleteControl());// 게시글 삭제

		map.put("/deleteMyPageServiceImpl.ko", new DeleteMyPageServiceImplControl());
		map.put("/deleteMyPageCheck.ko", new DeleteMyPageCheckControl());


		map.put("/loginForm.ko", new LoginFormControl());
		map.put("/login.ko", new LoginControl()); // 로그인 페이지 보기
		map.put("/logout.ko", new LogoutControl()); // 로그아웃

		map.put("/signup.ko", new SignupControl()); // 회원가입 페이지
		map.put("/signupProcess.ko", new SignupProcessControl()); // 회원가입 프로세스 제어
		map.put("/selectSameId.ko", new SelectSameIdcontrol()); // 아이디 중복검사

		map.put("/productList.ko", new ProductListControl()); // 상품 목록
		
		map.put("/cartForm.ko", new CartFormControl()); //회원 장바구니 
		map.put("/updateCart.ko", new CartInfoUpdateControl()); //장바구니 수량 변경
		map.put("/delCartInfo.ko", new CartInfoDeleteControl());//장바구니 삭제
		map.put("/orderPage.ko", new OrderPageControl());//주문창
		map.put("/orderHistory.ko", new OrderHistoryControl());
		map.put("/updateorderPage.ko", new OrderControl());//주문창
		
		map.put("/cartInsertItem.ko", new CartInsertItemControl()); // 장바구니 추가 기능
		map.put("/productDetailForm.ko", new ProductDetailFormControl()); // 상품상세 목록
		
		map.put("/productDetailForm.ko", new ProductDetailFormControl());
		
		map.put("/likeItInsertForm.ko", new LikeItInsertControl());
		map.put("/likeItDeleteForm.ko", new LikeItDeleteControl());
		map.put("/likeItList.ko", new LikeItListControl());
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

		if (control == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
			return;
		}
		System.out.println("Request Path: " + path);
		System.out.println("Control Object: " + (control != null ? control.getClass().getName() : "null"));
		control.exec(request, response);
	}
}