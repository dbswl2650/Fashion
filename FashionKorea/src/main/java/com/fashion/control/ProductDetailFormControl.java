package com.fashion.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.ClothesDAO;
import com.fashion.vo.Clothes;

public class ProductDetailFormControl implements Control {
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cno = req.getParameter("cno");
		if (cno == null) {
			cno = "0";
		}
		
		ClothesDAO cdao = new ClothesDAO();
		Clothes clothes = cdao.selectOneClothes(Integer.parseInt(cno));
		
		req.setAttribute("cloth", clothes);		
		req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
	}
}
