<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome vasanth</title>
<link rel="stylesheet" href="styles.css">
</head>
<style>
    body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

.sidebar {
    height: 100%;
    width: 250px;
    position: fixed;
    top: 0;
    left: 0;
    background-color: #0056b3; /* Coursera blue */
    padding-top: 20px;
    transition: width 0.3s; /* Add smooth transition */
}

.sidebar h2 {
    color: #fff;
    text-align: center;
}

.sidebar ul {
    list-style-type: none;
    padding: 0;
}

.sidebar ul li {
    padding: 10px;
}

.sidebar ul li a {
    display: block;
    color: #fff;
    text-decoration: none;
    padding: 10px;
    transition: 0.3s;
}

.sidebar ul li a:hover {
    background-color: #007bff; /* Darker shade of blue on hover */
}

.content {
    margin-left: 250px;
    padding: 20px;
}

.content h2 {
    color: #333;
}

</style>
<body>

<div class="sidebar">
    <h2>Welcome Vasanth</h2>
    <ul>
        <li><a href="">Home</a></li>
        <li><a href="insertquestion.jsp">Add Question</a></li>
        <li><a href="#add-video">Add Video</a></li>
        <li><a href="#learner-list">List of Learners</a></li>
        <li><a href="#payment-details">Payment Details</a></li>
    </ul>
</div>



</body>
</html>
