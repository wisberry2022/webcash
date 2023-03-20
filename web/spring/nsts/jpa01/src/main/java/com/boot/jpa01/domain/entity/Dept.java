package com.boot.jpa01.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class Dept {
	@Id
	private int deptno;
	private String dname;
	private String loc;
}
