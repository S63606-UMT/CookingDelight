<%--
Document : success
Created on : 15 Jun 2024, 10:31:23 pm
Author : saifu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html> 
<html lang="en"> 
    <head> 
        <meta charset="UTF-8"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link rel="stylesheet" type="text/css" href="css/style.css"> 
        <link rel="stylesheet" type="text/css" href="css/cssProfile/success.css"> 
        <title>Success - Cooking Delight</title> 
    </head> 
    <body> 
        <jsp:include page="../base/header.jsp" /> 
        <div class="success-message"> 
            <h3>Success!</h3> 
            <p><%= (String) request.getAttribute("msg")%></p> 
            <div class="countdown">
                You will be redirected to your profile view in <span id="countdown"></span> seconds, 
                <a href="profile?action=view">click here to go immediately.</a>
            </div>
            <script>
                let countdown = 5;
                let countdownInterval = setInterval(function() {
                    document.getElementById("countdown").innerText = countdown;
                    countdown--;
                    if (countdown <= 0) {
                        clearInterval(countdownInterval);
                        window.location.href = "profile?action=view";
                    }
                }, 1000);
            </script>
        </div> 
        <jsp:include page="../base/footer.jsp" /> 
    </body>  
</html>