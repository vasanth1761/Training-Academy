<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmation</title>
    <script>
        function confirmRedirect() {
            var confirmation = confirm("<%= request.getAttribute("confirmMessage") %>");
            if (confirmation) {
                window.location.href = "questionoutput.jsp";
            } else {
                // Handle if user cancels the confirmation
                window.location.href = "someOtherPage.jsp"; // Redirect to another page or do nothing
            }
        }
    </script>
</head>
<body onload="confirmRedirect()">
</body>
</html>
