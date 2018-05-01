package com.luv2code.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	// variable to hold the properties
	@Autowired
	private Environment env;
	
	// logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// define a bean for ViewResolve
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// define a bean for security datasource
	@Bean
	public DataSource securityDataSource() {
		
		// create connection pool
		ComboPooledDataSource sercurityDataSource = new ComboPooledDataSource();
		
		// set jdbl driver class
		try {
			sercurityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		// log the connection props
		logger.info(">>> jdbc.url = " + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user = " + env.getProperty("jdbc.user"));
		
		// set database connection props
		sercurityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		sercurityDataSource.setUser(env.getProperty("jdbc.user"));
		sercurityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		sercurityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		sercurityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		sercurityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		sercurityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return sercurityDataSource;
	}
	
	// read environment property and convert to int
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}
}
