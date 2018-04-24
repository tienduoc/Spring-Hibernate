package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			// create a course
			Course tempCourse = new Course("Spring & Hibernate for beginners");
			
			
			// save the course
			System.out.println(">> Saving the course...");
			session.save(tempCourse);
			System.out.println(">> Saved the course!");

			// create student
			Student tempStudent1 = new Student("Duoc", "Dam Tien", "tienduoc@gmail.com");
			Student tempStudent2 = new Student("Thong", "Cao Minh", "minhthong@yahoo.com");
			Student tempStudent3 = new Student("Thang", "Nguyen Van", "vanthang@outlook.com");
			
			// add student to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			tempCourse.addStudent(tempStudent3);
			
			// save students
			System.out.println("Saving students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			System.out.println("Students saved: " + tempCourse.getStudents());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println(">> Done");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
