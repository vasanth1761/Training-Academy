<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Prompt</title>
    <link rel="stylesheet" href="styles.css">
</head>
<style>
    body {
    font-family: Arial, sans-serif;
}

.payment-prompt {
    text-align: center;
    margin-top: 200px;
    margin-left:400px;
}

.content-box {
    background-color: #f5f5f5;
    padding: 20px;
    border-radius: 10px;
    margin-bottom: 20px;
    width:500px;
}

.ok-button, .no-button {
    background-color: #007bff;
    color: #fff;
    border: none;
    padding: 10px 20px;
    font-size: 16px;
    border-radius: 5px;
    cursor: pointer;
    text-decoration: none; /* Remove underline from anchor */
    display: inline-block; /* Ensure buttons are displayed inline */
    margin: 0 10px; /* Add spacing between buttons */
}

.ok-button:hover, .no-button:hover {
    background-color: #0056b3; /* Darken color on hover */
}

</style>
<body>

<div class="payment-prompt">
    <div class="content-box">
        <h2>Click here to pay?</h2>
        <h2>click ok</h2>
    

    <a href="payment.jsp" class="ok-button">OK</a>

    <a href="#" class="no-button">NO</a>
</div>
</div>

</body>
</html>
    