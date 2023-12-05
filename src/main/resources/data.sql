INSERT INTO pet_entity (pet_id, user_id, pet_type, pet_name, pet_activity, pet_weight, pet_age, pet_illness, pet_price_range) VALUES
(1, 1, 'Dog', 'Rex', 'Active', 30.0, 7, NULL, 100),
(2, 1, 'Cat', 'Whiskers', 'Inactive', 15.0, 3, NULL, 50),
(3, 2, 'Dog', 'Fido', 'Active', 40.0, 5, 'Arthritis', 150);

INSERT INTO user_entity (user_id, user_role, user_nickname, user_email, user_phone, user_password) VALUES
(1, 'User', 'JohnD', 'john.doe@example.com', 1234567890, 'password'),
(2, 'Admin', 'JaneD', 'jane.doe@example.com', 0987654321, 'password123'),
(3, 'User', 'BobS', 'bob.smith@example.com', 1122334455, 'bobspassword');

INSERT INTO dry_food_entity (dry_id, dry_company, dry_food_age_type, dry_price, dry_weight, dry_calorie, dry_food_pet_type, img_name) VALUES
(1, 'ACANA GRASSLANDS DOG','Puppy', 19.0, 2.0, 381, 'Dog', '/images/DryFood1.png'),
(2, 'ACANA GRASSLANDS DOG','Junior', 19.0, 2.0, 381,'Dog', '/images/DryFood1.png'),
(3, 'ACANA GRASSLANDS DOG','Adult', 19.0, 2.0, 381,'Dog', '/images/DryFood1.png'),
(4, 'ACANA GRASSLANDS DOG','Senior', 19.0, 2.0, 381, 'Dog', '/images/DryFood1.png'),
(5, 'Acana Prairie Poultry','Puppy', 19.9, 2.0, 349, 'Dog', '/images/DryFood2.png'),
(6, 'Acana Prairie Poultry','Junior', 19.9, 2.0, 349, 'Dog', '/images/DryFood2.png'),
(7, 'Acana Prairie Poultry','Adult', 19.9, 2.0, 349, 'Dog', '/images/DryFood2.png'),
(8, 'Acana Prairie Poultry','Senior', 19.9, 2.0, 349, 'Dog', '/images/DryFood2.png'),
(9, 'Acana Puppy Recipe','Puppy', 23.6, 2, 366, 'Dog', '/images/DryFood3.png'),
(10, 'Acana Sport & Agility','Puppy', 68.10, 11.4, 372, 'Dog','/images/DryFood4.png'),
(11, 'Acana Sport & Agility','Junior', 68.10, 11.4, 372, 'Dog', '/images/DryFood4.png'),
(12, 'Acana Sport & Agility','Adult', 68.10, 11.4, 372, 'Dog', '/images/DryFood4.png'),
(13, 'Acana Sport & Agility','Senior', 68.10, 11.4, 372, 'Dog', '/images/DryFood4.png'),
(14, 'Acana Grass-Fed Lamb','Puppy', 77.10, 11.4, 339, 'Dog', '/images/DryFood5.png'),
(15, 'Acana Grass-Fed Lamb','Junior', 77.10, 11.4, 339, 'Dog', '/images/DryFood5.png'),
(16, 'Acana Grass-Fed Lamb','Adult', 77.10, 11.4, 339, 'Dog', '/images/DryFood5.png'),
(17, 'Acana Grass-Fed Lamb','Senior', 77.10, 11.4, 339, 'Dog', '/images/DryFood5.png'),
(18, 'Acana Free-Run Duck','Puppy', 87.10, 11.4, 339, 'Dog', '/images/DryFood6.png'),
(19, 'Acana Free-Run Duck','Junior', 87.10, 11.4, 339, 'Dog', '/images/DryFood6.png'),
(20, 'Acana Free-Run Duck','Adult', 87.10, 11.4, 339, 'Dog', '/images/DryFood6.png'),
(21, 'Acana Free-Run Duck','Senior', 87.10, 11.4, 339, 'Dog', '/images/DryFood6.png' ),
(22, 'Acana Classics Red Meat','Puppy', 24.90, 2, 342.5, 'Dog', '/images/DryFood7.png'),
(23, 'Acana Classics Red Meat','Junior', 24.90, 2, 342.5, 'Dog', '/images/DryFood7.png'),
(24, 'Acana Classics Red Meat','Adult', 24.90, 2, 342.5, 'Dog', '/images/DryFood7.png'),
(25, 'Acana Classics Red Meat','Senior', 24.90, 2, 342.5, 'Dog', '/images/DryFood7.png'),
(26, 'Acana Pacifica dog','Puppy', 81.0, 11.4, 385, 'Dog', '/images/DryFood8.png'),
(27, 'Acana Pacifica dog','Junior', 81.0, 11.4, 385, 'Dog', '/images/DryFood8.png'),
(28, 'Acana Pacifica dog','Adult', 81.0, 11.4, 385, 'Dog', '/images/DryFood8.png'),
(29, 'Acana Pacifica dog','Senior', 81.0, 11.4, 385, 'Dog', '/images/DryFood8.png'),
(30, 'Acana Wild Prairie dog','Puppy', 73.9, 11.4, 385, 'Dog', '/images/DryFood9.png'),
(31, 'Acana Wild Prairie dog','Junior', 73.9, 11.4, 385, 'Dog', '/images/DryFood9.png'),
(32, 'Acana Wild Prairie dog','Adult', 73.9, 11.4, 385, 'Dog', '/images/DryFood9.png'),
(33, 'Acana Wild Prairie dog','Senior', 73.9, 11.4, 385, 'Dog', '/images/DryFood9.png'),
(34, 'Acana Yorkshire Pork','Puppy', 75.3, 11.4, 339, 'Dog', '/images/DryFood10.png'),
(35, 'Acana Yorkshire Pork','Junior', 75.3, 11.4, 339, 'Dog', '/images/DryFood10.png'),
(36, 'Acana Yorkshire Pork','Adult', 75.3, 11.4, 339, 'Dog', '/images/DryFood10.png'),
(37, 'Acana Yorkshire Pork','Senior', 75.3, 11.4, 339, 'Dog', '/images/DryFood10.png'),
(38, 'Acana Wild Coast','Puppy', 83.10, 14.5, 344.3, 'Dog', '/images/DryFood11.png'),
(39, 'Acana Wild Coast','Junior', 83.10, 14.5, 344.3, 'Dog', '/images/DryFood11.png'),
(40, 'Acana Wild Coast','Adult', 83.10, 14.5, 344.3, 'Dog', '/images/DryFood11.png'),
(41, 'Acana Wild Coast','Senior', 83.10, 14.5, 344.3, 'Dog', '/images/DryFood11.png'),
(42, 'Acana Adult Dog','Adult', 66.10, 11.4, 351, 'Dog', '/images/DryFood12.png'),
(43, 'Acana Light & Fit','Puppy', 66.10, 11.4, 307, 'Dog', '/images/DryFood13.png'),
(44, 'Acana Light & Fit','Junior', 66.10, 11.4, 307, 'Dog', '/images/DryFood13.png'),
(45, 'Acana Light & Fit','Adult', 66.10, 11.4, 307, 'Dog', '/images/DryFood13.png'),
(46, 'Acana Light & Fit','Senior', 66.10, 11.4, 307, 'Dog', '/images/DryFood13.png'),
(47, 'Acana Senior Dog','Senior', 66.10, 11.4, 332.5, 'Dog', '/images/DryFood14.png'),
(48, 'Acana Ranchlands Dog', 'Puppy' , 86.6, 11.4, 379, 'Dog', '/images/DryFood15.png'),
(49, 'Acana Ranchlands Dog', 'Junior' , 86.6, 11.4, 379, 'Dog', '/images/DryFood15.png'),
(50, 'Acana Ranchlands Dog', 'Adult' , 86.6, 11.4, 379, 'Dog', '/images/DryFood15.png'),
(51, 'Acana Ranchlands Dog', 'Senior' , 86.6, 11.4, 379, 'Dog', '/images/DryFood15.png');
--(2, 'Oasy Cat Grain Free Adult Fish ', 21.0, 1.5, 'Cat'),
--(3, 'Savita Adult Dog Venison', 41.5, 4.0, 'Cat');

