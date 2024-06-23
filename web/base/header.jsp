<%-- 
    Document   : header
    Created on : 11 Jun 2024, 8:14:03 am
    Author     : Saiful
--%>
        <header>
            <h1>Cooking Delight</h1>
        </header>
        <nav class="nav">
            <ul class="nav-links">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="recipe.jsp">Recipes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about.jsp">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.jsp">Contact</a>
                </li>
            </ul>
            <ul class="nav-links nav-right">           
                <%
                    if (session.getAttribute("authenticatedUser") != null) {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="recipe?action=list">Recipe</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="profile?action=view">Profile</a>
                </li>
                <%} else { %>
                <li class="nav-item">
                    <a class="nav-link" href="register.jsp">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
                <% } %>
            </ul>
        </nav>