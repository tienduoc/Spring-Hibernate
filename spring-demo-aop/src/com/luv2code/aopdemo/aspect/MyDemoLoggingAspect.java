package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//	@Before("execution(public void addAccount())")
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//	@Before("execution(public void add*())")
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		System.out.println(">> executing @Before advice on addAccount()");
	}
}
