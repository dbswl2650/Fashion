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
            // 삭제가 성공하면 목록 페이지로 리다이렉트
            response.sendRedirect("reviewList.ko");
        } else {
            // 삭제 실패 시 에러 메시지와 함께 목록 페이지로 돌아가기
            request.setAttribute("error", "게시글 삭제에 실패했습니다.");
            request.getRequestDispatcher("WEB-INF/html/review.jsp").forward(request, response);
        }

	}

}
