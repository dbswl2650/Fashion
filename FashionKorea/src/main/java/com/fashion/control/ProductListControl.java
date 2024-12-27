package com.fashion.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.CategoryDAO;
import com.fashion.dao.ClothesDAO;
import com.fashion.dao.OrdersItemDAO;
import com.fashion.dao.ReviewDAO;
import com.fashion.vo.Category;
import com.fashion.vo.Clothes;
import com.fashion.vo.Review;

public class ProductListControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		
		ClothesDAO cldao = new ClothesDAO();
		CategoryDAO cadao = new CategoryDAO();
		OrdersItemDAO oidao = new OrdersItemDAO();
		ReviewDAO rdao = new ReviewDAO();
		
		List<Integer> clothesNoList = cldao.selectSomeClothes(search);
		List<Clothes> clothesList = new ArrayList<>();
		List<Category> categoryList = new ArrayList<>();
		List<Boolean> isFamousList = new ArrayList<>();
		List<Integer> reviewCntList = new ArrayList<>();
		
		for (int i = 0; i < clothesNoList.size(); i++) {
			Integer clothesNo = clothesNoList.get(i);
			Clothes clothes = cldao.selectOneClothes(clothesNo);
			clothesList.add(clothes);
			
			Integer categoryNo = clothes.getCategoryNo();
			Category category = cadao.selectOneCategory(categoryNo);
			categoryList.add(category);
			
			Boolean isFamous = false;
			if (oidao.selectClothesNoCount(clothesNo) >= 5) {	// 5가 바로 인기 임계치
				isFamous = true;
			}
			isFamousList.add(isFamous);
			
			Integer reviewCnt = rdao.selectCountReview(clothesNo);
			reviewCntList.add(reviewCnt);
		}
		
		request.setAttribute("clothesList", clothesList);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("isFamousList", isFamousList);
		request.setAttribute("reviewCntList", reviewCntList);
		request.getRequestDispatcher("WEB-INF/html/productList.jsp").forward(request, response);
	}
}
