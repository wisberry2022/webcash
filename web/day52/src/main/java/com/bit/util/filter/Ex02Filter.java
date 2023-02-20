package com.bit.util.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class Ex02Filter implements javax.servlet.Filter {
	Logger log = Logger.getLogger("com.bit.util.filter.Ex02Filter");
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.debug("before ex02 filter");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		log.debug("after ex02 filter");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
