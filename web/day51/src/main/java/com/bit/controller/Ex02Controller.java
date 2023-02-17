package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class Ex02Controller extends HttpServlet {
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		// 로그아웃 처리 방법
		// 동일한 세션 id의 값을 바꾸는 것
//		session.setAttribute("id", null);
//		session.removeAttribute("id");
		
		// 세션 id를 바꿔버린다.매 접속마다 세션 id가 바뀐다
		session.invalidate();
		System.out.println(session.getId());
		
		req.getRequestDispatcher("ex02.jsp").forward(req,  resp);
	}
}
