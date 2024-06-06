<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Four Cards in a Column</title>
<link rel="stylesheet" href="styles.css">
</head>
<style>
    body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f4f4f4;
}

.container {
    display: flex;
  justify-content: center;
  align-items: center;
  min-height: 400px;
}

.box {
  padding: 40px;
  height: 300px;

}

.card {
  width: 200px; /* Adjust as needed */
  height:200px;
  padding: 20px;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  text-align: center;
  margin-bottom: 20px; /* Spacing between cards */
}

</style>
<body>
<form action="courseDetails" method="get">
<div class="container">
  <div class="box">
    <div class="card">
    <input type="hidden" name="action" value="Java">
    <button type="submit">Enroll</button>
    </div>
  </div>
  </form>
  <form action="courseDetails" method="get">
  <div class="box">
    <div class="card">
    <input type="hidden" name="action" value="Html">
    <button type="submit">Enroll</button>
    </div>
  </div>
  </form>
  <form action="courseDetails" method="get">
  <div class="box">
    <div class="card">
    <input type="hidden" name="action" value="css">
    <button type="submit">Enroll</button>
    </div>
  </div>
  </form>
  <form action="courseDetails" method="get">
  <div class="box">
    <div class="card">
    <input type="hidden" name="action" value="angular">
    <button type="submit">Enroll</button>
    </div>
  </div>
  </form>
</div>


</body>
</html>