<%@page import="com.model.service.SwipeInServiceImpl"%>
<%@page import="com.model.service.SwipeInService"%>
<%@page import="com.bean.CardDetails"%>
<%@page import="com.bean.Transaction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Swipe In</title>
<link rel="stylesheet" href="/css/login.css">
</head>
<body>
<header>
<h1>Welcome, Card Holder ${card.cardNumber} </h1>      
</header>

<section><a href="./swipeInPage">SwipeIn</a><br><br>
<a href="./checkBalancePage">Check Balance</a><br><br>
<a href="./updateBalancePage">Update Balance</a><br><br>
<a href="./logOut">Log Out</a>
</section>
</body>
</html>