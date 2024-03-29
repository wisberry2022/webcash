package com.bit.sts07.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bit.sts07.model.entity.DeptVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class DeptServiceTest {

	@Autowired
	DeptService deptService;
	
	//@Test
	public void testSelectAll() {
		assertNotNull(deptService.selectAll());
		assertNotSame(0, deptService.selectAll().size());
	}

//	@Test
	public void testSelectOne() {
		assertNotNull(deptService.selectOne(10));		
	}

	// test에서의 transactional은 auto-rollback이다
	@Transactional
	@Test
	public void testInsertOne() {
		DeptVo target = new DeptVo(50, "테스팅", "테스트");
		deptService.insertOne(target);
	}
}
