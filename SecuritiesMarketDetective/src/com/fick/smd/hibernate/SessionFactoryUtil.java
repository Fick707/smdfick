package com.fick.smd.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionFactoryUtil {
	private static Log log = LogFactory.getLog(SessionFactoryUtil.class);

	private static Configuration configuration = null;

	private static SessionFactory sessionFactory = null;

	public static ThreadLocalSessionContext hibernateSessions = null;

	static {
		configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(sr);
		hibernateSessions = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
	}

	public static Session getCurrentSession() {
		Session session = hibernateSessions.currentSession();

		/*
		if ((session.getTransaction() == null) || !session.getTransaction().isActive()) {
			log.debug("启动数据库事务...");
			session.beginTransaction();
		}
		*/
		return session;
	}

}
