<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List"%>
<%@page import="com.academy.model.videoP"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Videos</title>
    <style>
        .module {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        iframe {
            width: 80%; /* Reduced width */
            display: block; /* Center the video horizontally */
            margin: 0 auto; /* Center the video horizontally */
            height: auto; /* Maintain aspect ratio */
        }

        .take-test-button {
            display: inline-block;
            padding: 8px 16px;
            background-color: #2A73CC; /* Coursera blue */
            color: white;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-size: 14px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<form action="Test"method="post">
    <div class="module">
        <h1>Videos</h1>
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Video</th>
                </tr>
            </thead>
            <tbody>
                <!-- Retrieve video data using JSP scriptlet -->
                <% 
                    List<videoP> videos = (List<videoP>) request.getAttribute("opvideo"); // Retrieve video data from your service object
                    for (videoP video : videos) { // Iterate over the list of videos
                %>
                    <tr>
                        <td><%= video.getTitle() %></td>
                        <td><iframe src="<%=video.getLink()%>" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <button class="take-test-button">Take Test</button>
    </div>
    </form>
</body>
</html>
