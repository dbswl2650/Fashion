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
		        // 폼에서 전달된 데이터 받아오기
		        int reviewNo = Integer.parseInt(request.getParameter("review_no"));  // 수정할 게시글 번호
		        String title = request.getParameter("title");  // 수정된 제목
		        String comments = request.getParameter("comments");  // 수정된 내용 (원래 content로 되어 있었다면 comments로 맞추세요)

		        // Review 객체 생성하여 수정할 데이터 설정
		        Review review = new Review();
		        review.setReviewNo(reviewNo);
		        review.setTitle(title);
		        review.setComments(comments);  // 수정된 내용
		        review.setWdateDate(new java.sql.Date(System.currentTimeMillis()));

		        // 수정 요청을 DAO에 전달하여 결과 확인
		        boolean success = rdao.updateReview(review);

		        if (success) {
		            // 수정 성공 시 상세 페이지로 리다이렉트
		            response.sendRedirect("review.ko?review_no=" + reviewNo);
		        } else {
		            // 수정 실패 시 다시 수정 화면으로 돌아가도록 설정
		            request.setAttribute("error", "게시글 수정에 실패했습니다.");
		            request.getRequestDispatcher("WEB-INF/html/reviewUpDate.jsp").forward(request, response);
		        }
		    }
	}

}
