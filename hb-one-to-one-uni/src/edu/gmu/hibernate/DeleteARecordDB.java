package edu.gmu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.gmu.hibernate.entity.Instructor;
import edu.gmu.hibernate.entity.InstructorDetail;

public class DeleteARecordDB {

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
			// start transaction.
			session.beginTransaction();
			
			// get an instructor by primary key / id
			int id = 2;
			
			// the following will return null if not found.
			Instructor aInstructor = session.get(Instructor.class, id);
			System.out.println("Found instructor: " + aInstructor);
			
			// delete the instructor.
			if (aInstructor != null) {
				
				System.out.println("Deleting: " + aInstructor);
				
				/* note: this will ALSO delete associated "details" object
				 * due to CascadeType.ALL
				 */
				session.delete(aInstructor);
			}
		
			// commit the transaction.
			session.getTransaction().commit();
			System.out.println("Done!");
		} 
		finally {
			factory.close();
		}
	}
}
