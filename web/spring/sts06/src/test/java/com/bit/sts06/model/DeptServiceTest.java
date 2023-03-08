package com.bit.sts06.model;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.bit.sts06.service.DeptService;

public class DeptServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectAll() {
		ApplicationContext ac;
		ac = new GenericXmlApplicationContext("file:E:\\java\\spring\\sts06\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");
		DeptService deptService = ac.getBean(DeptService.class);
		// 컴포넌트 스캐닝이 진행되지 않아 null값이 뜬다
		assertNotNull(deptService.selectAll());
	
	}

}
