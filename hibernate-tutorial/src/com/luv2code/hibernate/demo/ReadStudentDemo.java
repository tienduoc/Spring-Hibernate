package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// CREATE OBJECT AND SAVE TO DB
			// create student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Xoai", "Trinh Thanh", "tienduoc@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Student has been saved. Generated id: " + tempStudent.getId());

//			-----------------------------------------------------------------------------------
			
			// READ OBJECT FROM DB
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\n>> Getting student with id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("\n>> Student infomation: " + myStudent);

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			// close factory
			factory.close();
		}
	}

}
