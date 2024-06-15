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
        <script src="../js/jsProfile/profile.js"></script>
        <title>Profile - Cooking Delight</title>
    </head>
    <body>
        <jsp:include page="../base/header.jsp" />
        <%
            User user = (User) session.getAttribute("authenticatedUser");
        %>
        <%=request.getServletPath()%>
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
                    <h2>Profile Info</h2>
                    <p>Username: <input type="text" id="username" value="<%= user.getUsername() %>" /></p>
                    <a href="#" onclick="editUsername()"><button class="edit-btn">Edit Username</button></a>
                    <p>Password: <b>********</b></p>
                    <a href="../index.jsp"><button class="edit-btn">Change Password</button></a>
                    <p>Email: <input type="email" id="email" value="<%= user.getEmail() %>" /></p>
                    <a href="#" onclick="editEmail()"><button class="edit-btn">Edit Email</button></a>
                    <p>Date of Birth: <input type="date" id="dob" value="<%= user.getDateOfBirth() %>" /></p>
                    <a href="#" onclick="editDob()"><button class="edit-btn">Edit Date of Birth</button></a>
                    <p>Gender: <select id="gender">
                        <option value="<%= user.getGender() %>"><%= user.getGender() %></option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="other">Other</option>
                    </select></p>
                    <a href="#" onclick="editGender()"><button class="edit-btn">Edit Gender</button></a>
                    <%-- TODO: Add markdown support and utility --%>
                    <p>Description: <textarea id="description">${description}</textarea></p> 
                    <a href="#"><button class="edit-btn">Save Description</button></a>
                </div>
            </div>
        </div>
        <jsp:include page="../base/footer.jsp" />
    </body>
</html>