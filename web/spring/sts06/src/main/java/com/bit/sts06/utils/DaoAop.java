package com.bit.sts06.utils;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DaoAop {

	@Around("execution(* com.bit.sts06.model.DeptDao.*(..))")
	public Object around(ProceedingJoinPoint join) {
		Object obj = null;
		
		try {
//			System.out.println();
			obj = join.proceed();
			System.out.println(obj);
		} catch (Throwable e) {
			System.out.println(e.toString());
		}
		System.out.println("after...");
		return obj;
	}
	
//	@Before(value = "execution(* com.bit.sts06.model.DeptDao.*(..))")
//	public void before(JoinPoint join) {
//		System.out.println("before dao..." + Arrays.toString(join.getArgs()));
//	}
//
//	@AfterThrowing(value = "execution(* com.bit.sts06.model.DeptDao.*(..))",
//			throwing = "err")
//	public void error(JoinPoint join, Exception err) {
//		System.out.println(err.toString());
//	}
//	
//	@AfterReturning(
//			value = "execution(* com.bit.sts06.model.DeptDao.*(..))",
//			returning = "rv"
//			)
//	public void after(JoinPoint join, Object rv) {
//		System.out.println("after dao... " + rv);
//	}



}
