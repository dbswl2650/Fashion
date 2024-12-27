package com.fashion.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.LoginDAO;
import com.fashion.vo.MemberVO;

public class SelectSameIdcontrol implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 한글 설정
        request.setCharacterEncoding("UTF-8");
        
        // ChartDataControl.java 파일 참고 Gson 
        // board.js 파일 참고 fetch 필터 사용해서 하기 
        
        // 1. 아이디 전달받기 // 폼 데이터 가져오기       
        String id = request.getParameter("uid");

		
		// 2. DB에 있는 지 확인하기
        LoginDAO bado = new LoginDAO();
        boolean hasSameId = bado.selectSameId(id);       
		
		// 3. 결과 전달하기
		request.setAttribute("hasSameId", hasSameId);
		request.getRequestDispatcher("WEB-INF/html/signup.jsp").forward(request, response);
	}

}
