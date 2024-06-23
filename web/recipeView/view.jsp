<%-- 
    Document   : view
    Created on : 23 Jun 2024, 5:49:39 pm
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
    <link rel="stylesheet" type="text/css" href="css/cssRecipe/view.css">
    <title>Recipe - Spaghetti Carbonara</title>       
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
                    <p>15 minutes</p>
                </div>
                <div>
                    <h3>Cook Time</h3>
                    <p>20 minutes</p>
                </div>
                <div>
                    <h3>Total Time</h3>
                    <p>35 minutes</p>
                </div>
                <div>
                    <h3>Servings</h3>
                    <p>4</p>
                </div>
            </section>
            <section class="ingredients">
                <h3>Ingredients</h3>
                <ul>
                    <li>200g spaghetti</li>
                    <li>100g pancetta</li>
                    <li>2 large eggs</li>
                    <li>50g Pecorino cheese</li>
                    <li>50g Parmesan</li>
                    <li>2 cloves garlic, peeled and left whole</li>
                    <li>50g unsalted butter</li>
                    <li>Salt and freshly ground black pepper</li>
                </ul>
            </section>
            <section class="instructions">
                <h3>Instructions</h3>
                <ol>
                    <li>Put a large saucepan of water on to boil.</li>
                    <li>Finely chop the pancetta, having first removed any rind.</li>
                    <li>Beat the eggs in a medium bowl, season with a little freshly grated black pepper and set aside.</li>
                    <li>Grate the Pecorino cheese and mix with the Parmesan.</li>
                    <li>Add 1 tsp salt to the boiling water, add the spaghetti and cook according to the pack instructions.</li>
                    <li>Squash the garlic with the blade of a knife, just to bruise it.</li>
                    <li>Melt the butter in a deep frying pan, add the garlic and pancetta, and cook for about 5 minutes until the pancetta is golden and crisp.</li>
                    <li>Keep the heat under the pancetta on low. When the pasta is ready, lift it from the water with a pasta fork or tongs and put it in the frying pan with the pancetta.</li>
                    <li>Take the pan of spaghetti and pancetta off the heat. Quickly pour in the eggs and cheese. Lift up the spaghetti so it mixes easily with the egg mixture, which thickens but doesn't scramble, and everything is coated.</li>
                    <li>Adjust the seasoning with salt and pepper, and serve immediately with a little sprinkling of the remaining cheese and a grating of black pepper.</li>
                </ol>
            </section>
            <section class="notes">
                <h3>Chef's Notes</h3>
                <p>For a more authentic Italian experience, use guanciale instead of pancetta. Serve with a simple green salad and a glass of white wine.</p>
            </section>
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
