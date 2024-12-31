package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.DAO;
import com.fashion.dao.LoginDAO;
import com.fashion.vo.MemberVO;


public class DeleteMyPageServiceImplControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 설정
        request.setCharacterEncoding("UTF-8");

//		// 1. 회원 번호 일치 조회
////        String no = request.getParameter("no");
//        MemberVO member = .selectmember("member_No");
//		
//		// 2. DAO 호출
//        LoginDAO ldao = new LoginDAO();
//        boolean delete = ldao.deleteMember(no);
        
		String rno = request.getParameter("rno");
		
		LoginDAO rdao = new LoginDAO();
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
//		if rdao.deleteMember(Integer.parseInt(rno) {
			// {"retCode": "OK"}
			response.getWriter().print("{\"retCode\": \"OK\"}");
//	    }
//	     else {
//		    // {"retCode": "Fail"}
//		    response.getWriter().print("{\"retCode\": \"Fail\"}");
//	       }			
		}
	}


