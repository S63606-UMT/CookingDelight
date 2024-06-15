<%-- 
    Document   : login
    Created on : 11 Jun 2024, 10:40:06 am
    Author     : Saiful
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/page/login.css">
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="base/header.jsp" />
        <div class="container">
            <!-- Login form content here -->
            <h1 class="display-3">Login</h1>
            <form action="profile?action=login" method="POST">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" class="form-control">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
        <jsp:include page="base/footer.jsp" />
    </body>
</html>
