package com.fashion.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.LoginDAO;
import com.fashion.vo.MemberVO;
import com.google.gson.Gson;

public class SelectSameIdcontrol implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // 한글 설정
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8");

        // 1. 아이디 전달받기
        StringBuilder sel = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                sel.append(line);
            }
        }
      
        String jsonString = sel.toString();
        Gson gson = new Gson();
        Map<String, String> data = gson.fromJson(jsonString, Map.class);
        String uid = data.get("uid");

        // 2. DB에 있는 지 확인하기
        LoginDAO loginDAO = new LoginDAO();
        boolean hasSameId = loginDAO.selectSameId(uid);

        // 3. 결과 전달하기
        Map<String, Object> result = new HashMap<>();
        result.put("hasSameId", hasSameId);

        response.getWriter().write(gson.toJson(result));
    }
}

