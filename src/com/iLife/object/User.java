package com.iLife.object;

public class User {

	private String userName;  //�û���
	private String password;  //�û�����
	private String mail;     //�û�����
	
	//hibernate�涨Ҫ��Ϊ�־û������ʵ��һ��Ĭ�ϵĹ��췽��
	public User()
	{
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}
