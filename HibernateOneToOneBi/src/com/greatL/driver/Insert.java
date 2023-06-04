package com.greatL.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatL.entity.Teacher;
import com.greatL.entity.TeacherDetails;


public class Insert {

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
				//create the object
				Teacher tempTeacher = new Teacher("Joe", "Jack", "Joe@gl.com");
				
				TeacherDetails tempTeacherDetails = new TeacherDetails("Chicago", "painting");
				
				//Associate the object
				tempTeacher.setTeacherDetails(tempTeacherDetails);
				
				//create the object
				Teacher tempTeacher1 = new Teacher("Harshit", "Chaudhary", "HARSHIT@gl.com");
				
				TeacherDetails tempTeacherDetails1= new TeacherDetails("Gurgaon", "Reading");
				
				//Associate the object
				tempTeacher.setTeacherDetails(tempTeacherDetails1);
				
				//start transaction
				session.beginTransaction();
				
				//save the teacher
				session.save(tempTeacher);
				session.save(tempTeacherDetails);
				//save the teacher
				session.save(tempTeacher1);
				session.save(tempTeacherDetails1);
				
				//commit transaction
				session.getTransaction().commit();
				}finally {
					factory.close();
				}
	}

}
