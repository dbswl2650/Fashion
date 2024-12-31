package com.fashion.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.CartDAO;
import com.fashion.vo.CartItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CartInfoUpdateControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				resp.setContentType("text/json;charset=utf-8");
				String quantity = req.getParameter("quantity");
			    String cartNo = req.getParameter("cartNo");
			    // 회원 ID

			    // 필요한 값 파싱
			    int quantitys = Integer.parseInt(quantity);
			    int cartNos = Integer.parseInt(cartNo);

			    // DAO 호출
			    CartDAO cartDAO = new CartDAO();
			    boolean update = cartDAO.updateCartItem(cartNos,quantitys);

			    // JSON 변환 및 응답
			    Gson gson = new GsonBuilder().create();
			    String json = gson.toJson(update); // 단순히 성공 여부를 JSON으로 변환
			    resp.getWriter().print(json); // 클라이언트로 JSON 응답
	}

}
