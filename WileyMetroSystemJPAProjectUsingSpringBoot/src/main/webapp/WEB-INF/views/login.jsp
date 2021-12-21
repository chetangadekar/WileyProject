<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="spring" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="/css/login.css">
</head>
<body>
<header >
<h1>Metro Management System</h1>
<br>
<h3>${message}</h3>
</header>
<section>
<spring:form action="./loginCheck" method="post">
<br><br>Enter CardNumber : <br><spring:input type="int" path="cardNumber"/>
<br><br>
	<input type="submit" value="Login">
</spring:form>
</section>
<br><br>
<footer>
<h3>
</h3>
</footer>


</body>
</html>