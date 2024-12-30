package com.fashion.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.CategoryDAO;
import com.fashion.dao.ClothesDAO;
import com.fashion.dao.LikeItDAO;
import com.fashion.dao.OrdersItemDAO;
import com.fashion.dao.ReviewDAO;
import com.fashion.vo.Category;
import com.fashion.vo.Clothes;

public class LikeItListControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object member_no = request.getSession().getAttribute("member_no");
		int mno = member_no != null ? (int) member_no : 0;
		
		LikeItDAO lidao = new LikeItDAO();
		ClothesDAO cldao = new ClothesDAO();
		CategoryDAO cadao = new CategoryDAO();
		OrdersItemDAO oidao = new OrdersItemDAO();
		ReviewDAO rdao = new ReviewDAO();
		
		List<Integer> clothesNoList = lidao.selectLikes(mno);
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

		if(mno != 0) {
			request.getRequestDispatcher("WEB-INF/html/likeItList.jsp").forward(request, response);
		}
	}
}
