<%-- 
    Document   : view
    Created on : 23 Jun 2024, 5:49:39 pm
    Author     : saifu
--%>

<%@page import="com.model.Recipe" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/cssRecipe/view.css">
    <title>Recipe - <c:out value="${selectedRecipe.title}" /></title>       
</head>
<body>
    <jsp:include page="../base/header.jsp" />
    <main>
        <article>
            <section class="recipe-title">
                <h2><c:out value="${selectedRecipe.title}" /></h2>
                <p><c:out value="${selectedRecipe.shortDescription}" /></p>
            </section>
            <section class="media">
                <img src="spaghetti-carbonara.jpg" alt="Spaghetti Carbonara">
            </section>
            <section class="recipe-details">
                <div>
                    <h3>Prep Time</h3>
                    <p><c:out value="${selectedRecipe.prepTime}" /> minutes</p>
                </div>
                <div>
                    <h3>Cook Time</h3>
                    <p><c:out value="${selectedRecipe.cookTime}" /> minutes</p>
                </div>
                <div>
                    <h3>Total Time</h3>
                    <p><c:out value="${selectedRecipe.prepTime + selectedRecipe.cookTime}" /> minutes</p>
                </div>
                <div>
                    <h3>Servings</h3>
                    <p><c:out value="${selectedRecipe.serving}" /></p>
                </div>
            </section>
            <section class="ingredients">
                <h3>Ingredients</h3>
                <ul>
                    <c:forEach var="ingredient" items="${ingredients}">
                        <li>${ingredient}</li>
                    </c:forEach>
                </ul>
            </section>
            <section class="instructions">
                <h3>Instructions</h3>
                <ol>
                    <c:forEach var="instruction" items="${instructions}">
                        <li>${instruction}</li>
                    </c:forEach>
                </ol>
            </section>
            <c:if test="${not empty selectedRecipe.chefNote}">
            <section class="notes">
                <h3>Chef's Notes</h3>
                <p><c:out value="${selectedRecipe.chefNote}" /></p>
            </section>
            </c:if>
            <section class="user-interactions">
                <h3>Comments and Ratings</h3>
                <div class="comments">
                    <h4>Comments</h4>
                    <p>No comments yet. Be the first to comment!</p>
                    <!-- Add comment form here -->
                </div>
                <div class="ratings">
                    <h4>Ratings</h4>
                    <p>★★★★★ (5/5)</p>
                    <!-- Add rating form here -->
                </div>
            </section>
        </article>
    </main>
    <jsp:include page="../base/footer.jsp" />
</body>
</html>
