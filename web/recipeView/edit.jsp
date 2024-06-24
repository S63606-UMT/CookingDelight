<%-- 
    Document   : edit
    Created on : 23 Jun 2024, 10:49:03 pm
    Author     : saifu
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/cssRecipe/add.css">
        <title>Edit Recipe</title>
    </head>
    <body>
        <jsp:include page="../base/header.jsp" />
        <div class="container">
            <h1 class="display-3">Edit Recipe</h1>
            <form action="recipe?action=update" method="POST">
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" id="title" name="title" placeholder="Max. 50 characters" value="<c:out value="${selectedRecipe.title}" />" class="form-control">
                </div>
                <div class="form-group">
                    <label for="short-description">Short Description:</label>
                    <input type="text" id="short-description" name="short-description" placeholder="Max. 100 characters" 
                           value="<c:out value="${selectedRecipe.shortDescription}" />" class="form-control">
                </div>
                <div class="form-group small-input">
                    <div class="flex-group">
                        <label for="prep-time">Prep time:</label>
                        <input type="text" id="prep-time" name="prep-time" placeholder="Min." value="<c:out value="${selectedRecipe.prepTime}" />" class="form-control">
                    </div>
                    <div class="flex-group">
                        <label for="cook-time">Cook time:</label>
                        <input type="text" id="cook-time" name="cook-time" placeholder="Min." value="<c:out value="${selectedRecipe.cookTime}" />" class="form-control">
                    </div>
                    <div class="flex-group">
                        <label for="serving">Serving:</label>
                    <input type="text" id="serving" name="serving" placeholder="e.g. 4" value="<c:out value="${selectedRecipe.serving}" />" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="ingredients">Ingredients:</label>
                    <textarea name="ingredients" id="ingredients" placeholder="Separate ingredients with a comma `,`."><c:out value="${selectedRecipe.ingredients}" /></textarea>
                </div>
                <div class="form-group">
                    <label for="instructions">Ingredients:</label>
                    <textarea name="instructions" id="instructions" placeholder="Separate instructions with a new line `Enter`."><c:out value="${selectedRecipe.instructions}" /></textarea>
                </div>
                <div class="form-group">
                    <label for="chef-note">Chef Note:</label>
                    <input type="text" id="chef-note" name="chef-note" placeholder="Optional" 
                           value="<c:out value="${selectedRecipe.chefNote}" />" class="form-control">
                </div>
                <input type="hidden" id="recipeid" name="recipeid" value="<c:out value="${selectedRecipe.recipeid}" />" />
                <button type="submit" class="btn btn-primary">Edit Recipe</button>
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
