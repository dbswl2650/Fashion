package com.fashion.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.LikeItDAO;

public class LikeItListControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object member_no = request.getSession().getAttribute("member_no");
		int mno = member_no != null ? (int) member_no : 0;
		
		LikeItDAO lidao = new LikeItDAO();
		List<Integer> likeList = lidao.selectLikes(mno);
		
		request.setAttribute("likeList", likeList);
		if(mno != 0) {
			request.getRequestDispatcher("WEB-INF/html/likeItList.jsp").forward(request, response);
		}
	}
}
