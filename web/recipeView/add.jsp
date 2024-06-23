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
        <link rel="stylesheet" type="text/css" href="css/cssRecipe/add.css">
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="../base/header.jsp" />
        <div class="container">
            <h1 class="display-3">New Recipe</h1>
            <form action="recipe?action=insert" method="POST">
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" id="title" name="title" placeholder="Max. 50 characters" class="form-control">
                </div>
                <div class="form-group">
                    <label for="short-description">Short Description:</label>
                    <input type="text" id="short-description" name="short-description" placeholder="Max. 100 characters" lass="form-control">
                </div>
                <div class="form-group small-input">
                    <div class="flex-group">
                        <label for="prep-time">Prep time:</label>
                        <input type="text" id="prep-time" name="prep-time" placeholder="Min." class="form-control">
                    </div>
                    <div class="flex-group">
                        <label for="cook-time">Cook time:</label>
                        <input type="text" id="cook-time" name="cook-time" placeholder="Min." class="form-control">
                    </div>
                    <div class="flex-group">
                        <label for="serving">Serving:</label>
                    <input type="text" id="serving" name="serving" placeholder="e.g. 4" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="ingredients">Ingredients:</label>
                    <textarea name="ingredients" placeholder="Separate ingredients with a comma `,`."></textarea>
                </div>
                <div class="form-group">
                    <label for="instructions">Ingredients:</label>
                    <textarea name="instructions" placeholder="Separate instructions with a new line `Enter`."></textarea>
                </div>
                <div class="form-group">
                    <label for="chef-note">Chef Note:</label>
                    <input type="text" id="short-description" name="short-description" placeholder="Optional" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Add Recipe</button>
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

