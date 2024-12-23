package com.fashion.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.ClothesDAO;
import com.fashion.vo.Clothes;

public class ProductListControl implements Control {
	ClothesDAO cdao = new ClothesDAO();
	
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getMethod().equals("GET")) {
			List<Integer> clothesNoList = cdao.selectSomeClothes();
			List<Clothes> clothesList = new ArrayList<>();
			
			for (int i = 0; i < clothesNoList.size(); i++) {
				Integer clothesNo = clothesNoList.get(i);
				Clothes clothes = cdao.selectOneClothes(clothesNo);
//				System.out.println(clothes + ", " + clothes.getClass().getName());
//				System.out.println(clothes.getAbout() + ", " + clothes.getAbout().getClass().getName());
				clothesList.add(clothes);
			}
			
			request.setAttribute("clothesList", clothesList);
			request.getRequestDispatcher("WEB-INF/html/productList.jsp").forward(request, response);
		}
		else if (request.getMethod().equals("POST")) {
		}
		else if (request.getMethod().equals("PUT")) {
		}
		else if (request.getMethod().equals("DELETE")) {
		}
	}
}
