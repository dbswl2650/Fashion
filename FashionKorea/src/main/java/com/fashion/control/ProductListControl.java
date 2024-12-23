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
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClothesDAO cdao = new ClothesDAO();
		List<Integer> clothesNoList = cdao.selectSomeClothes();
		List<Clothes> clothesList = new ArrayList<>();
		
		for (int i = 0; i < clothesNoList.size(); i++) {
			Integer clothesNo = clothesNoList.get(i);
			Clothes clothes = cdao.selectOneClothes(clothesNo);
			clothesList.add(clothes);
		}
		
		request.setAttribute("clothesList", clothesList);
		request.getRequestDispatcher("WEB-INF/html/productList.jsp").forward(request, response);
	}
}
