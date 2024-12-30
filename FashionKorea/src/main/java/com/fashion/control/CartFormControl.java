package com.fashion.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fashion.dao.CartDAO;
import com.fashion.dao.LoginDAO;
import com.fashion.vo.CartItem;
import com.fashion.vo.MemberVO;

public class CartFormControl implements Control {
       @Override
       public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           resp.setContentType("text/json;charset=utf-8");
           
           HttpSession session = req.getSession();
           String memberId = (String) session.getAttribute("member_id");
           LoginDAO ldao = new LoginDAO();
           MemberVO mvo = ldao.getMemberInfo(memberId);                  
           CartDAO cartDAO = new CartDAO();
           List<CartItem> cartItem = cartDAO.selectCart(memberId);          
           req.setAttribute("cartItem", cartItem);         
           req.getRequestDispatcher("WEB-INF/html/cart.jsp").forward(req, resp);
       }
   


}