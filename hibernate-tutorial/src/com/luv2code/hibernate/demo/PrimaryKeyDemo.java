package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// create 3 students object
			System.out.println("Creating 3 students object...");
			Student tempStudent1 = new Student("Man", "Nguyen Thi", "manman@gmail.com");
			Student tempStudent2 = new Student("Le", "Ho Thi", "lele@gmail.com");
			Student tempStudent3 = new Student("Tao", "Dinh Cong", "taotao@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Student has been saved!!!");

		} finally {
			// close factory
			factory.close();
		}
	}
}
