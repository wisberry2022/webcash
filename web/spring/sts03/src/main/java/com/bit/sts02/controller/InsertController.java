package com.bit.sts02.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.bit.spring.model.DeptDao;
import com.bit.spring.model.DeptVo;

public class InsertController extends AbstractCommandController {
	Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mav = new ModelAndView("redirect:list.do");
//		return mav;
//	}

//	@Override(BaseCommandController)
//	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		ModelAndView mav = new ModelAndView("redirect:list.do");
//		return mav;
//	}

	@Override
	protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors)
			throws Exception {
		DeptVo bean = (DeptVo) command;
		if(bean.getDeptno() == 0) {
			ObjectError error = new ObjectError("deptno", "미입력 또는 0");
			errors.addError(error);
		}
		if(bean.getLoc().isEmpty()) {
			ObjectError error = new ObjectError("loc", "지역을 입력하세요");
			errors.addError(error);
		}
		if(bean.getDname().isEmpty()) {
			ObjectError error = new ObjectError("dname", "부서명을 입력하세요");
			errors.addError(error);
		}
	}
	
// AbstractCommandController
@Override
protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
		BindException errors) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(errors.hasErrors()) {
			Map<String, String> errs = new HashMap<>();
			List<ObjectError> list = errors.getGlobalErrors();
			for(ObjectError err:list)
				errs.put(err.getObjectName(),err.getDefaultMessage());
			mav.addObject("errs", errs);
			mav.setViewName("dept/add");
		}else {
			DeptVo bean = (DeptVo) command;
			deptDao.insertOne(bean);
			mav.setViewName("redirect:list.do");
		}
		return mav;
	}
}
