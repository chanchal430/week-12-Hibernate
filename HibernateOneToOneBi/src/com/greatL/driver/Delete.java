package com.greatL.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatL.entity.Teacher;
import com.greatL.entity.TeacherDetails;

public class Delete {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory = new Configuration()
				          .configure("hibernate.cfg.xml")
				          .addAnnotatedClass(Teacher.class)
				          .addAnnotatedClass(TeacherDetails.class)
				          .buildSessionFactory();
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			int theId = 2;
			
			//start transaction
			session.beginTransaction();
			
			TeacherDetails teacherDetails = session.get(TeacherDetails.class, theId);
			
			if(teacherDetails != null) {
				System.out.println("Deleting :- "+ teacherDetails);
				
				
				//Note : it will also delete teacher data with it as we have provided cascadeType.ALL
				session.delete(teacherDetails);
			}
			
			//coommit transaction
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
