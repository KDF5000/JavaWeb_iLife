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
		
		//Hibernate的持久化操作
		try{
			session = HibernateUtil.getSession();  //获取session
			session.beginTransaction();//开始事物
			session.save(aUser); //执行添加操作
			session.getTransaction().commit();//提交事物
		}catch(Exception e)
		{
			session.getTransaction().rollback();//回滚
			System.out.println("添加数据库失败");
			e.printStackTrace();
		}
		finally{
			//HibernateUtil.closeSession();//close session 
		}
	}

}
