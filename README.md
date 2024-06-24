# Cooking Delight  
A website that offers knowledge on the delicacy around you, your people and your world. It offers the capbility to store your recipe in digital form. People from all walks of life can and share their recipes with each other, fostering a foodie community with food in mind and stomach. 

# Purpose
A web app developed for CSM3023 assignment. Designed according to the MVC Architecture, using mainly Java.

## Requirements
1. Netbeans  (Note: Or other IDE you prefer)
	- With Tomcat configured.  
	- JDK  
 	- JSTL (core)  
	- mysql-connector-java (8.0.17)  
  	- BCrypt (Java™ implementation of OpenBSD's Blowfish password hashing code)  
2. xampp  
   	- mysql/phpmyadmin  
   	- Apache  
   	- Tomcat  

## How to use?  
1. ```git clone``` or download the zip.  
2. Add project in Netbeans.
3. Add JSTL and mysql-connector-java in Libraries.
4. Import sql database in phpmyadmin.
5. Run the web app.

## Profile TODO:  
1. Implement a wrapper to block direct access using URLs.  ✔  
2. Implement a more secure login.  
	- store the password's hash instead of plain text ✔
3. Implement additional features.  
	- profile image ✔  
	- simple verification process (optional) ❌  
4. Fix bugs  
	- entering the wrong value in login.jsp seem to create a session anyway. FIXED ✔  
5. Implement conditions for changing password. ✔  
6. Complete the profile image feature  
	- For profile image update, Redirect to profile view if empty. ✔  

## Recipe TODO:  
1. Create recipe table under cooking_delight_db.sql ✔  
2. Create the necessary view (HTML, JSP, CSS, JS) in /recipeView ✔  
	- Three category of food ❌  
	- paging is inevitable ❌  
	- prime place to use JSTL? ✔  
	- The recipe should allow markdown format for better readability for client. ❌  
3. Create recipeDAO.java in com.dao to access database. ✔  
	- Use com.util.DBConnection to open connection. ✔  
4. Create recipe.java in com.Model for reusability. ✔  
5. Create RecipeController.java to be the intermediary between the View and the business process. ✔  
6. Implement CRUD ✔  

## Comment TODO  
1. All users are allowed to use, logged in or not  ✔  
2. Store comment along with recipe ID as the foreign key ✔  
3. Delete comment alongside recipe ✔  
4. The manager is able to do retrieve and delete operations for moderations purposes ❌

## Newsletter TODO  
1. Store email.  
2. Yeah that's it.  

## Support TODO  
1. Implement a form that is capable of sending email to the manager's address  
