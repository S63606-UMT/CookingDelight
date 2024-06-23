<%-- 
    Document   : profile
    Created on : 11 Jun 2024, 3:13:13 pm
    Author     : Saiful
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.model.User, java.time.LocalDate" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/cssProfile/profile.css">
        <title>Profile - Cooking Delight</title>
    </head>
    <body>
        <jsp:include page="../base/header.jsp" />
        <%
            User user = (User) session.getAttribute("authenticatedUser");
        %>
        <div class="container">
            <div class="profile-container">
                <div class="profile-picture">
                    <h2>Profile Picture</h2>
                    <% if (user.getPicturePath() != null) { %>
                    <img src="<%= user.getPicturePath() %>" alt="Profile Picture" class="profile-pic">
                    <% } else { %>
                    <img src="img/default_pfp.png" alt="Profile Picture" class="profile-pic">
                    <% } %>
                    <form action="profile?action=updatePicture" method="post" enctype="multipart/form-data">
                        <input type="file" name="file"/>
                        <button class="edit-image-btn">Edit Image</button>
                    </form>
                    <div class="profile-options">
                        <h2>User Options</h2>
                        <a href="profile?action=logout"><button class="user-btn">Logout</button></a>
                        <a href="editPFP.jsp"><button class="user-btn">Get Verified</button></a>
                        <a href="profile?action=delete"><button class="delete-user-btn">Delete Account</button></a>
                    </div>
                </div>
                <div class="profile-info">
                    <h2>Profile Info</h2>
                    <form action="profile?action=editUsername" method="post">
                        <p>Username: <input type="text" name="username" value="<%= user.getUsername() %>" /></p>
                        <button class="edit-btn">Edit Username</button>
                    </form>
                    <form action="profile?action=editPassword" method="post">
                        <p>Password: <%= session.getAttribute("maskedPassword") %></p>
                        <button class="edit-btn">Change Password</button>
                    </form>
                    <form action="profile?action=editEmail" method="post">
                        <p>Email: <input type="email" name="email" value="<%= user.getEmail() %>" /></p>
                        <button class="edit-btn">Edit Email</button>
                    </form>
                    <form action="profile?action=editDob" method="post">
                        <p>Date of Birth: <input type="date" name="dob" value="<%= user.getDateOfBirth() %>" /></p>
                        <button class="edit-btn">Edit Date of Birth</button>
                    </form>
                    <form action="profile?action=editGender" method="post">
                        <p>Gender: <select name="gender">
                            <option value="<%= user.getGender() %>"><%= user.getGender() %></option>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="other">Other</option>
                        </select></p>
                        <button class="edit-btn">Edit Gender</button>
                    </form>
                    <form action="profile?action=editDesc" method="post">
                        <% if (user.getDescription() != null && user.getDescription().length() != 0) { %>
                        <p>Description: <textarea name="description"><%= user.getDescription() %></textarea></p>
                        <% } else { %>
                        <p>Description: <textarea name="description" placeholder="Describe yourself."></textarea></p>
                        <% } %>
                        <button class="edit-btn">Save Description</button>
                    </form>
                </div>
            </div>
        </div>
        <% if (request.getAttribute("msg") != null && ((String) request.getAttribute("msg")).length() != 0) { %>
        <script>
            alert("<%= request.getAttribute("msg")%>");
        </script>
        <% }%>
        <jsp:include page="../base/footer.jsp" />
    </body>
</html>