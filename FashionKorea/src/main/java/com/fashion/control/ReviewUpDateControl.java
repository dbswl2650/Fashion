package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.ReviewDAO;
import com.fashion.vo.Review;

public class ReviewUpDateControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ReviewDAO rdao = new ReviewDAO();

		    if (request.getMethod().equals("GET")) {
		        int reviewNo = Integer.parseInt(request.getParameter("review_no"));
		        Review review = rdao.selectReview(reviewNo);

		        if (review != null) {
		            request.setAttribute("review", review);
		            request.getRequestDispatcher("WEB-INF/html/reviewUpDate.jsp").forward(request, response);
		        } else {
		            request.getRequestDispatcher("WEB-INF/html/reviewList.jsp").forward(request, response);
		        }
		    } else if (request.getMethod().equals("POST")) {

		        int reviewNo = Integer.parseInt(request.getParameter("review_no"));
		        String title = request.getParameter("title");
		        String comments = request.getParameter("comments");

		        Review review = new Review();
		        review.setReviewNo(reviewNo);
		        review.setTitle(title);
		        review.setComments(comments);
		        review.setWdateDate(new java.sql.Date(System.currentTimeMillis()));

		        boolean success = rdao.updateReview(review);

		        if (success) {
		            response.sendRedirect("review.ko?review_no=" + reviewNo);
		        } else {
		            request.getRequestDispatcher("WEB-INF/html/reviewUpDate.jsp").forward(request, response);
		        }
		    }
	}

}
