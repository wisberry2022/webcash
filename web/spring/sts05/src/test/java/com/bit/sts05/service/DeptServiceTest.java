package com.bit.sts05.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.bit.sts05.model.DeptVo;

public class DeptServiceTest {
	static ApplicationContext ac = null;
	private int size;
	private static DeptService deptService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		deptService = ac.getBean(DeptService.class);
	}	

//	@Test
	public void testGetList() {		
		List<?> list = deptService.getList();
		assertNotNull(list);
		size = list.size();
		System.out.println(size);
		assertNotSame(0, size);
	}

	@Test
	public void testPushList() {
		testGetList();
		int before = size;
		DeptVo target = new DeptVo();
		deptService.pushList(target);
		System.out.println(before + " " + deptService.getList().size());
		assertSame(before+1, deptService.getList().size());
	}

//	@Test
	public void testPullList() {
		fail("Not yet implemented");
	}

//	@Test
	public void testEditList() {
		fail("Not yet implemented");
	}

//	@Test
	public void testRemoveList() {
		fail("Not yet implemented");
	}
	
//	@After
	public void tearDown() throws Exception {
	}

}
