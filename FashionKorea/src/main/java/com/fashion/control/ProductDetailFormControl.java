package com.fashion.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.ClothesDAO;

public class ProductDetailFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cno = req.getParameter("clothesNo");
		String name = req.getParameter("name");

		Set<String> recentViewProducts = null;
		
		
		
		if(cno != null) {
			
			req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
		}
		
	}

}
