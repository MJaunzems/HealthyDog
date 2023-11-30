DROP TABLE IF EXISTS pet_entity;

CREATE TABLE pet_entity (
   pet_id BIGINT NOT NULL,
   user_id BIGINT NOT NULL,
   pet_type ENUM ('Dog', 'Cat'),
   pet_name VARCHAR(255) NULL,
   pet_activity ENUM ('Active', 'Inactive'),
   pet_weight DOUBLE NOT NULL,
   pet_age INT NOT NULL,
   pet_illness VARCHAR(255) NULL,
   pet_price_range INT NOT NULL,
   CONSTRAINT pk_petentity PRIMARY KEY (pet_id, user_id)
);

DROP TABLE IF EXISTS user_entity;

CREATE TABLE user_entity (
   user_id BIGINT NOT NULL,
   user_role ENUM ('User', 'Admin'),
   user_nickname VARCHAR(255) NULL,
   user_email VARCHAR(255) NULL,
   user_phone INT NOT NULL,
   user_password VARCHAR(255) NULL,
   CONSTRAINT pk_userentity PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS dry_food_entity;

CREATE TABLE dry_food_entity (
   dry_id BIGINT NOT NULL,
   dry_company VARCHAR(255) NULL,
   dry_price DOUBLE NOT NULL,
   dry_weight DOUBLE NOT NULL,
   dry_food_pet_type ENUM ('Dog', 'Cat'),
   CONSTRAINT pk_dryfoodentity PRIMARY KEY (dry_id)
);

DROP TABLE IF EXISTS canned_food_entity;

CREATE TABLE canned_food_entity (
   canned_id BIGINT NOT NULL,
   canned_company VARCHAR(255) NULL,
   canned_price DOUBLE NOT NULL,
   canned_weight DOUBLE NOT NULL,
   canned_food_pet_type ENUM ('Dog', 'Cat'),
   CONSTRAINT pk_cannedfoodentity PRIMARY KEY (canned_id)
);

DROP TABLE IF EXISTS dry_food_ingredients_entity;

CREATE TABLE dry_food_ingredients_entity (
   ingredient_id BIGINT NOT NULL,
   dry_id BIGINT NOT NULL,
   ingredient_name VARCHAR(255) NULL,
   CONSTRAINT pk_dryfoodingredientsentity PRIMARY KEY (ingredient_id, dry_id)
);

DROP TABLE IF EXISTS canned_food_ingredients_entity;

CREATE TABLE canned_food_ingredients_entity (
   ingredient_id BIGINT NOT NULL,
   canned_id BIGINT NOT NULL,
   ingredient_name VARCHAR(255) NULL,
   CONSTRAINT pk_cannedfoodingredientsentity PRIMARY KEY (ingredient_id, canned_id)
);

DROP TABLE IF EXISTS allergic_foods_entity;

CREATE TABLE allergic_foods_entity (
   allergic_id BIGINT NOT NULL,
   pet_id BIGINT NOT NULL,
   ingredient_id BIGINT NOT NULL,
   allergic_name VARCHAR(255) NULL,
   CONSTRAINT pk_allergicfoodsentity PRIMARY KEY (allergic_id, pet_id, ingredient_id)
);