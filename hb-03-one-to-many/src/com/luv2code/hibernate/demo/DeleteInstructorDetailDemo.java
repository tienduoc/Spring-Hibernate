package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theId = 2;
			InstructorDetail tempInstructrDetail = session.get(InstructorDetail.class, theId);
			
			// remove the associated object reference - break bi-directional link
			tempInstructrDetail.getInstructor().setInstructorDetail(null);
			
			// delete the instructor detail
			if (tempInstructrDetail != null) {
				System.out.println("Deleting: " + tempInstructrDetail);
				session.delete(tempInstructrDetail);
			}
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

}
