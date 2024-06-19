<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.academy.model.Questions" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE>
<html>
<head>
    <title>Questions</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .question {
            margin-bottom: 20px;
        }
        .question p {
            margin: 0;
        }
        .submit-btn {
            display: block;
            width: 150px; 
            padding: 10px 0;
            margin: 20px auto 0; 
            background-color: #0056b3; 
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
    </style>
</head>

<body>
 <center><h1>Take Quiz</h1></center>
    <div class="container">
        <form action="CheckResult" method="post">
            <%
            List<Questions> questions = (List<Questions>) request.getAttribute("testop");
                                       int i=1;
                                       for(Questions obj:questions) {
            %>
            <div class="question">
                
                <p><strong><%=i++ %></strong> .<%= obj.getQuestion() %></p>
                <input type="hidden" name="questionId" value="<%= obj.getId() %>">
                <p><input type="radio" name="answer<%= obj.getId() %>" value="A"> <%= obj.getOptionA() %></p>
                <p><input type="radio" name="answer<%= obj.getId() %>" value="B"> <%= obj.getOptionB() %></p>
                <p><input type="radio" name="answer<%= obj.getId() %>" value="C"> <%= obj.getOptionC() %></p>
                <p><input type="radio" name="answer<%= obj.getId() %>" value="D"> <%= obj.getOptionD() %></p>
            </div>
            <% } %>
            <input type="submit" value="Submit" class="submit-btn">
        </form>
    </div>
</body>
</html>