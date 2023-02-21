package com.bit.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index.do")
public class IndexController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("id") != null) {
			System.out.println("session in index: " + session.getAttribute("id"));
			req.setAttribute("id", session.getAttribute("id"));
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}else {
			req.getRequestDispatcher("index.jsp").forward(req,resp);	
		}
		
		
	}
}
