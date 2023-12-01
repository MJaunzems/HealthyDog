INSERT INTO pet_entity (pet_id, user_id, pet_type, pet_name, pet_activity, pet_weight, pet_age, pet_illness, pet_price_range) VALUES
(1, 1, 'Dog', 'Rex', 'Active', 30.0, 7, NULL, 100),
(2, 1, 'Cat', 'Whiskers', 'Inactive', 15.0, 3, NULL, 50),
(3, 2, 'Dog', 'Fido', 'Active', 40.0, 5, 'Arthritis', 150);

INSERT INTO user_entity (user_id, user_role, user_nickname, user_email, user_phone, user_password) VALUES
(1, 'User', 'JohnD', 'john.doe@example.com', 1234567890, 'password'),
(2, 'Admin', 'JaneD', 'jane.doe@example.com', 0987654321, 'password123'),
(3, 'User', 'BobS', 'bob.smith@example.com', 1122334455, 'bobspassword');

INSERT INTO dry_food_entity (dry_id, dry_company, dry_food_age_type, dry_price, dry_weight, dry_calorie, dry_food_pet_type) VALUES
(1, 'ACANA GRASSLANDS DOG','Puppy', 19.0, 2.0, 381, 'Dog'),
(2, 'ACANA GRASSLANDS DOG','Junior', 19.0, 2.0, 381,'Dog'),
(3, 'ACANA GRASSLANDS DOG','Adult', 19.0, 2.0, 381,'Dog'),
(4, 'ACANA GRASSLANDS DOG','Senior', 19.0, 2.0, 381, 'Dog'),
(5, 'Acana Prairie Poultry','Puppy', 19.9, 2.0, 349, 'Dog'),
(6, 'Acana Prairie Poultry','Junior', 19.9, 2.0, 349, 'Dog'),
(7, 'Acana Prairie Poultry','Adult', 19.9, 2.0, 349, 'Dog'),
(8, 'Acana Prairie Poultry','Senior', 19.9, 2.0, 349, 'Dog'),
(9, 'Acana Puppy Recipe','Puppy', 23.6, 2, 366, 'Dog'),
(10, 'Acana Sport & Agility','Puppy', 68.10, 11.4, 372, 'Dog'),
(11, 'Acana Sport & Agility','Junior', 68.10, 11.4, 372, 'Dog'),
(12, 'Acana Sport & Agility','Adult', 68.10, 11.4, 372, 'Dog'),
(13, 'Acana Sport & Agility','Senior', 68.10, 11.4, 372, 'Dog'),
(14, 'Acana Grass-Fed Lamb','Puppy', 77.10, 11.4, 339, 'Dog'),
(15, 'Acana Grass-Fed Lamb','Junior', 77.10, 11.4, 339, 'Dog'),
(16, 'Acana Grass-Fed Lamb','Adult', 77.10, 11.4, 339, 'Dog'),
(17, 'Acana Grass-Fed Lamb','Senior', 77.10, 11.4, 339, 'Dog'),
(18, 'Acana Free-Run Duck','Puppy', 87.10, 11.4, 339, 'Dog'),
(19, 'Acana Free-Run Duck','Junior', 87.10, 11.4, 339, 'Dog'),
(20, 'Acana Free-Run Duck','Adult', 87.10, 11.4, 339, 'Dog'),
(21, 'Acana Free-Run Duck','Senior', 87.10, 11.4, 339, 'Dog'),
(22, 'Acana Classics Red Meat','Puppy', 24.90, 2, 342.5, 'Dog'),
(23, 'Acana Classics Red Meat','Junior', 24.90, 2, 342.5, 'Dog'),
(24, 'Acana Classics Red Meat','Adult', 24.90, 2, 342.5, 'Dog'),
(25, 'Acana Classics Red Meat','Senior', 24.90, 2, 342.5, 'Dog'),
(26, 'Acana Pacifica dog','Puppy', 81.0, 11.4, 385, 'Dog'),
(27, 'Acana Pacifica dog','Junior', 81.0, 11.4, 385, 'Dog'),
(28, 'Acana Pacifica dog','Adult', 81.0, 11.4, 385, 'Dog'),
(29, 'Acana Pacifica dog','Senior', 81.0, 11.4, 385, 'Dog'),
(30, 'Acana Wild Prairie dog','Puppy', 73.9, 11.4, 385, 'Dog'),
(31, 'Acana Wild Prairie dog','Junior', 73.9, 11.4, 385, 'Dog'),
(32, 'Acana Wild Prairie dog','Adult', 73.9, 11.4, 385, 'Dog'),
(33, 'Acana Wild Prairie dog','Senior', 73.9, 11.4, 385, 'Dog'),
(34, 'Acana Yorkshire Pork','Puppy', 75.3, 11.4, 339, 'Dog'),
(35, 'Acana Yorkshire Pork','Junior', 75.3, 11.4, 339, 'Dog'),
(36, 'Acana Yorkshire Pork','Adult', 75.3, 11.4, 339, 'Dog'),
(37, 'Acana Yorkshire Pork','Senior', 75.3, 11.4, 339, 'Dog'),
(38, 'Acana Wild Coast','Puppy', 83.10, 14.5, 344.3, 'Dog'),
(39, 'Acana Wild Coast','Junior', 83.10, 14.5, 344.3, 'Dog'),
(40, 'Acana Wild Coast','Adult', 83.10, 14.5, 344.3, 'Dog'),
(41, 'Acana Wild Coast','Senior', 83.10, 14.5, 344.3, 'Dog'),
(42, 'Acana Adult Dog','Adult', 66.10, 11.4, 351, 'Dog'),
(43, 'Acana Light & Fit','Puppy', 66.10, 11.4, 307, 'Dog'),
(44, 'Acana Light & Fit','Junior', 66.10, 11.4, 307, 'Dog'),
(45, 'Acana Light & Fit','Adult', 66.10, 11.4, 307, 'Dog'),
(46, 'Acana Light & Fit','Senior', 66.10, 11.4, 307, 'Dog'),
(47, 'Acana Senior Dog','Senior', 66.10, 11.4, 332.5, 'Dog'),
(48, 'Acana Ranchlands Dog', 86.6, 11.4, 379, 'Dog'),
(49, 'Acana Ranchlands Dog', 86.6, 11.4, 379, 'Dog'),
(50, 'Acana Ranchlands Dog', 86.6, 11.4, 379, 'Dog'),
(51, 'Acana Ranchlands Dog', 86.6, 11.4, 379, 'Dog'),
--(2, 'Oasy Cat Grain Free Adult Fish ', 21.0, 1.5, 'Cat'),
--(3, 'Savita Adult Dog Venison', 41.5, 4.0, 'Cat');

