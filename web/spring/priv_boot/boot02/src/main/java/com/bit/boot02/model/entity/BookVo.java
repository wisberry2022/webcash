package com.bit.boot02.model.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookVo {
	private int num;
	private String name, author, publish, uploadFile;
}
