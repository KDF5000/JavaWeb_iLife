package com.hibernate.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static SessionFactory sessionFactory = null;  ///sessionFactory����
	static{
		try{
			Configuration cfg = new Configuration().configure();
			ServiceRegistry  serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();     
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			//sessionFactory = cfg.buildSessionFactory();
		}catch(Exception e)
		{
			System.err.println("����session����ʧ��");
			e.printStackTrace();
		}
	}//���ڴ���sessionFaction��ķѴ�����Դ������static����һ��
	/*
	 * ��ȡȥsession
	 */
	public static Session getSession() throws HibernateException
	{
		Session session = (Session)threadLocal.get();
		if(session == null || !session.isOpen())
		{
			if(sessionFactory==null)
			{
				rebuildSessionFactory();
			}
			session = (sessionFactory!=null)?sessionFactory.openSession():null;
	        threadLocal.set(session);
		}
		return session;
	}
	/*
	 * �ؽ��ػ�����
	 */
	public static void rebuildSessionFactory()
	{
		try{
			Configuration cfg = new Configuration().configure();
			//sessionFactory = cfg.buildSessionFactory();
			//ServiceRegistryBuilder serviceRegistry = new ServiceRegistryBuilder();
			ServiceRegistry  serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();     
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		}catch(Exception e)
		{
			System.err.println("����session����ʧ��");
			e.printStackTrace();
		}
	}
	/*
	 * ��ȡ�ػ�����
	 */
	public static SessionFactory getSessionFacory()
	{
		return sessionFactory;
	}
	/*
	 * �ر�session
	 */
	public static void closeSession() throws HibernateException
	{
		Session session = (Session)threadLocal.get();
		threadLocal.set(null);
		if(session!=null)
		{
			session.close();
		}
	}
}
