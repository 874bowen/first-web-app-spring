<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
System.out.println("this is Ivan coding at 12am");
java.util.Date date = new java.util.Date();
%>
<body>

My First JSP!!
<h2>Hello ${name}, your password is ${password}, the date <%=date%></h2>
<form action="/login.do" method="post">
Enter name <input type="text" name="name"/><input type="submit" value="login"/>
</form>
</body>
</html>