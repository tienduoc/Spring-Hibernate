package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach") // if not declare bean id, default bean id will be tennisCoach
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
