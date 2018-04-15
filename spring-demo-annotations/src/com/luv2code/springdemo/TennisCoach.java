package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // if not declare bean id, default bean id will be tennisCoach
public class TennisCoach implements Coach {

	@Autowired
//	@Qualifier("happyFortuneService")
	@Qualifier("randomService")
	private FortuneService fortuneService;

	// default constructor
	public TennisCoach() {
		System.out.println(">> TenisCoach: Inside default constructor");
	}
	
	// define init-method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TenisCoach: inside of doMyStartupStuff");
	}
	
	// define destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TenisCoach: inside of doMyCleanupStuff");
	}
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		super();
//		this.fortuneService = fortuneService;
//	}
	
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">> TenisCoach: Inside setFortuneService() method");
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
