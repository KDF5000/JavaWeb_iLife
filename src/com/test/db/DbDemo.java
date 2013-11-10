package com.test.db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.iLife.object.User;
import com.test.db.UserDao;

public class DbDemo {
	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����û�
//		User aUser = new User();
//		aUser.seteMail("kdf5000@163.com");
//		aUser.setUserName("kongdefei");
//		aUser.setPassword("kong19920213");
//		boolean result = UserDao.getInstance().saveUser(aUser);
//		if(result == false)
//		{
//			System.out.println("����ʧ��");
//		}
//		else
//		{
//			System.out.println("����ɹ�");
//		}
//		//��ȡ�����û���Ϣ
//		List<User> userList = UserDao.getInstance().selectAllUser();
//		for(int i=0;i<userList.size();i++)
//		{
//			User aUser = userList.get(i);
//			System.out.println("------------------");
//			System.out.println("�˻�����"+aUser.getUserName());
//			System.out.println("���룺"+aUser.getPassword());
//			System.out.println("���䣺"+aUser.geteMail());
//		}
//		//�����û���Ϣ
//		User aUser = new User();
//		aUser.seteMail("1781022885@qq.com");
//		aUser.setUserName("kongdefei");
//		aUser.setPassword("kong19920213");
//		boolean result = UserDao.getInstance().updateUserInfo(aUser);
//		if(result==true)
//		{
//			System.out.println("���³ɹ�");
//		}
//		else
//		{
//			System.out.println("����ʧ��");
//		}
//		//��ȡ�����û���Ϣ
//		List<User> userListA = UserDao.getInstance().selectAllUser();
//		for(int i=0;i<userListA.size();i++)
//		{
//			User aUser1 = userList.get(i);
//			System.out.println("------------------");
//			System.out.println("�˻�����"+aUser.getUserName());
//			System.out.println("���룺"+aUser.getPassword());
//			System.out.println("���䣺"+aUser.geteMail());
//		}
		
		//��������û���Ϣ
		List<User> users = new ArrayList<User>();
		for(int i = 0;i<10;i++)
		{
			User aUser = new User();
			aUser.setMail(i+"@163.com");
			aUser.setUserName(String.format("%d", i));
			aUser.setPassword(String.format("%d", i*100));
			users.add(aUser);
		}
		boolean result = UserDao.getInstance().saveUserBatch(users);
		if(result == true)
		{
			System.out.println("������ӳɹ�");
		}
		else
		{
			System.out.println("�������ʧ��");
		}
		//��ȡ�����û���Ϣ
		List<User> userListA = UserDao.getInstance().selectAllUser();
		for(int i=0;i<userListA.size();i++)
		{
			User aUser1 = userListA.get(i);
			System.out.println("------------------");
			System.out.println("�˻�����"+aUser1.getUserName());
			System.out.println("���룺"+aUser1.getPassword());
			System.out.println("���䣺"+aUser1.getMail());
		}
	}*/
	//����sql server 2008���ݿ�
	public static Connection getSqlServerCon()
	{
		Connection con=null;
		String Jdriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectDb="jdbc:sqlserver://localhost:1433;DatabaseName=iLifeDb";
		String userName="sa";
		String passWord="kong19920213";
		try{
			Class.forName(Jdriver);
			con= DriverManager.getConnection(connectDb, userName, passWord);// �������ݿ����
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
}