INSERT INTO canned_food_entity (canned_id, canned_company, canned_food_age_type, canned_price, canned_weight, canned_calorie, canned_food_pet_type, image_name) VALUES
(1, 'Carnilove Grain Free Dog Adult Venison & Reindeer', 'Adult', 2.84, 0.4, 116, 'Dog', '/images/CannedFood1.png'),
(2, 'Carnilove Grain Free Dog Adult Venison & Reindeer', 'Senior', 2.84, 0.4, 116, 'Dog', '/images/CannedFood2.png'),
(3, 'Carnilove Grain Free Dog Adult Lamb & Wild Boar', 'Adult', 2.84, 0.4, 107.5, 'Dog', '/images/CannedFood3.png'),
(4, 'Carnilove Grain Free Dog Adult Venison & Reindeer', 'Senior', 2.84, 0.4, 107.5, 'Dog', '/images/CannedFood4.png'),
(5, 'Carnilove Grain Free Puppy Salmon & Turkey', 'Puppy', 2.89, 0.4, 108, 'Dog', '/images/CannedFood5.png'),
(6, 'Carnilove Grain Free Dog Adult Salmon & Turkey', 'Adult', 2.84, 0.4, 108, 'Dog', '/images/CannedFood6.png'),
(7, 'Carnilove Grain Free Dog Adult Salmon & Turkey', 'Senior', 2.84, 0.4, 108, 'Dog', '/images/CannedFood7.png'),
(8, 'Carnilove Grain Free Dog Adult Duck & Pheasant', 'Adult', 2.84, 0.4, 121, 'Dog', '/images/CannedFood8.png'),
(9, 'Carnilove Grain Free Dog Adult Duck & Pheasant', 'Senior', 2.84, 0.4, 121, 'Dog', '/images/CannedFood9.png'),
(10, 'Almo Nature HFC Dog Natural Tuna & Cod', 'Adult', 3.39, 0.290, 76.5, 'Dog', '/images/CannedFood10.png'),
(11, 'Almo Nature HFC Dog Natural Tuna & Chicken', 'Adult', 3.39, 0.290, 93.9, 'Dog', '/images/CannedFood11.png'),
(12, 'Almo Nature HFC Dog Natural Pork', 'Adult', 1.82, 0.400, 76.2, 'Dog', '/images/CannedFood12.png'),
(13, 'Almo Nature Daily Dog Chicken Ham Cheese', 'Adult', 1.48, 0.300, 74.2, 'Dog', '/images/CannedFood13.png');

