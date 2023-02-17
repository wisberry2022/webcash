package com.bit.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex01.do")
public class Ex01Controller extends HttpServlet {
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie: cookies) {
			String name = cookie.getName();
			String value = cookie.getValue();
			if(name.equals("id")) {
				value = URLDecoder.decode(value, "utf-8");
				req.setAttribute("cookID", value);
			}else if(value.equals("ck")) {
				req.setAttribute("cookCK", "checked");
			}
			
		}
		
		req.getRequestDispatcher("ex01.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String ck = req.getParameter("ck");
		
		HttpSession session = req.getSession();
		session.setAttribute("id", id);
		
		id = URLEncoder.encode(id, "utf-8");
		
		Cookie cookie = new Cookie("id",id);
		Cookie cookie2 = new Cookie("ck", ck);
		
		cookie.setMaxAge(30);
		resp.addCookie(cookie);
		resp.addCookie(cookie2);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
