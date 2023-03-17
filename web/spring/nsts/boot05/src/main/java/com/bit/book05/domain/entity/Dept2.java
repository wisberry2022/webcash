package com.bit.book05.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.ToString;

@Entity
@ToString
@Getter
public class Dept2 {
	@Id
	private int deptno;
	private String dname;
	private String loc;
}
