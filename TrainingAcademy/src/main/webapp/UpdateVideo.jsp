<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ViewVideos" method="post">

       <input type="text"name="Title"placeholder="videoTitle"><br>
        <input type="text" name="Video"placeholder="video"><br>
        <input type="hidden" name="action" value="update">
		<input type="hidden" name="updateid" value="<%=request.getParameter("updateid")%>">		
		<button type="submit" title="update">Update</button>
        </form>
       
</body>
</body>
</html>