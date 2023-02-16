package com.bit.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.Test;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class DeptDaoTest {

	@Test
	public void testSelectAll() throws SQLException, ClassNotFoundException, NamingException {
		DeptDao dao = new DeptDao();
		Class.forName(Driver.class.getCanonicalName());
		
		// tomcat에서 돌아가는 것이 아니기 때문에 db 정보를 직접 주입해야한다
		String url = "jdbc:mysql://localhost:3306/lecture";
		String user = System.getenv("MYSQL_USER");
		String password = System.getenv("MYSQL_PW");
		MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
		ds.setUrl(url);
		ds.setUser(user);
		ds.setPassword(password);
		int timeout = ds.getConnectTimeout();
		int cnt = ds.getMaxRows();
		System.out.println(timeout + "\t" + cnt);
		
		dao.conn = DriverManager.getConnection(url, user, password);
		
		List<DeptDto> list = dao.selectAll();

		assertNotNull(list);
		assertTrue(list.size()>0);
		
	}

}
