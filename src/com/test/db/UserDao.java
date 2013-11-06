/*
 * ���ܣ��û����ݿ������
 * ���ߣ��׵·�
 * ʱ�䣺2013.10.25
 */
package com.test.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.db.DbDemo;
import com.iLife.object.User;

public class UserDao {
	private static UserDao aUser=null;
	//��ȡһ���û�ʵ��
	public static UserDao getInstance()
	{
		if(aUser==null)
		{
			aUser=new UserDao();
		}
		return aUser;
	}
	//�����ݿ������һ���û�
	public boolean saveUser(User aUser)
	{
		boolean result=false;
		Connection con=null;
		try{
			con = DbDemo.getSqlServerCon();
			String sql = "INSERT INTO userT(userName,password,eMail) VALUES(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, aUser.getUserName());  //���õ�һ������
			stmt.setString(2, aUser.getPassword());  //���õڶ�������
			stmt.setString(3, aUser.getMail());     //���õ���������
			int returnCode = stmt.executeUpdate();   //ִ��sql���
			if(returnCode == 1)  //1����ɹ�����һ��
			{
				result = true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(SQLException sqlE)
			{
				sqlE.printStackTrace();
			}
		}
		return result;
	}
	//�����û��Ƿ����
	public boolean checkUserName(String userName)
	{
		Connection con=null;
		try{
			con = DbDemo.getSqlServerCon();
			String sql = "SELECT * FROM userT WHERE userName='"+userName+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
		return false;
	}
	//��ѯ�����û�
	public  List<User> selectAllUser()
	{
		List<User> userList = new ArrayList<User>();
		Connection con = null;
		try{
			con = DbDemo.getSqlServerCon();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM userT");
			while(res.next())
			{
				User aUser = new User();
				aUser.setUserName(res.getString("userName"));
				aUser.setPassword(res.getString("password"));
				aUser.setMail(res.getNString("eMail"));
				userList.add(aUser);	
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(SQLException sqlE)
			{
				sqlE.printStackTrace();
			}
		}
		return userList;
	}
	//�޸��û��������������
	public boolean updateUserInfo(User aUser)
	{
		boolean result=false;
		Connection con=null;
		try{
			con=DbDemo.getSqlServerCon();
			String sql = "UPDATE userT SET password=? ,eMail=? WHERE userName=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, aUser.getPassword());
			stmt.setString(2, aUser.getMail());
			stmt.setString(3,aUser.getUserName());
			int returnCode = stmt.executeUpdate();
			if(returnCode==1)
			{
				result = true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				con.close();
			}catch(SQLException sqlE)
			{
				sqlE.printStackTrace();
			}
			
		}
		return result;
	}
	//��������û�
		public boolean saveUserBatch(List<User> users)
		{
			boolean result=false;
			Connection con = null;
			try{
				con = DbDemo.getSqlServerCon();
				String sql = "INSERT INTO userT(userName,password,eMail) VALUES(?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				for(int i=0;i < users.size();i++)
				{
					User aUser = users.get(i);
					stmt.setString(1, aUser.getUserName());
					stmt.setString(2, aUser.getPassword());
					stmt.setString(3,aUser.getMail());
					stmt.addBatch();
				}
				int []rows = stmt.executeBatch();
				int rowLength = rows.length;
				if(rowLength==users.size())
				{
					result = true;
				}
			}catch(Exception ee)
			{
				ee.printStackTrace();
			}
			finally{
				try{
					con.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
				
			}
			return result;
		}
}
