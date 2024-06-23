<%-- 
    Document   : index
    Created on : 11 Jun 2024, 7:38:31 am
    Author     : Saiful
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/page/index.css">
        <title>Homepage - Cooking Delight</title>
    </head>
    <body>
        <jsp:include page="base/header.jsp" />
        <section class="hero">
            <h1>Welcome to Cooking Delight</h1>
            <p>Discover delicious recipes and cooking tips</p>
            <a href="recipe.html">Browse Recipes</a>
        </section>
        <section class="content">
            <h2>Featured Recipes</h2>
            <div class="recipes">
                <div class="recipe">
                    <h3>Spaghetti Carbonara</h3>
                    <p>A classic Italian pasta dish.</p>
                    <a href="#">Read More</a>
                </div>
                <div class="recipe">
                    <h3>Chicken Curry</h3>
                    <p>A flavorful and spicy chicken curry.</p>
                    <a href="#">Read More</a>
                </div>
                <div class="recipe">
                    <h3>Chocolate Cake</h3>
                    <p>A rich and moist chocolate cake.</p>
                    <a href="#">Read More</a>
                </div>
            </div>
            <h2>Recipe Categories</h2>
            <div class="categories">
                <div class="category">
                    <h3>Appetizers</h3>
                    <p>Quick and easy appetizers to start your meal.</p>
                </div>
                <div class="category">
                    <h3>Main Courses</h3>
                    <p>Hearty and satisfying main dishes.</p>
                </div>
                <div class="category">
                    <h3>Desserts</h3>
                    <p>Delicious and sweet dessert recipes.</p>
                </div>
            </div>
        </section>
        <% if (request.getAttribute("msg") != null) { %>
        <script>
            alert("<%= request.getAttribute("msg") %>");
        </script>
        <% } %>
        <jsp:include page="base/footer.jsp" />
    </body>
</html>

