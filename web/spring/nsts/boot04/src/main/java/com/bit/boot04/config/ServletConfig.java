package com.bit.boot04.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@MapperScan(basePackageClasses = com.bit.boot04.model.DeptMapper.class)
@MapperScan(basePackages = "com.bit.boot04.model.DeptMapper")
public class ServletConfig implements WebMvcConfigurer {
	
	@Bean
	public SqlSession getSqlSession(SqlSessionFactory sqlSessionFactory) {	
		return sqlSessionFactory.openSession();
	}
	
}
