package edu.gmu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.gmu.hibernate.entity.Instructor;
import edu.gmu.hibernate.entity.InstructorDetail;

public class CreateDB {

	public static void main(String[] args) {

		// create session factory.
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			/* use the session object to save Java object*/
			// create an instructor and its detail object.
			/*
			Instructor aInstructor = new Instructor("David", "Ji", "david@gmu.edu");
			InstructorDetail aInstructorDetail = new InstructorDetail("http://www.gmu.edu/youtube", "Full stack web developer!");
			*/
			Instructor aInstructor = new Instructor("Abraham", "Lee", "abraham@gmu.edu");
			InstructorDetail aInstructorDetail = new InstructorDetail("http://www.google.com/youtube", "Back-end web developer!");
			
			// associate objects in memory.
			aInstructor.setInstructorDetail(aInstructorDetail);
			
			// start transaction.
			session.beginTransaction();
			
			/* save the instructor object.
			 * 
			 * note: this will also save the detail object due to CascadeType.ALL,
			 * which cascades persist, remove, refresh, detach, and merge.
			 */
			System.out.println("Saving the instructor: " + aInstructor);
			session.save(aInstructor);
			
			// commit the transaction.
			session.getTransaction().commit();
			System.out.println("Done!");
		} 
		finally {
			factory.close();
		}
	}
}
