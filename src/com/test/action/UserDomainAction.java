package com.test.action;

import com.iLife.object.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.test.db.UserDao;

public class UserDomainAction extends ActionSupport implements ModelDriven{
	private User aUser=new User();

	public User getaUser() {
		return aUser;
	}
	public void setaUser(User aUser) {
		this.aUser = aUser;
	}
	public String saveUser()
	{
		boolean nameCheckRes = UserDao.getInstance().checkUserName(aUser.getUserName());
		if(nameCheckRes==false)
		{
			boolean res= UserDao.getInstance().saveUser(aUser);
			if(res)
			{
				return SUCCESS;
			}
			else
			{
				return ERROR;
			}
		}
		else
		{
			return "exist";
		}
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return this.aUser;
		//test
	}
}
