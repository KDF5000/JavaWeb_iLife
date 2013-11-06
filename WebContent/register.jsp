<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.test.db.UserDao,com.iLife.object.User" %>
<% 
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String eMail = request.getParameter("eMail");
	boolean nameCheckRes = UserDao.getInstance().checkUserName(name);
	if(nameCheckRes==false)
	{
		User aUser = new User();
		aUser.setUserName(name);
		aUser.setPassword(password);
		aUser.seteMail(eMail);
		boolean res= UserDao.getInstance().saveUser(aUser);
		if(res)
		{
			request.getRequestDispatcher("OK.jsp").forward(request , response);
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
	}
	else
	{
		response.sendRedirect("error.jsp");
	}
%>