package com.greatL.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatL.entity.Teacher;
import com.greatL.entity.TeacherDetails;

public class Read {

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
			//start transaction
			session.beginTransaction();
			
			//get the Teacher Detail object
			int theId = 2;
			TeacherDetails teacherDetails  = session.get(TeacherDetails .class, theId);
			
			//Print the teacher detail
			System.out.println("Teacher Details : "+teacherDetails);
			
			//Print the associated Teacher value
			System.out.println("Associated teacher : "+teacherDetails.getTeacher());
			
			//commit transaction
			session.getTransaction().commit();
			
		}catch(Exception exc){
		
			exc.printStackTrace();
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
