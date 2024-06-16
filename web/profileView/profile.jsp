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
                    <img src="img/default_pfp.png" alt="Profile Picture" class="profile-pic">
                    <a href="editPFP.jsp"><button class="edit-image-btn">Edit Image</button></a>
                    <div class="profile-options">
                        <h2>User Options</h2>
                        <a href="profile?action=logout"><button class="user-btn">Logout</button></a>
                        <a href="editPFP.jsp"><button class="user-btn">Get Verified</button></a>
                        <a href="profile?action=delete"><button class="delete-user-btn">Delete Account</button></a>
                    </div>
                </div>
                <div class="profile-info">
                    <form action="profile?action=editUsername" method="post">
                        <p>Username: <input type="text" name="username" value="<%= user.getUsername() %>" /></p>
                        <button class="edit-btn">Edit Username</button>
                    </form>
                    <form action="profile?action=editPassword" method="post">
                        <p>Password: <input type="password" name="password" value="" /></p>
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
                        <p>Description: <textarea name="description">${description}</textarea></p>
                        <button class="edit-btn">Save Description</button>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../base/footer.jsp" />
    </body>
</html>