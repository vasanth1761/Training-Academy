<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Payment Page</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    padding: 20px;
  }
  
  h2 {
    text-align: center;
    color: #333;
  }
  
  form {
    max-width: 400px;
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  
  label {
    font-weight: bold;
    color: #333;
  }
  
  input[type="text"],
  select {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
  }
  
  input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin-top: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 100%;
    font-size: 16px;
  }
  
  input[type="submit"]:hover {
    background-color: #45a049;
  }
</style>
</head>
<body>

<h2>Payment</h2>

<form action="/process_payment" method="post">
  <label for="card_type">Select Card Type:</label>
  <select id="card_type" name="card_type">
    <option value="credit">Credit Card</option>
    <option value="debit">Debit Card</option>
  </select>
  
  <label for="card_number">Card Number:</label>
  <input type="text" id="card_number" name="card_number" required>
  
  <label for="expiry_date">Expiry Date:</label>
  <input type="text" id="expiry_date" name="expiry_date" placeholder="MM/YY" required>
  
  <label for="cvv">CVV:</label>
  <input type="text" id="cvv" name="cvv" required>
  
  <input type="submit" value="Pay">
</form>

</body>
</html>
    