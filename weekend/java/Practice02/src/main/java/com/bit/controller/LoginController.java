package com.bit.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.UserDao;
import com.bit.model.UserDto;

@WebServlet("/page/login.do")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		try {
			UserDao dao = new UserDao();
			UserDto dto = new UserDto();
			
			dto.setId(id);
			dto.setPwd(pwd);
			
			if(dao.isLogin(dto).equals("success")) {
				resp.sendRedirect("../index.do");
			}else if(dao.isLogin(dto).equals("fail")) {
				resp.setStatus(resp.SC_BAD_REQUEST);
			}else if(dao.isLogin(dto).equals("nodata")) {
				resp.setStatus(resp.SC_NOT_FOUND);
			};
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
