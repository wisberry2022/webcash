package com.bit.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

//@WebFilter(value = {"/ex01.do"})
public class Ex03Filter implements Filter {
	Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		req.setCharacterEncoding("utf-8");
		log.debug("after ex03 filter");
		// doFilter를 이용해야 서블릿으로 넘어간다
		chain.doFilter(request, response);
		log.debug("after ex03 filter");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
