package com.fashion.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectSameIdcontrol implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 한글 설정
        request.setCharacterEncoding("UTF-8");
        
        // ChartDataControl.java 파일 참고 Gson 
        // board.js 파일 참고 fetch 필터 사용해서 하기 
        
        // 1. 아이디 전달받기 // 폼 데이터 가져오기       
        String name = request.getParameter("name");
        String id = request.getParameter("uid");
        String pw = request.getParameter("upw");
        String confirmPw = request.getParameter("confirm_upw");
        String mail = request.getParameter("em");
        String phone = request.getParameter("pho");
        String age = request.getParameter("da");
        String address = request.getParameter("add");
}
		
		// 2. DB에 있는 지 확인하기 // 같은 id가 있는지 없는지 검증하는 함수	
//		public boolean SelectSameId(String id) {
//	    	connect();
//	    	String sql = "select member_id from member member_id=?";
//	    	
//	    	try {
//	    		psmt = conn.prepareStatement(sql);
//	    		psmt.setString(1, id);
//	    		rs = psmt.executeQuery();
//	    		
//	    		while (rs.next()) {
//	    			return true;
//	    		}
//	    	} catch (SQLException e) {
//	    		e.printStackTrace();
//	    	} finally {
//	    		disConnect();
//	    	}
//	    	return false;
//		}
		
//		// 3. 결과 전달하기
//		fetch('removeReply.do?rno=' + rno)
//		.then(result => result.json())
//		.then(result => {
//
//		})
//		.catch(err => console.log(err));
		
//	}

}
