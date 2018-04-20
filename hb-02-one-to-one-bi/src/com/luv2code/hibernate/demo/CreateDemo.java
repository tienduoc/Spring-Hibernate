package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

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
			
			// create the objects
//			Instructor tempInstructor = new Instructor("Duoc", "Dam Tien", "tienduoc@gmail.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("T2D Channel", "Coding");
			
			Instructor tempInstructor = new Instructor("A", "Nguyen Van", "aaa@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("AAA Channel", "Gaming");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor -> this will ALSO save the details object because of CascadeType.ALL
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			// close factory
			factory.close();
		}
	}

}
