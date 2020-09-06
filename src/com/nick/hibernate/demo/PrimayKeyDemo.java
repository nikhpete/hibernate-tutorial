package com.nick.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nick.hibernate.demo.entity.Student;
import com.nick.hibernate.demo.utils.DateUtils;

public class PrimayKeyDemo {

	public static void main(String[] args) throws ParseException {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Student std = new Student("Siv", "Chid", "siv@mail.com", DateUtils.parseDate("20/06/1995"));
			session.save(std);
			std = new Student("John", "Doe", "john@mail.com", DateUtils.parseDate("12/09/1905"));
			session.save(std);
			std = new Student("Barrack", "Obama", "obama@mail.com", DateUtils.parseDate("15/03/1969"));
			session.save(std);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
