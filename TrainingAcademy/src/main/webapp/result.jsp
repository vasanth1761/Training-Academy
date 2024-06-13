<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.academy.model.trainingTableP" %>
<html>
<head>
    <title>Result</title>
    <style>
        /* CSS for table */
        table {
            width: 50%;
            margin: auto;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        /* CSS for button */
        .certificate-button {
            background-color: blue;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            text-align: center;
            display: block;
            margin: 20px auto;
            cursor: pointer;
        }
    </style>
</head>
<body>

    <h2>Result</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Total Questions Attempted</th>
            <th>Correct Answers</th>
            <th>Percentage</th>
        </tr>
        <tr>
            <td><%= request.getAttribute("name") %></td>
            <td><%= request.getAttribute("totalCount") %></td>
            <td><%= request.getAttribute("correctCount") %></td>
            <td><%= request.getAttribute("percentage") %>%</td>
        </tr>
    </table>
    
    <form action="Percentageverification" method="post" id="certificateForm">
        <input type="hidden" name="percentage" value="<%= request.getAttribute("percentage") %>">
        <button type="submit" class="certificate-button">Generate Certificate</button>
    </form>

    
    <script>
        document.querySelector('.certificate-button').addEventListener('click', function() {
            document.getElementById('certificateForm').submit();
        });
    </script> 
</body>
</html>
    