<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/login.css">
</head>
<body>
<header><h1>Welcome, Card Holder ${card.cardNumber} 
<br><h3>
${message }
</h3>

</h1> </header>
<section>
<form action="./updateBalance" method="post">
<%-- 	<input name="cId" <%=session.getAttribute("card.cId")%> > --%>
Enter Balance To be Updated : <br><input name="balance"><br><br>
<input type="submit" value="Update Balance">
</form>
</section>
<br><br>
</body>
</html>