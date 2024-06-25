-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 25, 2024 at 06:03 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cooking_delight_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `username` varchar(100) NOT NULL,
  `content` varchar(500) NOT NULL,
  `rating` int(11) NOT NULL,
  `recipeid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `newsletter`
--

CREATE TABLE `newsletter` (
  `email` varchar(100) NOT NULL,
  `created` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `newsletter`
--

INSERT INTO `newsletter` (`email`, `created`) VALUES
('s63606@ocean.umt.edu.my', '2024-06-24');

-- --------------------------------------------------------

--
-- Table structure for table `recipe`
--

CREATE TABLE `recipe` (
  `recipeid` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `shortDescription` varchar(200) NOT NULL,
  `prepTime` int(11) NOT NULL,
  `cookTime` int(11) NOT NULL,
  `serving` int(11) NOT NULL,
  `ingredients` varchar(300) NOT NULL,
  `instructions` varchar(1000) NOT NULL,
  `chefNote` varchar(150) DEFAULT NULL,
  `userid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `recipe`
--

INSERT INTO `recipe` (`recipeid`, `title`, `shortDescription`, `prepTime`, `cookTime`, `serving`, `ingredients`, `instructions`, `chefNote`, `userid`) VALUES
(6, 'Ayam Goreng Krispy', 'Rasa macam KFC.', 30, 15, 2, 'Chicken pieces, buttermilk, salt, black pepper, paprika, garlic powder, onion powder, cayenne pepper, flour, baking powder, vegetable oil, egg', '1. Marinate the chicken pieces in buttermilk for at least 4 hours or overnight in the refrigerator.\r\n2. In a large bowl, mix salt, black pepper, paprika, garlic powder, onion powder, and cayenne pepper.\r\n3. Add the marinated chicken to the spice mixture, ensuring each piece is evenly coated.\r\n4. In a separate bowl, combine flour and baking powder.\r\n5. In another bowl, beat an egg.\r\n6. Dip each chicken piece into the beaten egg, then dredge in the flour mixture, ensuring each piece is thoroughly coated.\r\n7. Heat vegetable oil in a deep fryer or large skillet to 350Â°F (175Â°C).\r\n8. Carefully place the coated chicken pieces in the hot oil, frying in batches to avoid overcrowding.\r\n9. Fry the chicken until golden brown and crispy, about 12-15 minutes, ensuring it reaches an internal temperature of 165Â°F (75Â°C).\r\n10. Remove the chicken from the oil and drain on paper towels.\r\n11. Serve hot and enjoy.', 'Finger lickin\' good.', 9),
(7, 'Spaghetti Bolognese', 'The Italian classic.', 20, 30, 2, 'Spaghetti, olive oil, ground beef, onion, garlic, carrot, celery, canned tomatoes, tomato paste, red wine, beef broth, bay leaves, dried oregano, dried basil, salt, black pepper, grated Parmesan cheese, fresh basil (optional)', 'Cook the spaghetti according to the package instructions until al dente, then drain and set aside.\r\nHeat olive oil in a large skillet or saucepan over medium heat.\r\nAdd the chopped onion, garlic, carrot, and celery, and sautÃÂ© until the vegetables are softened, about 5-7 minutes.\r\nAdd the ground beef to the skillet, breaking it apart with a spoon, and cook until browned.\r\nStir in the canned tomatoes, tomato paste, red wine, and beef broth.\r\nAdd the bay leaves, dried oregano, dried basil, salt, and black pepper.\r\nBring the sauce to a simmer, then reduce the heat to low.\r\nLet the sauce simmer for at least 30 minutes, stirring occasionally. For richer flavor, simmer for up to 1-2 hours.\r\nRemove the bay leaves from the sauce.\r\nServe the Bolognese sauce over the cooked spaghetti.\r\nGarnish with grated Parmesan cheese and fresh basil if desired.', '', 9),
(8, 'Chicken Alfredo', 'A creamy and delicious chicken Alfredo pasta.', 15, 25, 4, 'fettuccine pasta, chicken breast, olive oil, garlic, heavy cream, Parmesan cheese, butter, salt, black pepper, parsley', '1. Cook fettuccine pasta according to package instructions. Drain and set aside.\n2. In a large skillet, heat olive oil over medium heat.\n3. Add chicken breast and cook until browned and cooked through. Remove from skillet and set aside.\n4. In the same skillet, add garlic and cook until fragrant.\n5. Pour in heavy cream and bring to a simmer.\n6. Stir in Parmesan cheese and butter until melted and well combined.\n7. Return the chicken to the skillet and let it simmer in the sauce.\n8. Add the cooked fettuccine pasta and toss to coat in the sauce.\n9. Season with salt and black pepper to taste.\n10. Garnish with chopped parsley and serve hot.', 'For a richer flavor, use freshly grated Parmesan cheese.', 9),
(9, 'Vegetarian Tacos', 'Healthy and flavorful vegetarian tacos perfect for any meal.', 20, 10, 4, 'corn tortillas, black beans, corn kernels, red bell pepper, avocado, red onion, cilantro, lime, olive oil, cumin, chili powder, salt, black pepper, sour cream', '1. In a skillet, heat olive oil over medium heat.\n2. Add chopped red bell pepper and red onion, and sauté until softened.\n3. Stir in black beans and corn kernels.\n4. Season with cumin, chili powder, salt, and black pepper.\n5. Cook until heated through, then remove from heat.\n6. Warm corn tortillas in a separate skillet or microwave.\n7. Fill each tortilla with the black bean and corn mixture.\n8. Top with sliced avocado, chopped cilantro, and a squeeze of lime juice.\n9. Add a dollop of sour cream on top.\n10. Serve immediately and enjoy.', 'You can add your favorite hot sauce for an extra kick.', 9),
(10, 'Shrimp Scampi', 'A quick and easy shrimp scampi with garlic and lemon.', 10, 15, 4, 'shrimp, olive oil, garlic, white wine, lemon juice, red pepper flakes, butter, parsley, salt, black pepper, spaghetti', '1. Cook spaghetti according to package instructions. Drain and set aside.\n2. In a large skillet, heat olive oil over medium heat.\n3. Add minced garlic and red pepper flakes, and sauté until fragrant.\n4. Add shrimp and cook until pink and opaque.\n5. Pour in white wine and lemon juice, and bring to a simmer.\n6. Stir in butter until melted and well combined.\n7. Season with salt and black pepper to taste.\n8. Toss in cooked spaghetti and mix until well coated with the sauce.\n9. Garnish with chopped parsley and serve hot.', 'For a richer flavor, use freshly squeezed lemon juice and freshly chopped parsley.', 10),
(11, 'Beef Stroganoff', 'A classic beef stroganoff with tender beef and creamy mushroom sauce.', 20, 30, 4, 'beef sirloin, mushrooms, onion, garlic, butter, flour, beef broth, sour cream, Dijon mustard, egg noodles, salt, black pepper, parsley', '1. Cook egg noodles according to package instructions. Drain and set aside.\n2. In a large skillet, melt butter over medium heat.\n3. Add sliced mushrooms and chopped onion, and sauté until softened.\n4. Stir in minced garlic and cook until fragrant.\n5. Add sliced beef sirloin and cook until browned.\n6. Sprinkle flour over the beef and mushroom mixture, and stir to combine.\n7. Pour in beef broth and bring to a simmer.\n8. Stir in sour cream and Dijon mustard until well combined.\n9. Season with salt and black pepper to taste.\n10. Serve the beef stroganoff over the cooked egg noodles.\n11. Garnish with chopped parsley and serve hot.', 'For a richer flavor, use fresh mushrooms and high-quality beef broth.', 10),
(12, 'Lemon Garlic Roasted Chicken', 'A flavorful and juicy roasted chicken with lemon and garlic.', 15, 60, 4, 'whole chicken, lemon, garlic, olive oil, rosemary, thyme, salt, black pepper', '1. Preheat oven to 375°F (190°C).\n2. Rinse the whole chicken and pat dry with paper towels.\n3. Season the chicken inside and out with salt and black pepper.\n4. Stuff the cavity with lemon halves and garlic cloves.\n5. Rub the outside of the chicken with olive oil.\n6. Sprinkle rosemary and thyme over the chicken.\n7. Place the chicken in a roasting pan.\n8. Roast in the preheated oven for about 60 minutes, or until the internal temperature reaches 165°F (75°C).\n9. Let the chicken rest for 10 minutes before carving.\n10. Serve hot and enjoy.', 'For extra crispy skin, baste the chicken with its own juices halfway through cooking.', 10);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userid` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(75) NOT NULL,
  `email` varchar(50) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `gender` varchar(10) NOT NULL,
  `description` varchar(310) DEFAULT NULL,
  `picturePath` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `username`, `password`, `email`, `dateOfBirth`, `gender`, `description`, `picturePath`) VALUES
(9, 'brad', '$2a$10$s9aiqdqeDFkgglyyBO6ohe7WGU/CeZDBDEBH.hA5xOO6evf8OgpHS', 'BradPitt@gmail.com', '2024-06-01', 'male', 'A. B.\r\nC.', NULL),
(10, 'test', '$2a$10$Ws8fHgf7Xn2dxb2ycRoPTuUdGodQauN2NxdOQN2ZI6dYgVGs45I.6', 'test@gmail.com', '2024-06-01', 'male', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD KEY `comment_recipeid` (`recipeid`);

--
-- Indexes for table `recipe`
--
ALTER TABLE `recipe`
  ADD PRIMARY KEY (`recipeid`),
  ADD KEY `fk_userid` (`userid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `recipe`
--
ALTER TABLE `recipe`
  MODIFY `recipeid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_recipeid` FOREIGN KEY (`recipeid`) REFERENCES `recipe` (`recipeid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `recipe`
--
ALTER TABLE `recipe`
  ADD CONSTRAINT `fk_userid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
