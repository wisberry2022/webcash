package com.bit.sts06.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class DeptVo {
	
	private int deptno;
	private String dname, loc;
	
	public DeptVo() {}
	
	
	
}
