<%-- 
    Document   : profile
    Created on : 11 Jun 2024, 3:13:13 pm
    Author     : Saiful
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <link rel="stylesheet" type="text/css" href="../css/cssProfile/profile.css">
        <title>Profile - Cooking Delight</title>
    </head>
    <body>
        <jsp:include page="../base/header.jsp" />
        <div class="container">
            <div class="profile-container">
                <div class="profile-picture">
                    <h2>Profile Picture</h2>
                    <img src="../img/default_pfp.png" alt="Profile Picture" class="profile-pic">
                    <a href="editPFP.jsp"><button class="edit-image-btn">Edit Image</button></a>
                </div>
                <div class="profile-info">
                    <h2>Profile Info</h2>
                    <p>Username: <input type="text" value="${username}" /></p>
                    <a href="../index.jsp"><button class="edit-btn">Edit Username</button></a>
                    <p>Password: <b>********</b></p>
                    <a href="../index.jsp"><button class="edit-btn">Change Password</button></a>
                    <p>Email: <input type="email" value="${email}" /></p>
                    <a href="#"><button class="edit-btn">Edit Email</button></a>
                    <p>Gender: <select>
                        <option value="${gender}">${gender}</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="other">Other</option>
                    </select></p>
                    <a href="../index.jsp"><button class="edit-btn">Edit Gender</button></a>
                    <p>Date of Birth: <input type="date" value="${dob}" /></p>
                    <a href="../index.jsp"><button class="edit-btn">Edit Date of Birth</button></a>
                    <p>Description: <textarea>${description}</textarea></p>
                    <a href="../index.jsp"><button class="edit-btn">Save Description</button></a>
                </div>
            </div>
        </div>
        <jsp:include page="../base/footer.jsp" />
    </body>
</html>