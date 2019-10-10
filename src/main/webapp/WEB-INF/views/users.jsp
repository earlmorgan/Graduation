<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
	<table>
		<tr><td>用户名</td><td>密码</td></tr>
		<c:forEach var="user" items="${users }">
			<tr><td>${user.name }</td><td>${user.password }</td></tr>
		</c:forEach>
	</table>
</body>
</html>