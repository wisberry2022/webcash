package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.frame.web.Controller;
import com.bit.model.DeptDao;

public class UpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest req) {
		int deptno = Integer.parseInt(req.getParameter("deptno"));
		String dname = req.getParameter("dname");
		String loc = req.getParameter("loc");
		DeptDao dao = new DeptDao();
		System.out.println("updateController: " + deptno + "\t" + dname + "\t" + loc);
		dao.updateOne(deptno, dname, loc);
		return "redirect:list.do";
	}
}
