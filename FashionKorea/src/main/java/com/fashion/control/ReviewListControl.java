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

		String keyword = request.getParameter("keyword"); // 검색어
		String page = request.getParameter("page");
		ReviewDAO rdao = new ReviewDAO();
		
		int page_num = 1;
		if (page != null && page.matches("[+]?\\d+")) {
			page_num = Integer.parseInt(page);
		}
		
		int total_page = (int) Math.ceil(rdao.selectCountAllReview() / 10.0);
		if (page_num < 1) {
			page_num = 1;
		}
		if (page_num > total_page) {
			page_num = total_page;
		}
		
		int min_page = (page_num - 1) / 10 * 10 + 1;
		int max_page = min_page + 9;
		max_page = max_page < total_page ? max_page : total_page;
		
		List<Review> reviews = rdao.selectReviews(keyword, page_num);
//		if (keyword != null && !keyword.isEmpty()) {
//			// 검색어가 있으면 검색
//			reviews = rdao.searchReviews(keyword);
//		} else {
//			// 검색어 없으면 모든 게시글 조회
//			reviews = rdao.getAllReviews();
//		}

//		System.out.println("reviews are " + reviews);
//		System.out.println("reviews.size is " + reviews.size());
		
		request.setAttribute("reviews", reviews);
		request.setAttribute("keyword", keyword);
		request.setAttribute("minPage", min_page);
		request.setAttribute("maxPage", max_page);
		request.getRequestDispatcher("WEB-INF/html/reviewList.jsp").forward(request, response);
	}
}
