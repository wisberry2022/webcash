package com.bit.spring.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class DeptDaoTest {

	static ApplicationContext ac;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
	}

	private DeptDao deptDao;
	private DeptVo target;
	
	@Before
	public void setUp() throws Exception {
		deptDao = (DeptDao)ac.getBean("deptDao");
		target = new DeptVo(50, "쿠콘", "부산");
	}
	
	//@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = (DataSource)ac.getBean("dataSource");
		Connection conn = dataSource.getConnection();
		assertNotNull(conn);
	}
	
	//@Test
	public void testJdbcTemplate() {
		JdbcTemplate jdbcTemplate = (JdbcTemplate)ac.getBean("jdbcTemplate");
		assertNotNull(jdbcTemplate);
	}
	
	//@Test
	public void testFindAll() {
		List<DeptVo> list = deptDao.findAll();
		assertNotNull(list);
	}
	
	//@Test
	public void testFindOne() {
		DeptVo bean = deptDao.findOne(target.getDeptno());
		assertEquals(target, bean);
	}
	
	//@Test
	public void testInsertOne() {
		target = new DeptVo(91, "test91", "test");
		deptDao.insertOne(target);	
		assertFalse(false);
	}
	
	//@Test
	public void testUpdateOne() {
		target.setDname("테스트");
		assertSame(1, deptDao.updateOne(target));
	}
	
	
	@Test
	public void testDeleteOne() {
		assertSame(1, deptDao.deleteOne(target.getDeptno()));
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
}
