package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.LoginDAO;
import com.fashion.dao.ReviewDAO;
import com.fashion.vo.MemberVO;
import com.fashion.vo.Review;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReviewDAO rdao = new ReviewDAO();

		if (request.getMethod().equals("GET")) {
            // 단일 게시글 조회
            String reviewNo = request.getParameter("review_no");
            if (reviewNo != null) {
                Review review = rdao.selectReview(Integer.parseInt(reviewNo));
                request.setAttribute("review", review);
                request.getRequestDispatcher("WEB-INF/html/review.jsp").forward(request, response);
            }
        } else if (request.getMethod().equals("POST")) {
            // 게시글 등록 처리
            String savePath = request.getServletContext().getRealPath("images");
            int maxSize = 1024 * 1024 * 5;

            MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
            String title = mr.getParameter("title");
            String comments = mr.getParameter("comments");
            String image = mr.getFilesystemName("image");
            
            int memberNo = Integer.parseInt(mr.getParameter("member_no"));

            Review review = new Review();
            review.setTitle(title);
            review.setComments(comments != null ? comments : "");
            review.setMemberNo(memberNo);
            review.setImage(image);
            review.setClothesNo(0);
            review.setType("게시글");
            review.setWdateDate(new java.sql.Date(System.currentTimeMillis()));

            boolean success = rdao.insertReview(review);
            if (success) {
                response.sendRedirect("reviewList.ko");
            } else {
                request.setAttribute("error", "게시글 등록에 실패했습니다.");
                request.getRequestDispatcher("WEB-INF/html/reviewForm.jsp").forward(request, response);
            }
        }
	}

}
