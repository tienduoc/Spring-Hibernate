package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService {

	// create an array of string
	private String[] data = {
			"An income tax form is like a laundry list - either way you lose your shirt.",
			"I never wanted to be on any billionaires list. I never define myself by net worth. I always try to define myself by my values.",
			"Go forth under the open sky, and list To Nature's teachings.",
			"In all planing you make a list and you set priorities."
	};
	
	// create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// pick random string from the array
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
	}

}
