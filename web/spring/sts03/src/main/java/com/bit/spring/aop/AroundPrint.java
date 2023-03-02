package com.bit.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundPrint implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// Servlet filter와 비슷하게 동작한다.
		System.out.println("before around");
		Object obj = null;
		try {
			obj=invocation.proceed();
			System.out.println("after returning");
		}catch(Exception e) {
			System.out.println("after throw");
		}
		// invoke 실행 후 후조치
//		System.out.println("after...");
		return obj;
	}

}
