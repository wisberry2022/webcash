package com.bit.boot10.service;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class UserDetailImpl extends User {

	private String job;
	private LocalDate hiredate;
	private int mgr;
	
	public UserDetailImpl(String username, String password, Collection<? extends GrantedAuthority> authorities, String job, LocalDate hiredate, int mgr) {
		super(username, password, authorities);
		this.job = job;
		this.hiredate = hiredate;
		this.mgr = mgr;
	}

}
