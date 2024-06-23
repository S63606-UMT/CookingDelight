<%-- 
    Document   : recipeSearch
    Created on : 23 Jun 2024, 2:30:00 pm
    Author     : saifu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/cssRecipe/recipeSearch.css">
        <title>Recipes - Cooking Delight</title>
        <style>
        </style>
    </head>
    <body>
        <jsp:include page="../base/header.jsp" />
        <main>
            <section class="search-bar">
                <input type="text" placeholder="Search for recipes...">
                <button>Search</button>
            </section>
            <section class="recipe-list">
                <article class="recipe-item">
                    <img src="recipe1.jpg" alt="Recipe 1">
                    <h3>Spaghetti Carbonara</h3>
                    <p>A classic Italian pasta dish made with eggs, cheese, pancetta, and pepper.</p>
                    <a href="recipe1.html"><button>View Recipe</button></a>
                </article>
                <article class="recipe-item">
                    <img src="recipe2.jpg" alt="Recipe 2">
                    <h3>Chicken Alfredo</h3>
                    <p>Creamy Alfredo sauce with tender chicken over fettuccine pasta.</p>
                    <a href="recipe2.html"><button>View Recipe</button></a>
                </article>
                <article class="recipe-item">
                    <img src="recipe3.jpg" alt="Recipe 3">
                    <h3>Vegetable Stir-fry</h3>
                    <p>A colorful mix of vegetables stir-fried in a savory sauce.</p>
                    <a href="recipe3.html"><button>View Recipe</button></a>
                </article>
                <c:forEach var="recipe" items="${RecipeList}">
                    <article class="recipe-item">
                        <img src="recipe3.jpg" alt="Recipe 3">
                        <h3><c:out value="${recipe.title}" /></h3>
                        <p><c:out value="${recipe.shortDescription}" /></p>
                        <a href="recipe?action=view&recipeid=<c:out value="${recipe.recipeid}" />"><button>View Recipe</button></a>
                    </article>
                </c:forEach>
                <!-- Add more recipe items here -->
            </section>
        </main>
        <% if (request.getAttribute("msg") != null) {%>
        <script>
            alert("<%= request.getAttribute("msg")%>");
        </script>
        <% }%>
        <jsp:include page="../base/footer.jsp" />
    </body>
</html>
