package com.nick.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nick.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			List<Student> stdList = session.createQuery("from Student").getResultList();

			displayStudents(stdList);

			stdList = session.createQuery("from Student s where s.lastName='Duck'").getResultList();

			System.out.println("\nLast Name as Duck:");
			displayStudents(stdList);

			stdList = session.createQuery("from Student s where s.lastName='Duck' OR firstName='John'").getResultList();

			System.out.println("\nLast Name as Duck and first name as John:");
			displayStudents(stdList);

			stdList = session.createQuery("from Student s where s.email LIKE '%a@mail%'").getResultList();

			System.out.println("\nStudents having a@mail in their email");
			displayStudents(stdList);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> stdList) {
		for(Student std:stdList) {
			System.out.println(std);
		}
	}

}
