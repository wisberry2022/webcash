package com.sql;

public class DataBean {
	private String userid = null;
	private	String pwd = null;
	private String email = null;
	private byte typeid;
	private boolean loginState = false;

	public DataBean() {}

	public boolean isLoginState() {
		return loginState;
	}

	public void setLoginState(boolean loginState) {
		this.loginState = loginState;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getTypeid() {
		return typeid;
	}

	public void setTypeid(byte typeid) {
		this.typeid = typeid;
	}
	
	
	
}