INSERT INTO canned_food_entity (canned_id, canned_company, canned_price, canned_weight, canned_food_pet_type) VALUES
(1, 'BLITZ DUCK', 2.0, 0.2, 'Dog'),
(2, 'BANDITOS', 0.49, 0.075, 'Cat'),
(3, 'BLITZ BEEF', 2.0, 0.2, 'Dog');

INSERT INTO dry_food_ingredients_entity (ingredient_id, dry_id, ingredient_name) VALUES
(1, 1, 'Lamb'),
(1, 2, 'Lamb'),
(1, 3, 'Lamb'),
(1, 4, 'Lamb'),
(1, 17, 'Lamb'),
(1, 22, 'Lamb'),
(1, 23, 'Lamb'),
(1, 24, 'Lamb'),
(1, 25, 'Lamb'),
(1, 48, 'Lamb'),
(1, 49, 'Lamb'),
(1, 50, 'Lamb'),
(1, 51, 'Lamb'),
(2, 5, 'Chicken'),
(2, 6, 'Chicken'),
(2, 7, 'Chicken'),
(2, 8, 'Chicken'),
(2, 9, 'Chicken'),
(2, 10, 'Chicken'),
(2, 11, 'Chicken'),
(2, 12, 'Chicken'),
(2, 13, 'Chicken'),
(2, 14, 'Chicken'),
(2, 15, 'Chicken'),
(2, 16, 'Chicken'),
(2, 42, 'Chicken'),
(2, 43, 'Chicken'),
(2, 44, 'Chicken'),
(2, 45, 'Chicken'),
(2, 46, 'Chicken'),
(2, 47, 'Chicken'),
(4, 2, 'Fish'),
(5, 3, 'Deer'),
(6, 18, 'Duck'),
(6, 19, 'Duck'),
(6, 20, 'Duck'),
(6, 21, 'Duck'),
(7, 22, 'Pork'),
(7, 23, 'Pork'),
(7, 24, 'Pork'),
(7, 25, 'Pork'),
(7, 34, 'Pork'),
(7, 35, 'Pork'),
(7, 36, 'Pork'),
(7, 37, 'Pork'),
(7, 48, 'Pork'),
(7, 49, 'Pork'),
(7, 50, 'Pork'),
(7, 51, 'Pork'),
(8, 22, 'Beef'),
(8, 23, 'Beef'),
(8, 24, 'Beef'),
(8, 25, 'Beef'),
(8, 48, 'Beef'),
(8, 49, 'Beef'),
(8, 50, 'Beef'),
(8, 51, 'Beef'),
(9, 26, 'Fish'),
(9, 27, 'Fish'),
(9, 28, 'Fish'),
(9, 29, 'Fish'),
(9, 30, 'Fish'),
(9, 31, 'Fish'),
(9, 32, 'Fish'),
(9, 33, 'Fish'),
(9, 38, 'Fish'),
(9, 39, 'Fish'),
(9, 40, 'Fish'),
(9, 41, 'Fish'),
(10, 30, 'Turkey'),
(10, 31, 'Turkey'),
(10, 32, 'Turkey'),
(10, 33, 'Turkey'),
(10, 42, 'Turkey');

INSERT INTO canned_food_ingredients_entity (ingredient_id, canned_id, ingredient_name) VALUES
(4, 1, 'Duck'),
(5, 2, 'Beef'),
(6, 3, 'Beef');

INSERT INTO allergic_foods_entity (allergic_id, pet_id, ingredient_id, allergic_name) VALUES
(1, 1, 3, 'Beef'),
(2, 2, 1, 'Chicken'),
(3, 3, 5, 'Salmon');