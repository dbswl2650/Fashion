import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Control;
import control.MainControl;


public class FrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, Control> map;
	public FrontControl() {
		map = new HashMap<>();	// 필드의 값을 초기화
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.ko", new MainControl());	// 목록보기
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:80/fashion_lje/*
		String context = request.getContextPath();
		String path = request.getRequestURI().substring(context.length());
		
		System.out.println(path);
		
		// 요청url === 실행할 컨트롤
		Control control = map.get(path);
		control.exec(request, response);
	}
}