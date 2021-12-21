<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<link rel="stylesheet" href="/css/login.css">
</head>
<body>
<header><h2>Dear, Traveller For Travelling  with us You Need to Subscribe ,<br> Please Press Below Button If You want To Subscribe<br><br></h2></header>
<section>
<spring:form action="./generateId" method="post">
<input type="Submit" value="Subscribe">
</spring:form>
</section>
</body>
</html>