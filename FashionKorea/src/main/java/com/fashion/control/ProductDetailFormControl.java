package com.fashion.control;

import java.io.IOException;
import java.util.List;

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
//		resp.setContentType("text/json;charset=utf-8");
		
		String cno = req.getParameter("cno"); //사용자한테 cno정보를 받음
//		String quantity = req.getParameter("quantity");
//		String memberNo = req.getParameter("memberNo");

		ClothesDAO cdao = new ClothesDAO(); //ClothesDAO에서 cdao변수를 생성해서 정보를 담음
		Clothes clothes = cdao.selectOneClothes(Integer.parseInt(cno)); //selectOneCohtes메소드를 불러와 cdao변수에 담고 그 값을 clothes에 담음
		
		ReviewDAO rdao = new ReviewDAO(); //ReviewDAO에서 rdao을 담을 변수 생성
		List<Review> result = rdao.review(cno); //review메소드를 불러와 rdao에 담고 result라고 선언
		
		req.setAttribute("clothes", clothes); //clothes에 담은 값을 setAtrribute로 jsp파일로 보냄
		req.setAttribute("review", result); //result에 담은 값을 review라고 선언한뒤 그 값을 jsp파일로 보냄
		req.getRequestDispatcher("WEB-INF/html/productDetail.jsp").forward(req, resp);
	}
}
