package com.nick.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nick.hibernate.demo.entity.Student;

public class PrimayKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Student std = new Student("Siv", "Chid", "siv@mail.com");
			session.save(std);
			std = new Student("John", "Doe", "john@mail.com");
			session.save(std);
			std = new Student("Barrack", "Obama", "obama@mail.com");
			session.save(std);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
