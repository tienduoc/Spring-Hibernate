package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Spring & Hibernate for beginners");
			
			// add some reviews
			tempCourse.addReview(new Review("Great course, I love it"));
			tempCourse.addReview(new Review("Awsome, this course very easy to understand"));
			tempCourse.addReview(new Review("Great conntent and sound clearly!"));
			
			// save the course ... and leverage the cascading all
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
