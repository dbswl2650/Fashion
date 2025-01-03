package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.ReviewDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReviewInfoDeleteControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8"); 
		
		String reviewNo = request.getParameter("reviewNo");
		
		ReviewDAO reviewDAO = new ReviewDAO();
		boolean isSuccessed = reviewDAO.deleteReview(Integer.valueOf(reviewNo));
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(isSuccessed);
		
		response.getWriter().print(json);
	}

}
