package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.ReviewDAO;

public class ReviewDeleteControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO rdao = new ReviewDAO();

        int reviewNo = Integer.parseInt(request.getParameter("review_no"));

        boolean success = rdao.deleteReview(reviewNo);

        if (success) {
            response.sendRedirect("reviewList.ko");
        } else {
            request.getRequestDispatcher("WEB-INF/html/review.jsp").forward(request, response);
        }

	}

}
