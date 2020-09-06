package com.nick.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nick.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			//			session.beginTransaction();
			//			
			//			Student std = session.get(Student.class, 1);
			//			
			//			session.delete(std);
			//			
			//			session.getTransaction().commit();

			session = factory.getCurrentSession();

			session.beginTransaction();

			session.createQuery("Delete Student where id=2").executeUpdate();

			session.getTransaction().commit();;



		} finally {
			factory.close();
		}
	}

}
