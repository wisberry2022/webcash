package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.frame.web.Controller;

public class AddController implements Controller {
	@Override
	public String execute(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return "dept/add";
	}
}
