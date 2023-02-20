package com.bit.util.filter;

import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class Ex01Filter implements javax.servlet.Filter{
   Logger log = Logger.getLogger("com.bit.controller.Ex02Controller");

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
      log.debug("시작할때");
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {
      log.debug("before ex01 filter");
      chain.doFilter(request, response);
      log.debug("after ex01 filter");
   }

   @Override
   public void destroy() {
      log.debug("서비스끝");
   }  
}