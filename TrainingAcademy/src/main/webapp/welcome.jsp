<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.academy.model.trainingTableP" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>welcome</h1>
<%

 trainingTableP table=(trainingTableP)session.getAttribute("userid"); 

%>
<input type="text" value=<%=table.getName()
%>>



</center>
</body>
</html>