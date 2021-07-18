package com.mvc.javabased.utility;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mvc.javabased.model.User;

@EnableWebMvc
@ComponentScan(basePackages="com.mvc.javabased")
@Configuration
public class AppConfig {

	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver irvr=new InternalResourceViewResolver();
		irvr.setSuffix(".jsp");
		return irvr;
	}
	
	@Bean
	public DriverManagerDataSource dmds() {
		DriverManagerDataSource dmds=new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/mvcjavabased");
		dmds.setUsername("root");
		dmds.setPassword("root");
		return dmds;	
	}
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean lsfb=new LocalSessionFactoryBean();
		lsfb.setDataSource(dmds());
		
		Properties p=new Properties();
		p.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		lsfb.setHibernateProperties(p);
		
		lsfb.setAnnotatedClasses(User.class);
		return lsfb;
	}
}
