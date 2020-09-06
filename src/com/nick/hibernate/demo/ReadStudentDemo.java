package com.nick.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nick.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			Student std = new Student("Donald", "Duck", "dd@mail.com");
			
			session.save(std);
			
			session.getTransaction().commit();
			
			System.out.println("The primary key: "+ std.getId());
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student myStd = session.get(Student.class, std.getId());
			
			System.out.println("Student retrieved: "+ myStd);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
