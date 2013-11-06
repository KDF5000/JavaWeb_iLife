<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
<form id="registerForm" method="post" action="register.jsp">
	<label for="name">姓名:</label>
	<input type="text" name="name" id="userName" />
	<br/>
	<label for="password">密 码:</label>
	<input type="password" name="password" id="password" />
	<br/>
	<label for="name">邮箱:</label>
	<input type="text" name="eMail" id="eMail" />
	<br/>
	<input type="submit" value="注册" />
	<input type="button" value="关闭"  onclick="window.close()"/>
	<br/>
</form>
</body>
</html>