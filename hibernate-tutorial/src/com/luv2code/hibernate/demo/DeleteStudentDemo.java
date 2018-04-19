package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// DELETE Student BY Id
			int studentId = 7;
			// start a transaction
			session.beginTransaction();
			
//			Student myStudent = session.get(Student.class, studentId);
//			session.delete(myStudent);
//			System.out.println(">> Deleting student: " + myStudent);
			
			// delete student id = 8
			session.createQuery("delete from Student s where s.id = 8").executeUpdate();
			System.out.println(">> Deleting student..." );

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
