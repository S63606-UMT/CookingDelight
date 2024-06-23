<%-- 
    Document   : changePassword
    Created on : 16 Jun 2024, 9:06:52 pm
    Author     : saifu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/page/login.css"> <!-- Reusing this CSS since the page is simular in style. No need to create a new CSS.-->
        <title>Change Password</title>
    </head>
    <body>
        <jsp:include page="../base/header.jsp" />
        <div class="container">
            <h1 class="display-3">Change Password</h1>
            <form action="profile?action=updatePassword" method="POST">
                <div class="form-group">
                    <label for="old-password">Old password:</label>
                    <input type="password" id="old-password" name="old-password" class="form-control">
                    <img src="img/show_password_icon.png" class="toggle-password" 
                         onmousedown="showOldPassword()" onmouseup="hideOldPassword()" onmouseleave="hideOldPassword()" alt="Show Password">
                </div>
                <div class="form-group">
                    <label for="new-password">New password:</label>
                    <input type="password" id="new-password" name="new-password" class="form-control">
                    <img src="img/show_password_icon.png" class="toggle-password" 
                         onmousedown="showNewPassword()" onmouseup="hideNewPassword()" onmouseleave="hideNewPassword()" alt="Show Password">
                </div>
                <div class="form-group">
                    <label for="confirm-password">Confirm New password:</label>
                    <input type="password" id="confirm-password" name="confirm-password" class="form-control">
                    <img src="img/show_password_icon.png" class="toggle-password" 
                         onmousedown="showCPassword()" onmouseup="hideCPassword()" onmouseleave="hideCPassword()" alt="Show Password">
                </div>
                <button type="submit" class="btn btn-primary">Change Password</button>
            </form>
        </div>
        <% if (request.getAttribute("msg") != null && ((String) request.getAttribute("msg")).length() != 0) { %>
        <script>
            alert("<%= request.getAttribute("msg")%>");
        </script>
        <% }%>
        <script src="js/passwordToggle.js"></script>
        <jsp:include page="../base/footer.jsp" />
    </body>
</html>
