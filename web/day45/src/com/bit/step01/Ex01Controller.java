package com.bit.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// tomcat은 사용자가 생성한 클래스를 인식하지 못하기 때문에 항상 Servlet interface를 상속받아 구현된다.
public class Ex01Controller implements Servlet {
	ServletConfig config = null;
	
	@Override
	public void destroy() {
		System.out.println("destroy");
		
	}

	// getter
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("config");
		return config;
	}

	// getter
	@Override
	public String getServletInfo() {
		System.out.println("ServletInfo");
		return "test writing but not out";
	}

	// 서버가 최초로 실행될 때, 단 한번, Ex01Controller 객체가 생성된다.
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init " + arg0);
		config = arg0;
	}

	// service 메소드에서 들어온 요청을 처리한다.
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service");
		// 인코딩 설정하기
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=UTF-8");
		// 브라우저 쪽으로 보내야하므로 OutputStream
		PrintWriter out = res.getWriter();
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"utf-8\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>한글 서블릿</h1>");
			out.println("</body>");
			out.println("</html>");
		}finally {
			out.close();	
		}
	}
	
}
