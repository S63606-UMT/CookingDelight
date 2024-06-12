<%-- 
    Document   : recipe
    Created on : 11 Jun 2024, 9:07:48 am
    Author     : Saiful
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/page/recipe.css">
        <title>Recipes - Cooking Delight</title>
    </head>
    <body>
        <jsp:include page="base/header.jsp" />
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
                    <a href="recipe1.html">View Recipe</a>
                </article>
                <article class="recipe-item">
                    <img src="recipe2.jpg" alt="Recipe 2">
                    <h3>Chicken Alfredo</h3>
                    <p>Creamy Alfredo sauce with tender chicken over fettuccine pasta.</p>
                    <a href="recipe2.html">View Recipe</a>
                </article>
                <article class="recipe-item">
                    <img src="recipe3.jpg" alt="Recipe 3">
                    <h3>Vegetable Stir-fry</h3>
                    <p>A colorful mix of vegetables stir-fried in a savory sauce.</p>
                    <a href="recipe3.html">View Recipe</a>
                </article>
                <!-- Add more recipe items here -->
            </section>
        </main>
        <jsp:include page="base/footer.jsp" />
    </body>
</html>
