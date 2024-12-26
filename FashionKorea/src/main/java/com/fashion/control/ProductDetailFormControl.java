package com.fashion.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.ClothesDAO;
import com.fashion.dao.ReviewDAO;
import com.fashion.vo.Clothes;
import com.fashion.vo.Review;

public class ProductDetailFormControl implements Control {
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cno = req.getParameter("cno");
		
		ClothesDAO cdao = new ClothesDAO();
		Clothes clothes = cdao.selectOneClothes(Integer.parseInt(cno));
		
		ReviewDAO rdao = new ReviewDAO();
		
		List<Review> result = rdao.review(cno);
		
		req.setAttribute("cloth", clothes);
		req.setAttribute("review", result);
		req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
	}
}
