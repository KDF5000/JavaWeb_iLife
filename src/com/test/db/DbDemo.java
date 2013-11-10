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
		//添加用户
//		User aUser = new User();
//		aUser.seteMail("kdf5000@163.com");
//		aUser.setUserName("kongdefei");
//		aUser.setPassword("kong19920213");
//		boolean result = UserDao.getInstance().saveUser(aUser);
//		if(result == false)
//		{
//			System.out.println("插入失败");
//		}
//		else
//		{
//			System.out.println("插入成功");
//		}
//		//获取所有用户信息
//		List<User> userList = UserDao.getInstance().selectAllUser();
//		for(int i=0;i<userList.size();i++)
//		{
//			User aUser = userList.get(i);
//			System.out.println("------------------");
//			System.out.println("账户名："+aUser.getUserName());
//			System.out.println("密码："+aUser.getPassword());
//			System.out.println("邮箱："+aUser.geteMail());
//		}
//		//更改用户信息
//		User aUser = new User();
//		aUser.seteMail("1781022885@qq.com");
//		aUser.setUserName("kongdefei");
//		aUser.setPassword("kong19920213");
//		boolean result = UserDao.getInstance().updateUserInfo(aUser);
//		if(result==true)
//		{
//			System.out.println("更新成功");
//		}
//		else
//		{
//			System.out.println("更新失败");
//		}
//		//获取所有用户信息
//		List<User> userListA = UserDao.getInstance().selectAllUser();
//		for(int i=0;i<userListA.size();i++)
//		{
//			User aUser1 = userList.get(i);
//			System.out.println("------------------");
//			System.out.println("账户名："+aUser.getUserName());
//			System.out.println("密码："+aUser.getPassword());
//			System.out.println("邮箱："+aUser.geteMail());
//		}
		
		//批量添加用户信息
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
			System.out.println("批量添加成功");
		}
		else
		{
			System.out.println("批量添加失败");
		}
		//获取所有用户信息
		List<User> userListA = UserDao.getInstance().selectAllUser();
		for(int i=0;i<userListA.size();i++)
		{
			User aUser1 = userListA.get(i);
			System.out.println("------------------");
			System.out.println("账户名："+aUser1.getUserName());
			System.out.println("密码："+aUser1.getPassword());
			System.out.println("邮箱："+aUser1.getMail());
		}
	}*/
	//连接sql server 2008数据库
	public static Connection getSqlServerCon()
	{
		Connection con=null;
		String Jdriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectDb="jdbc:sqlserver://localhost:1433;DatabaseName=iLifeDb";
		String userName="sa";
		String passWord="kong19920213";
		try{
			Class.forName(Jdriver);
			con= DriverManager.getConnection(connectDb, userName, passWord);// 连接数据库对象
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
}
