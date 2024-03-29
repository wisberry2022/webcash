package com.bit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;
import com.bit.model.EmpDto;

public class EditController extends HttpServlet {
	Logger log = Logger.getLogger("com.bit.controller.DetailController");
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDao dao = new EmpDao();
		int empno = Integer.parseInt(req.getParameter("empno"));
		try {
			EmpDto bean = dao.getOne(empno);
			req.setAttribute("dto", bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String viewName = "detail.jsp";
		if(req.getRequestURI().contains("edit"))
			viewName = "edit.jsp";
		
		RequestDispatcher rd = req.getRequestDispatcher(viewName);
		rd.forward(req,resp);
	}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Enumeration<String> en = req.getParameterNames();
//		while(en.hasMoreElements()) {
//			String a = en.nextElement();
//			log.info("empno=" + a);
//		}
//
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno = Integer.parseInt(req.getParameter("empno"));
		String ename = req.getParameter("ename");
		int sal = Integer.parseInt(req.getParameter("sal"));
		int comm = Integer.parseInt(req.getParameter("comm"));
		int mgr = Integer.parseInt(req.getParameter("mgr"));
		
		EmpDao dao = new EmpDao();
		try {
			dao.editOne(ename, sal,  comm,  mgr, empno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("detail.do?empno=" + empno);
	}
}
