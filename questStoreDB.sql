CREATE TABLE user_details
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE roles
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE users
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    user_details_id BIGINT REFERENCES user_details (id),
    role_id BIGINT REFERENCES roles (id),
	isActive BOOLEAN NOT NULL
);

CREATE TABLE categories
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    category VARCHAR(500)
);


CREATE TABLE modules
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);


CREATE TABLE mentors
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    user_id BIGINT REFERENCES users (id),
    module_id BIGINT REFERENCES modules (id)
);


CREATE TABLE rewards
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(500) NOT NULL,
    price BIGINT,
    category_id BIGINT REFERENCES categories (id),
    mentor_id BIGINT REFERENCES users (id),
    times_ordered BIGINT
);



CREATE TABLE shared_wallets
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    reward_id BIGINT REFERENCES rewards (id),
    coins BIGINT
);


CREATE TABLE quest_statuses
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    status VARCHAR(500)
);

CREATE TABLE quests
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(500) NOT NULL,
    coins_to_earn BIGINT,
    module_id BIGINT REFERENCES modules (id)
);


CREATE TABLE student_quests
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    quest_id BIGINT REFERENCES quests (id),
    quest_status_id BIGINT REFERENCES quest_statuses (id),
    quest_input_area VARCHAR(500)
);


CREATE TABLE students
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    user_id BIGINT REFERENCES users (id),
    module_id BIGINT REFERENCES modules (id),
    student_quest_id BIGINT REFERENCES student_quests (id),
    wallet BIGINT,
	shared_wallet_id BIGINT REFERENCES shared_wallets (id)
);


CREATE TABLE order_statuses
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    status VARCHAR(500)
);


CREATE TABLE orders
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    student_id BIGINT REFERENCES students (id),
    reward_id BIGINT REFERENCES rewards (id),
    order_status_id BIGINT REFERENCES order_statuses (id)
);


