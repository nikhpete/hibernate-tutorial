package com.nick.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nick.hibernate.demo.entity.Student;
import com.nick.hibernate.demo.utils.DateUtils;

public class ReadStudentDemo {

	public static void main(String[] args) throws ParseException {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			Student std = new Student("Donald", "Duck", "dd@mail.com", DateUtils.parseDate("13/02/1984"));
			
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
