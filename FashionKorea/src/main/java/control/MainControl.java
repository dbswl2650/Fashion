package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClothesDAO;
import vo.Clothes;

public class MainControl implements Control {
	ClothesDAO cdao = new ClothesDAO();
	
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getMethod().equals("GET")) {
			List<Integer> clothesNoList = cdao.selectSomeClothes();
			List<Clothes> clothesList = new ArrayList<>();
			
			for (int i = 0; i < clothesNoList.size(); i++) {
				Integer clothesNo = clothesNoList.get(i);
				clothesList.add(cdao.selectOneClothes(clothesNo));
			}
			
			request.setAttribute("clothesList", clothesList);
			request.getRequestDispatcher("main.html").forward(request, response);
		}
		else if (request.getMethod().equals("POST")) {
		}
		else if (request.getMethod().equals("PUT")) {
		}
		else if (request.getMethod().equals("DELETE")) {
		}
	}
}
