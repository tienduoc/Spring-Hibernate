package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpotConfig.class);
		
		// get the bean from spring container
		Coach theCoach = context.getBean("swimCoach", SwimCoach.class);		
		
		// call method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
