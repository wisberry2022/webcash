package com.bit;

//javaBean - [정보의 은닉, 캡슐화] getter & setter
public class BbsBean {
	private int num;
	private String sub;
	private String id;
	private int cnt;
	private String content;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setNum(int num) {
		this.num = num;	
	}
	
	public void setSub(String sub) {
		this.sub = sub;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public int getNum() {
		return num;
	}

	public String getSub() {
		return sub;
	}

	public String getId() {
		return id;
	}

	public int getCnt() {
		return cnt;
	}
	
	
	
}
