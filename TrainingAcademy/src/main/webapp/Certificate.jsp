<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.academy.model.TrainingTable"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Certificate</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
        }
        body {
            color: black;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: Georgia, serif;
            font-size: 24px;
            text-align: center;
            background-color: #f4f4f4;
        }
        .container {
            border: 20px solid blue;
            width: 750px;
            height: 563px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        .logo {
            color:blue;
            font-size: 28px;
            margin-top: 20px;
        }
        .marquee {
            color: tan;
            font-size: 48px;
            margin: 20px;
        }
        .assignment {
            margin: 20px;
        }
        .person {
            border-bottom: 2px solid black;
            font-size: 32px;
            font-style: italic;
            margin: 20px auto;
            width: 400px;
        }
        .reason {
            margin: 20px;
        }
        .download-btn-container {
            margin-top: 20px;
        }
        .button-container {
            margin-top: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<%String course=(String)session.getAttribute("course");
TrainingTable obj1 = (TrainingTable) session.getAttribute("userid");

%>
<body>
    <div class="container">
        <div class="logo">
            <strong>SYSTECH</strong>
        </div>

        <div class="marquee">
            Certificate of Completion
        </div>

        <div class="assignment">
            This certificate is presented to
        </div>

        <div class="person">
            <%=obj1.getName() %>
        </div>

        <div class="reason">
            <%=course %> course Succesfully Completed <br/>
            
        </div>
    </div>

    <div class="button-container">
        <div class="download-btn-container">
            <button id="downloadBtn">Download Certificate</button>
        </div>

            <button id="nextBtn">Next</button>
        </div> -->
    </div>

    <script>
        document.getElementById('downloadBtn').addEventListener('click', function() {
          
            var htmlContent = document.documentElement.outerHTML;

          
            var blob = new Blob([htmlContent], { type: 'text/html' });

         
            var a = document.createElement('a');
            a.href = URL.createObjectURL(blob);
            a.download = 'certificate.html';
            document.body.appendChild(a);
            a.click();
            document.body.removeChild(a);
        });

        document.getElementById('nextBtn').addEventListener('click', function() {
            alert('Next button clicked. Replace with your navigation logic.');
        });
    </script>
</body>
</html>
    