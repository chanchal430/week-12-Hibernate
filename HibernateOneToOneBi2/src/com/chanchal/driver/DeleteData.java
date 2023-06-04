package com.chanchal.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chanchal.entity.Address;
import com.chanchal.entity.Student;

public class DeleteData {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
						.addAnnotatedClass(Address.class).buildSessionFactory();

				// create session
				Session session = factory.getCurrentSession();
				
				try {
					
					int theAddressId = 2;
					
					//Start transaction
					session.beginTransaction();
					
					Address tempAddress = session.get(Address.class, theAddressId );
					
					if(tempAddress != null) {
						System.out.println("Deleting :-  "+ tempAddress);
						
						//Note!! : it will also delete student data 
					    //         as we have provided CascadeType.ALL
						session.delete(tempAddress);
					}
					
					//commit transaction
					session.getTransaction().commit();
				}finally {
					factory.close();
				}

	}

}
