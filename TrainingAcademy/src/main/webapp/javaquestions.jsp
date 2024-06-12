<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="com.academy.model.questionsP"%>


 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title> 
</head>
<style>
table{ 
border-collapse:collapse;
width:70%; 
background-color:white;
 margin-top:100px;
 margin-left:100px;
 }

td{ border:2px solid#ddd; 
padding:10px;
 margin-top:500px;
 }
 

.formm
{
  background-color:green;
  padding:800px;
}
</style>

<body>
	<center>
		<h1>
			<b> Questions</b>
		</h1>
	</center>
	<!-- <form action="userDetails" method="get">
	<input type="hidden" name="action" value="search">
	<input type="search" name="Search" placeholder="search">
	<button type="search">search</button> 
	</form> -->
			<%-- <input type="hidden" name="delete" value=<%=obj.getId() %>> --%>
			<!-- <button type="submit" title="search"><a href="search.jsp">search</a></button> -->
	<table >
		<tr class="formm">
		    <th>Qno</th>
		    <th>Question</th>
            <th>Option A</th>
            <th>Option B</th>
            <th>Option C</th>
            <th>Option D</th>
            <th>Delete</th>
			

		</tr>
		<%
		/* userImpl u=new userImpl();
 */		List<questionsP> questions = (List<questionsP>) request.getAttribute("questions");
	
	int i=1;
	for (questionsP question : questions) {
		%>
		<tr>
		    <td><%=i++%></td>
		    <td><%= question.getQuestion() %></td>
            <td><%= question.getOptionA() %></td>
            <td><%= question.getOptionB() %></td>
            <td><%= question.getOptionC() %></td>
            <td><%= question.getOptionD() %></td>
		    
		    <form action="Crud" method="get">
			<td>
			 <input type="hidden" name="action" value="Delete">
			<input type="hidden" name="delete" value=<%=question.getId() %>>
			<button type="submit" title="delete">Delete</button>
			</td>
			</form>
		    
		
			
			<%
			}
			%>
		</tr>
	</table>
	<form action="sessionLogout" method= "get">
	<button  type="submit"  title="Logout">Logout</button>
	</form>
	
</body>
</html>
 