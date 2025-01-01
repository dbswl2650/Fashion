package com.fashion.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.ReviewDAO;
import com.fashion.vo.Review;

public class ReviewListControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ReviewDAO rdao = new ReviewDAO();

		String keyword = request.getParameter("keyword"); // 검색어

		List<Review> reviews;
		if (keyword != null && !keyword.isEmpty()) {
			// 검색어가 있으면 검색
			reviews = rdao.searchReviews(keyword);
		} else {
			// 검색어 없으면 모든 게시글 조회
			reviews = rdao.getAllReviews();
		}

		request.setAttribute("reviews", reviews);
		request.setAttribute("keyword", keyword);
		request.getRequestDispatcher("WEB-INF/html/reviewList.jsp").forward(request, response);
	}

}
