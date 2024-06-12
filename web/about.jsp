<%-- 
    Document   : about
    Created on : 11 Jun 2024, 8:50:35 am
    Author     : Saiful
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/page/about.css">
        <title>About Us - Cooking Delight</title>
    </head>
    <body>
        <jsp:include page="base/header.jsp" />
        <main>
            <section class="section">
                <h2>Welcome to Cooking Delight!</h2>
                <p>At Cooking Delight, we believe that cooking is an art that brings joy and satisfaction. Our mission is to inspire and empower home cooks with delicious recipes and valuable cooking tips.</p>
            </section>
            <section class="section">
                <h2>Our Story</h2>
                <p>Cooking Delight was born out of a passion for food and a love for sharing great recipes. Founded by [Your Name], a culinary enthusiast with years of experience in the kitchen, our website aims to make cooking accessible and enjoyable for everyone.</p>
                <img src="your-photo.jpg" alt="Photo of the author/chef">
            </section>
            <section class="section">
                <h2>About the Author</h2>
                <p>[Your Name] started cooking at a young age and has since perfected the art of creating mouth-watering dishes. With a background in [mention any relevant background], [Your Name] brings a wealth of knowledge and a personal touch to every recipe shared on Cooking Delight.</p>
            </section>
            <section class="section">
                <h2>What You'll Find Here</h2>
                <p>From quick and easy weeknight dinners to elaborate holiday feasts, Cooking Delight offers a wide range of recipes to suit all tastes and skill levels. Whether you're a beginner or a seasoned cook, you'll find something to spark your culinary creativity.</p>
            </section>
            <section class="section">
                <h2>Achievements and Recognition</h2>
                <p>We are proud to have been featured in [mention any publications or awards]. Our dedication to quality and our commitment to our readers have earned us a loyal following and industry recognition.</p>
            </section>
            <section class="section">
                <h2>Join Our Community</h2>
                <p>We love hearing from our readers! Connect with us on social media, share your feedback, and join our community of food lovers. Your input helps us grow and improve.</p>
            </section>
            <section class="contact">
                <h2>Contact Us</h2>
                <p>Email: <a href="mailto:info@cookingdelight.com">info@cookingdelight.com</a></p>
                <p>Follow us on 
                    <a href="#" style="color: #ff5722;">Facebook</a>, 
                    <a href="#" style="color: #ff5722;">Instagram</a>, 
                    <a href="#" style="color: #ff5722;">Twitter</a>
                </p>
            </section>
            <section class="newsletter">
                <h2>Subscribe to Our Newsletter</h2>
                <form>
                    <input type="email" placeholder="Enter your email" required>
                    <button type="submit">Subscribe</button>
                </form>
            </section>
        </main>
        <jsp:include page="base/footer.jsp" />
    </body>
</html>
