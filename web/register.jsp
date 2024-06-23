<%-- 
    Document   : register
    Created on : 11 Jun 2024, 11:27:42 am
    Author     : Saiful
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/page/register.css">
        <title>Register</title>
    </head>
    <body>
        <jsp:include page="base/header.jsp" />
        <div class="container">
            <h1 class="display-3">Register</h1>
            <form action="UserController?action=register" method="post">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" required>
                    <img src="img/show_password_icon.png" class="toggle-password" 
                         onmousedown="showPassword()" onmouseup="hidePassword()" onmouseleave="hidePassword()" alt="Show Password">
                </div>
                <div class="form-group">
                    <label for="confirm-password">Confirm Password:</label>
                    <input type="password" id="confirm-password" name="confirm-password" class="form-control" required>
                    <img src="img/show_password_icon.png" class="toggle-password" 
                         onmousedown="showCPassword()" onmouseup="hideCPassword()" onmouseleave="hideCPassword()" alt="Show Password">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="gender">Gender:</label>
                    <select id="gender" name="gender" class="form-control" required>
                        <option value="">Select</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="other">Other</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="dob">Date of Birth:</label>
                    <input type="date" id="dob" name="dob" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary">Register</button>
            </form>
        </div>
        <% if (request.getAttribute("msg") != null && ((String) request.getAttribute("msg")).length() != 0) { %>
        <script>
            alert("<%= request.getAttribute("msg")%>");
        </script>
        <% }%>
        <script src="js/passwordToggle.js"></script>
        <jsp:include page="base/footer.jsp" />
    </body>
</html>
