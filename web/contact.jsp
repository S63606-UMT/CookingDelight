<%-- 
    Document   : contact
    Created on : 11 Jun 2024, 9:05:52 am
    Author     : Saiful
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/page/contact.css">
        <title>Contact Us - Cooking Delight</title>
    </head>
    <body>
        <jsp:include page="base/header.jsp" />
        <main>
            <section class="contact-form">
                <h2>Contact Us</h2>
                <form>
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" required>

                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>

                    <label for="subject">Subject</label>
                    <input type="text" id="subject" name="subject">

                    <label for="message">Message</label>
                    <textarea id="message" name="message" rows="5" required></textarea>

                    <button type="submit">Send Message</button>
                </form>
            </section>
            <section class="contact-info">
                <h2>Contact Information</h2>
                <p>Email: <a href="mailto:info@cookingdelight.com">info@cookingdelight.com</a></p>
                <p>Phone: (123) 456-7890</p>
                <p>Address: 123 Foodie Lane, Culinary City, FL 12345</p>
                <p>Follow us on:
                    <a href="#" style="color: #ff5722;">Facebook</a>,
                    <a href="#" style="color: #ff5722;">Instagram</a>,
                    <a href="#" style="color: #ff5722;">Twitter</a>
                </p>
            </section>
            <section class="faq">
                <h2>Frequently Asked Questions</h2>
                <p><strong>Q: How can I submit a recipe?</strong></p>
                <p>A: You can submit a recipe by filling out the contact form above and selecting "Recipe Submission" as the subject.</p>
                <p><strong>Q: Can I request a specific recipe?</strong></p>
                <p>A: Yes, feel free to send us a message through the contact form with your recipe request, and we'll do our best to fulfill it.</p>
            </section>
        </main>
        <jsp:include page="base/footer.jsp" />
    </body>
</html>

