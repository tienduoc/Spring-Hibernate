package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// UPDATE FIRST NAME
			int studentId = 1;
			// start a transaction
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			myStudent.setFirstName("Duoc2");
			System.out.println(">> Updating student...");

			// commit transaction
			session.getTransaction().commit();

//			-----------------------------------------------------------------------------------
			
			// UPDATE EMAIL
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println(">> Update email for all students");
			session.createQuery("update Student set email='ahihi@gmail.com'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			// close factory
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
