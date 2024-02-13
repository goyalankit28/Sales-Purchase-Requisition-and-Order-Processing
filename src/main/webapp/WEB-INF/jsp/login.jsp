<%-- 
    Document   : login
    Created on : Apr 3, 2023, 10:01:36 PM
    Author     : ankitgoyal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f2f2f2;
		}
		form {
			background-color: #ffffff;
			padding: 20px;
			border-radius: 5px;
			box-shadow: 0px 0px 10px #c0c0c0;
			margin: auto;
			max-width: 400px;
			margin-top: 50px;
		}
		input[type=text], input[type=password] {
			padding: 10px;
			border-radius: 5px;
			border: none;
			background-color: #f2f2f2;
			margin-bottom: 20px;
			width: 100%;
		}
		input[type=submit] {
			background-color: #4CAF50;
			color: white;
			padding: 10px;
			border: none;
			border-radius: 5px;
			cursor: pointer;
			width: 100%;
		}
		input[type=submit]:hover {
			background-color: #3e8e41;
		}
		h2 {
			text-align: center;
			margin-top: 0;
		}
	</style>
</head>
<body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h2>Login</h2>
	<form:form method="post" modelAttribute="user">
		<label for="username">Username:</label>
		<form:input path="username" id="username" type="text" required="required" autofocus="autofocus" />
		<label for="password">Password:</label>
		<form:password path="password" id="password" required="required" />
		<input type="submit" value="Login" />
	</form:form>
                <p style="text-align: center">Not registered yet? <a href="${contextPath}/register.htm">Register here</a>.</p>
</body>
</html>
