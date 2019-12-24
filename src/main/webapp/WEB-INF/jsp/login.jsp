<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
</head>
<body>
    <form:form modelAttribute="user" action="/verify/login" method="post"><%--View/AllUsers--%>
        <table>
            <tr>
                <th>用户名：</th>
                <td><form:input path="username" /><form:errors path="username" cssStyle="color:red" required="required" /></td>
            </tr>
            <tr>
                <th>密码：</th>
                <td><form:password path="password"/><form:errors path="password" cssStyle="color:red" required="required" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交" /></td>
            </tr>
            <tr>
                <td colspan="2"><span path="login" cssStyle="color:red" >${result}</span></td>
            </tr>
        </table>
    </form:form>
</body>
</html>