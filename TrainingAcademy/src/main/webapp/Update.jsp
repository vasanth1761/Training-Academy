<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ViewQuestions" method="post">
<%-- <input type="hidden" name="id" value="<%= request.getParameter("id") %>"> --%>
       <input type="text"name="Question"placeholder="Question"><br>
        <input type="text" name="OptionA"placeholder="optionA"><br>
        <input type="text"name="OptionB"placeholder="optionB"><br>
        <input type="text"name="OptionC"placeholder="optionC"><br>
        <input type="text"name="OptionD"placeholder="optionD"><br>
        <input type="text"name="CorrectAnswer"placeholder="CorrectAnswer"><br>
        
        <input type="hidden" name="action" value="update">
		<input type="hidden" name="updateid" value="<%=request.getParameter("updateid")%>">		
		<button type="submit" title="update">Update</button>
        </form>
       
</body>
</body>
</html>