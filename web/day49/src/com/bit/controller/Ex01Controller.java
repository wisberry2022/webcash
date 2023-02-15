package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// was container가 어노테이션을 통해 web.xml에 servlet 정보와 mapping을 자동으로 해준다
@WebServlet(value = "/ex01.do")
public class Ex01Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getClass().toString());
		RequestDispatcher rd = req.getRequestDispatcher("ex01.jsp");
		rd.forward(req, resp);
	}
}
