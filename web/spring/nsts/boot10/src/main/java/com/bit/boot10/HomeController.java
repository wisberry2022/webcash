package com.bit.boot10;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.boot10.service.UserDetailImpl;

@Controller
public class HomeController {

	@GetMapping("/login")
	public void login() {
		SecurityContext context = SecurityContextHolder.getContext();
		boolean isLogin = context.getAuthentication().isAuthenticated();
		System.out.println(isLogin);
	}
	
	@GetMapping("/dept/")
	public String list(Authentication authentication, @AuthenticationPrincipal UserDetails userDetails) {
		System.out.println(((UserDetailImpl)authentication.getPrincipal()).getJob());
		
		SecurityContext context = SecurityContextHolder.getContext();
		UserDetailImpl user = (UserDetailImpl)context.getAuthentication().getPrincipal();
		System.out.println(user.getJob());
		System.out.println(user.getMgr());
		
		return "dept/index";
	}
}
