package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentMaryDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			// get the student from db
			int theId = 3;
			Student tempStudent = session.get(Student.class, theId);
			System.out.println(">> Student loaded: " + tempStudent);
			System.out.println(">> Course: " + tempStudent.getCourses());
			
			// delete student
			System.out.println("Deleting student...");
			session.delete(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println(">> Done");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
