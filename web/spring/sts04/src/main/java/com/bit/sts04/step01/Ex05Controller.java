package com.bit.sts04.step01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts04.model.DeptVo;

@Controller
public class Ex05Controller {
	@RequestMapping(value="/ex11", method= {RequestMethod.POST, RequestMethod.GET})
	public String ex11() {
		return "ex01";
	}

//	Controller 요청 method 제한하기
//	parameter 전달 가능 - @RequestParam <type> <varName>
//	@RequestMapping(value="/ex12", method= {RequestMethod.POST})
//	public String ex12(@RequestParam String dname, @RequestParam int deptno) {
//		System.out.println("dname:" + dname);
//		System.out.println("deptno:" + deptno);
//		return "ex02";
//	}
	
	// RequestParam 생략이 가능하다.
	@RequestMapping(value="/ex12", method= {RequestMethod.POST})
	public String ex12(String dname, int deptno, Model model) {
		System.out.println("dname:" + dname);
		System.out.println("deptno:" + deptno);
		model.addAttribute("dname", dname);
		model.addAttribute("deptno", deptno);
		return "ex02";
	}
	
//	@RequestMapping("/ex13/{msg}}")
//	public String ex13(@PathVariable("1") String msg) {
//		System.out.println(msg);
//		
//		return "ex03";
//	}
	
	// PathVariable의 value값은 생략이 가능하나, PathVariable 자체의 생략은 불가능하다
	@RequestMapping("/ex13/{deptno}")
	public String ex13(@PathVariable int deptno) {
		System.out.println(deptno);
		return "ex03";
	}
	
	// Model 추가하기
	@RequestMapping("/ex14")
	public String ex14(@ModelAttribute("bean") DeptVo bean) {
		bean.setDeptno(2222);
		bean.setDname("test3");
		bean.setLoc("test4");
		return "ex04";
	}
}
