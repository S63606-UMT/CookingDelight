# Cooking Delight  
A website that offers knowledge on the delicacy around you, your people and your world.

# Purpose
A web app developed for CSM3023 assignment. Designed according to the MVC Architecture, using mainly Java.

# ProfileView TODO: 
1. Implement a wrapper to block direct access using URLs.
2. Implement a more secure login.
        - store the password's hash instead of plain text ✔
3. Implement additional features.
        - profile image ✔
        - simple verification process (optional) 
4. Fix bugs
        - entering the wrong value in login.jsp seem to create a session anyway. FIXED ✔
5. Implement conditions for changing password. (Just copy it from register function)
6. Complete the profile image feature
        - When a file is chosen, display underneath the existing profile image.
        - Redirect to profile view if empty.

# RecipeView TODO: 
1. Create recipe table under cooking_delight_db.sql
2. Create the necessary view (HTML, JSP, CSS, JS) in /recipeView
	- Three category of food
	- paging is inevitable
	- prime place to use JSTL?
	- The recipe should allow markdown format for better readability for client.
3. Create recipeDAO.java in com.dao to access database.
	- Use com.util.DBConnection to open connection.
4. Create recipe.java in com.Model for reusability.
	- Simple is best.
5. Create RecipeController.java to be the intermediary between the View and the business process.