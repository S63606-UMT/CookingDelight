<%-- 
    Document   : header
    Created on : 11 Jun 2024, 8:14:03 am
    Author     : Saiful
--%>
        <header>
            <h1>Cooking Delight</h1>
        </header>
        <nav class="nav">
            <%  
                /*
                With the uses of subdirectories for sorting reasons, the purpose of this peace of code
                is to dynamically edit the navigation bar's links.
                */
                String servletPath = request.getServletPath();
                String currentDirectory = servletPath.substring(0, servletPath.lastIndexOf("/"));
                String[] parts = currentDirectory.split("/");
                int numSlashes = parts.length - 1;
                String up = "";
                if (numSlashes > 0) {
                    up = up + "../".repeat(numSlashes);
                }
            %>   
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