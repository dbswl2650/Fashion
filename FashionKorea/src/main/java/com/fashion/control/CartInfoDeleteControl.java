package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.CartDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CartInfoDeleteControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fetch 사용시 1) 
		response.setContentType("text/json;charset=utf-8"); 
		
		// 장바구니에 등록되어 있는 상품이 무엇인지 확인 => Client(browser)에서 받아야 함.
		String cartNo = request.getParameter("cartNo");
		
		// 제일 중요한 기능 : 장바구니에 등록되어 있는 상품 하나를 삭제 
		CartDAO cartDAO = new CartDAO();
		boolean isSuccessed = cartDAO.deleteCartItem(Integer.valueOf(cartNo));
		
		// fetch 사용시 2) JSP가 없음.
//		response.getWriter().print("{ \"result\" : \"" + isSuccessed + "\" }");
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(isSuccessed); //자바객체 -> json문자열 반환
		
		response.getWriter().print(json);
		
		// 일반 페이지 호출 방식
		//request.setAttribute("result", result);
		//request.getRequestDispatcher("/WEB-INF/html/cart.jsp").forward(request, response);
	}

}
