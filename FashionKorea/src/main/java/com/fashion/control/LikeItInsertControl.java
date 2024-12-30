package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.LikeItDAO;

public class LikeItInsertControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object member_no = request.getSession().getAttribute("member_no");
		int mno = member_no != null ? (int) member_no : 0;
		int cno = Integer.parseInt(request.getParameter("cno"));
		LikeItDAO lidao = new LikeItDAO();
		
		boolean result = lidao.insertLike(mno, cno);
		System.out.println("POST 결과는 " + result);
		
		if (result) {
			// {"retCode": "OK"}
			response.getWriter().print("{\"retCode\": \"OK\"}");
		}
		else {
			// {"retCode": "Fail"}
			response.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	}
}
