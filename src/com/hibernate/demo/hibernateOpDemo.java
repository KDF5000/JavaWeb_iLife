package com.hibernate.demo;

import com.iLife.object.User;
import org.hibernate.Session;
public class hibernateOpDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;
		User aUser = new User();
		aUser.setUserName("HibernateKDF");
		aUser.setPassword("kong123456");
		aUser.setMail("hibernate@123.com");
		
		//Hibernate�ĳ־û�����
		try{
			session = HibernateUtil.getSession();  //��ȡsession
			session.beginTransaction();//��ʼ����
			session.save(aUser); //ִ����Ӳ���
			session.getTransaction().commit();//�ύ����
		}catch(Exception e)
		{
			session.getTransaction().rollback();//�ع�
			System.out.println("������ݿ�ʧ��");
			e.printStackTrace();
		}
		finally{
			//HibernateUtil.closeSession();//close session 
		}
	}

}
