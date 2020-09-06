package com.nick.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nick.hibernate.demo.entity.Student;
import com.nick.hibernate.demo.utils.DateUtils;

public class CreateStudentDemo {

	public static void main(String[] args) throws ParseException {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			Student std = new Student("Nick", "Peter", "abc@mail.com", DateUtils.parseDate("18/04/1994"));
			
			session.save(std);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
