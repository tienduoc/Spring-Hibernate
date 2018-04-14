package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoationDemoApp {

	public static void main(String[] args) {
		
		// read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		TennisCoach theCoach = context.getBean("thatSillyCoach", TennisCoach.class);		
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		context.close();
	}

}
