package com.fashion.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.ClothesDAO;
import com.fashion.dao.LikeItDAO;
import com.fashion.dao.ReviewDAO;
import com.fashion.vo.Clothes;
import com.fashion.vo.Review;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProductDetailFormControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer member_no = (Integer) req.getSession().getAttribute("member_no");
		int mno = member_no != null ? (int) member_no : 0;
		int cno = Integer.parseInt(req.getParameter("cno")); //사용자한테 cno정보를 받음
//
		ClothesDAO cdao = new ClothesDAO(); //ClothesDAO에서 cdao변수를 생성해서 정보를 담음
		Clothes clothes = cdao.selectOneClothes(cno); //selectOneCohtes메소드를 불러와 cdao변수에 담고 그 값을 clothes에 담음
		
		ReviewDAO rdao = new ReviewDAO();
		Review review = new Review();
	
		List<Review> result = rdao.review(cno);
		
		LikeItDAO lidao = new LikeItDAO();
		boolean hasLike = lidao.hasLike(mno, cno);
//		
//		String title = req.getParameter("title");
//        String comments = req.getParameter("comments");
//        int clothesNo = Integer.parseInt(req.getParameter("clothesNo"));
//        String image = req.getParameter("image");
//        String type = req.getParameter("리뷰");
//        String score = req.getParameter("score");
//       
//        boolean reviews = rdao.insertReviews(title, comments, member_no, clothesNo, image, type, score);
//        
		req.setAttribute("clothes", clothes);
		req.setAttribute("review", result);
		req.setAttribute("hasLike", hasLike);
//		req.setAttribute("re", reviews);
//		
//		Gson gson = new GsonBuilder().create();
//		String json = gson.toJson(reviews);
//		resp.getWriter().print(json);
//		
		req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
	}
}
