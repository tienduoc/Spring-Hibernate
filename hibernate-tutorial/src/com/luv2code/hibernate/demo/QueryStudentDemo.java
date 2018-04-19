package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// QUERYING OBJECTS FROM DB
			// start a transaction
			session.beginTransaction();

			// query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			// display student
			displayStudents(theStudents);

			// query student firstName = 'Duoc'
			System.out.println("\n>> Student who have firstName of Duoc");
			theStudents = session.createQuery("from Student where firstName = 'Duoc'").getResultList();
			// display student
			displayStudents(theStudents);

			// query student firstName = 'Duoc' OR lastName = 'Dinh Cong'
			System.out.println("\n>> Student who have firstName = 'Duoc' OR lastName = 'Dinh Cong'");
			theStudents = session.createQuery("from Student where firstName = 'Duoc' or lastName = 'Dinh Cong'")
					.getResultList();
			// display student
			displayStudents(theStudents);

			// query student where email like '%lele@gmail%'
			System.out.println("\n>> Student who have email like '%lele%'");
			theStudents = session.createQuery("from Student s where s.email LIKE '%lele%'")
					.getResultList();
			// display student
			displayStudents(theStudents);

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
