package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call method findAccounts()
		List<Account> theAccounts = null;
		
		try {
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(true);
		} catch (Exception e) {
			System.out.println("\nMain program ... caught exeception: " + e);
		}
		
		// display the accounts
		System.out.println("\nMain program: AfterThrowingDemoApp");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		// close the context
		context.close();
	}

}
