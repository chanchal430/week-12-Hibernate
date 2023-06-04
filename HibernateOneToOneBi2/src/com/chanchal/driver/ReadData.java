package com.chanchal.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chanchal.entity.Address;
import com.chanchal.entity.Student;

public class ReadData {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
						.addAnnotatedClass(Address.class).buildSessionFactory();

				// create session
				Session session = factory.getCurrentSession();
				
				try {
					//start the transaction
					session.beginTransaction();
					
					//get the address object
					int tempAddressId = 1;
					Address tempAddress = session.get(Address.class, tempAddressId);
					
					//Print the result
					System.out.println("Address details : "+ tempAddress);
					
					//Print the associated student value
					System.out.println("Associated student : "+ tempAddress.getStudent());
					
					//commit transaction
					session.getTransaction().commit();
				}catch(Exception exc){
					exc.printStackTrace();
				}finally {
					factory.close();
				}
	}

}
