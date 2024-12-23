package com.fashion.control;

import java.io.IOException;

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
		if (cno == null) {
			cno = "0";
		}
		
		ClothesDAO cdao = new ClothesDAO();
		Clothes clothes = cdao.selectOneClothes(Integer.parseInt(cno));
		ReviewDAO rdao = new ReviewDAO();
		Review review = rdao.review(Integer.parseInt(cno));
		
		req.setAttribute("cloth", clothes);
		req.setAttribute("review", review);
		req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
	}
}