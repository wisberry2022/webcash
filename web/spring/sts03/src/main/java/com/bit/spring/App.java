package com.bit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.spring.aop.CoreService;

public class App {

	public static void main(String[] args) {
		// 객체 생성 여부는 ModuleService에서 판단하였으나, 어떤 객체를 생성할 것인지의 여부는 App 모듈로 넘어오게 된다(제어 역전)
		// DI(의존성 주입)
//		ModuleService service = new ModuleService();
//		service.setModule(new Module1());
		ApplicationContext ac = null;
		ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		CoreService my = (CoreService)ac.getBean("myService");
		my.helloMsg("안녕하세요");
		my.printMsg();
		my.printName();
//		try {
//			my.printDiv();
//		} catch (Exception e) {
//			
//		}
	}
}
