<%-- 
    Document   : add
    Created on : 23 Jun 2024, 3:54:36 pm
    Author     : saifu
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
        <jsp:include page="../base/header.jsp" />
        <div class="container">
            <h1 class="display-3">New Recipe</h1>
            <form action="recipe?action=insert" method="POST">
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" id="title" name="title" class="form-control">
                </div>
                <div class="form-group">
                    <label for="short-description">Short Description:</label>
                    <input type="text" id="short-description" name="short-description" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
        <% if (request.getAttribute("msg") != null && ((String) request.getAttribute("msg")).length() != 0) { %>
        <script>
            alert("<%= request.getAttribute("msg")%>");
        </script>
        <% }%>
        <jsp:include page="../base/footer.jsp" />
    </body>
</html>

