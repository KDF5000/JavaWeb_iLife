<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.iLife.object.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保存用户信息</title>
</head>
<body>
<s:form id="registerForm" method="post" action="saveUser!saveUser" >
	<!-- <label for="name">姓名:</label>
	<input type="text" name="aUser.userName" id="userName" />
	<br/>
	<label for="password">密 码:</label>
	<input type="password" name="aUser.password" id="password" />
	<br/>
	<label for="name">邮箱:</label>
	<input type="text" name="aUser.eMail" id="eMail" />
	<br/>
	<input type="submit" value="注册" />
	<input type="button" value="关闭"  onclick="window.close()"/>
	<br/> -->
	<s:textfield name="userName" label="用户名"></s:textfield>
	<s:textfield name="password" label="密码"></s:textfield>
	<s:textfield name="mail" label="邮箱"></s:textfield>
	<s:submit value="注册"></s:submit>
</s:form>
</body>
</html>