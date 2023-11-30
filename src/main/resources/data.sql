INSERT INTO pet_entity (pet_id, user_id, pet_type, pet_name, pet_activity, pet_weight, pet_age, pet_illness, pet_price_range) VALUES
(1, 1, 'Dog', 'Rex', 'Active', 30.0, 7, NULL, 100),
(2, 1, 'Cat', 'Whiskers', 'Inactive', 15.0, 3, NULL, 50),
(3, 2, 'Dog', 'Fido', 'Active', 40.0, 5, 'Arthritis', 150);

INSERT INTO user_entity (user_id, user_role, user_nickname, user_email, user_phone, user_password) VALUES
(1, 'User', 'JohnD', 'john.doe@example.com', 1234567890, 'password'),
(2, 'Admin', 'JaneD', 'jane.doe@example.com', 0987654321, 'password123'),
(3, 'User', 'BobS', 'bob.smith@example.com', 1122334455, 'bobspassword');

INSERT INTO dry_food_entity (dry_id, dry_company, dry_price, dry_weight, dry_food_pet_type) VALUES
(1, 'PetFoodCo', 20.0, 5.0, 'Dog'),
(2, 'HealthyPets', 25.0, 4.0, 'Cat'),
(3, 'NaturalChoice', 30.0, 6.0, 'Cat');

INSERT INTO canned_food_entity (canned_id, canned_company, canned_price, canned_weight, canned_food_pet_type) VALUES
(1, 'PetFoodCo', 2.0, 0.5, 'Dog'),
(2, 'HealthyPets', 2.5, 0.4, 'Cat'),
(3, 'NaturalChoice', 3.0, 0.6, 'Dog');

INSERT INTO dry_food_ingredients_entity (ingredient_id, dry_id, ingredient_name) VALUES
(1, 1, 'Chicken'),
(2, 1, 'Rice'),
(3, 2, 'Beef');

INSERT INTO canned_food_ingredients_entity (ingredient_id, canned_id, ingredient_name) VALUES
(4, 1, 'Chicken'),
(5, 2, 'Salmon'),
(6, 3, 'Turkey');

INSERT INTO allergic_foods_entity (allergic_id, pet_id, ingredient_id, allergic_name) VALUES
(1, 1, 3, 'Beef'),
(2, 2, 1, 'Chicken'),
(3, 3, 5, 'Salmon');

