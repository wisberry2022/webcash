package com.bit.util;

public class LogState {
	private String state;
	
	public LogState(int num) {
		if(num == 1) {
			state = "success";
		}else if(num == 2) {
			state = "fail";
		}else if(num == 0) {
			state = "nodata";
		}
	}
	
	public String getState() {
		return state;
	}
}
