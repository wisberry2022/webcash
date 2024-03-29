package com.bit.sts01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.sts01.model.DeptDao;

public class AddController implements Controller {
	DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		if("GET".equals(request.getMethod())) {
			mav.setViewName("add");	
		}else {
			request.setCharacterEncoding("utf-8");
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			String dname = request.getParameter("dname");
			String loc = request.getParameter("loc");
					
			deptDao.insertOne(deptno, dname, loc);
			mav.setViewName("redirect:list.do");
		}
		
		return mav;	
	}

}