INSERT INTO canned_food_ingredients_entity (ingredient_id, canned_id, ingredient_name) VALUES
(8, 1, 'Deer'),
(8, 2, 'Deer'),
(1, 3, 'Lamb'),
(1, 4, 'Lamb'),
(9, 3, 'Wild Boar'),
(9, 4, 'Wild Boar'),
(10, 5, 'Salmon'),
(7, 5, 'Turkey'),
(10, 6, 'Salmon'),
(7, 7, 'Turkey'),
(3, 8, 'Duck'),
(11, 9, 'Pheasant'),
(12, 10, 'Tuna'),
(13, 10, 'Cod'),
(12, 11, 'Tuna'),
(2, 11, 'Chicken'),
(4, 12, 'Pork'),
(2, 13, 'Chicken'),
(4, 13, 'Pork'),
(14, 13, 'Cheese');

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
(3, 18, 'Duck'),
(3, 19, 'Duck'),
(3, 20, 'Duck'),
(3, 21, 'Duck'),
(3, 1, 'Duck'),
(3, 2, 'Duck'),
(3, 3, 'Duck'),
(3, 4, 'Duck'),
(4, 22, 'Pork'),
(4, 23, 'Pork'),
(4, 24, 'Pork'),
(4, 25, 'Pork'),
(4, 34, 'Pork'),
(4, 35, 'Pork'),
(4, 36, 'Pork'),
(4, 37, 'Pork'),
(4, 48, 'Pork'),
(4, 49, 'Pork'),
(4, 50, 'Pork'),
(4, 51, 'Pork'),
(5, 22, 'Beef'),
(5, 23, 'Beef'),
(5, 24, 'Beef'),
(5, 25, 'Beef'),
(5, 48, 'Beef'),
(5, 49, 'Beef'),
(5, 50, 'Beef'),
(5, 51, 'Beef'),
(6, 26, 'Fish'),
(6, 27, 'Fish'),
(6, 28, 'Fish'),
(6, 29, 'Fish'),
(6, 30, 'Fish'),
(6, 31, 'Fish'),
(6, 32, 'Fish'),
(6, 33, 'Fish'),
(6, 38, 'Fish'),
(6, 39, 'Fish'),
(6, 40, 'Fish'),
(6, 41, 'Fish'),
(7, 30, 'Turkey'),
(7, 31, 'Turkey'),
(7, 32, 'Turkey'),
(7, 33, 'Turkey'),
(7, 42, 'Turkey');

INSERT INTO allergic_foods_entity (allergic_id, ingredient_id, allergic_name) VALUES

(1, 1, 'Lamb'),
(2, 2, 'Chicken'),
(3, 3, 'Duck'),
(4, 4, 'Pork'),
(5, 5, 'Beef'),
(6, 6, 'Fish'),
(7, 7, 'Turkey'),
(8, 8, 'Deer'),
(9, 9, 'Wild Boar'),
(10, 10, 'Salmon'),
(11, 10, 'Pheasant'),
(12, 12, 'Tuna'),
(13, 13, 'Cod'),
(14, 14, 'Cheese');