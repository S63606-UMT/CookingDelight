<%-- 
    Document   : view
    Created on : 23 Jun 2024, 5:49:39 pm
    Author     : saifu
--%>

<%@page import="com.model.Recipe, com.model.Comment" %>
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
                <div id="add-comments">
                    <h4>Rate and Comment</h4>
                    <form action="recipe?action=comment" method="POST">
                        <div class="flex-container">
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" id="username" name="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="rating">Rate this recipe:</label>
                                <select id="rating" name="rating" class="form-control" required>
                                    <option value="1">★</option>
                                    <option value="2">★★</option>
                                    <option value="3">★★★</option>
                                    <option value="4">★★★★</option>
                                    <option value="5">★★★★★</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="comment-content">Comment:</label>
                            <textarea name="comment-content" id="comment-content" placeholder="Comment here!"></textarea>
                        </div>
                        <input type="hidden" id="recipeid" name="recipeid" value="<c:out value="${selectedRecipe.recipeid}" />" />
                        <button type="submit" class="btn btn-primary">Comment</button>
                    </form>
                </div>
                <c:forEach var="comment" items="${comments}">
                    <div class="comments">
                        <h4 class="named"><c:out value="${comment.username}" /></h4>
                        <p class="rated">Rating: <c:out value="${comment.rating}" />★</p><br>
                        <hr>
                        <p class="commented"><c:out value="${comment.content}" /></p>
                    </div>
                </c:forEach>
            </section>
        </article>
    </main>
    <% if (request.getAttribute("msg") != null && ((String) request.getAttribute("msg")).length() != 0) { %>
    <script>
        alert("<%= request.getAttribute("msg")%>");
    </script>
    <% }%>
    <jsp:include page="../base/footer.jsp" />
</body>
</html>
