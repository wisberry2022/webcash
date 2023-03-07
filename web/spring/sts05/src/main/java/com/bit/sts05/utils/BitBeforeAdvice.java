package com.bit.sts05.utils;

import org.aspectj.lang.JoinPoint;

public class BitBeforeAdvice {
	public void before(JoinPoint point) {
		System.out.println("args: " + point.getArgs());
		System.out.println("target: " + point.getTarget());
		System.out.println("signature: " + point.getSignature());
//		System.out.println("before에서 실행~");
	}
}
