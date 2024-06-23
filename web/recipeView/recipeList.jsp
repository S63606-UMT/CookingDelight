<%-- 
    Document   : recipeList
    Created on : 23 Jun 2024, 2:59:00 pm
    Author     : saifu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/cssRecipe/recipeList.css">
        <title>Recipes - Cooking Delight</title>
        <style>
        </style>
    </head>
    <body>
        <jsp:include page="../base/header.jsp" />
        <div class="row">

            <div class="container">
                <h2>List of Your Recipes</h2>
                <hr>
                <a href="recipe?action=add"><button>Add New Recipe</button></a>
                <br>
                <table>
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="recipe" items="${listEmployee}">
                        <tr>
                            <td>
                        <c:out value="${recipe.title}" />
                        </td>
                        <td>
                        <c:out value="${recipe.shortDescription}" />
                        </td>
                        <td>
                            <a href="recipe?action=edit />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="recipe?action=delete />">Delete</a>
                        </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <% if (request.getAttribute("msg") != null) {%>
        <script>
            alert("<%= request.getAttribute("msg")%>");
        </script>
        <% }%>
        <jsp:include page="../base/footer.jsp" />
    </body>
</html>

