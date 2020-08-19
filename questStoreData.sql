insert into user_details (email, password) values ('mateusz.steliga@codecool.com', 'mateusz123');
insert into user_details (email, password) values ('agnieszka.koszany@codecool.com', 'agnieszka123');
insert into user_details (email, password) values ('marcin.izworski@codecool.com', 'marcin123');
insert into user_details (email, password) values ('roman@wolny.net', 'roman123');
insert into user_details (email, password) values ('zenek@prosty.com', 'zenek123');
insert into user_details (email, password) values ('ala@paskuda.com', 'ala123');
insert into user_details (email, password) values ('franek.kimono@codecool.com', 'franek123');
insert into user_details (email, password) values ('imre@williams.com', 'imre123');
insert into user_details (email, password) values ('max@kolanko.com', 'max123');
insert into user_details (email, password) values ('wojtek@tokarz.com', 'wojtek123');
insert into user_details (email, password) values ('tomek@zielonka.com', 'tomek123');
insert into user_details (email, password) values ('kuba@waldemar.com', 'kuba123');
insert into user_details (email, password) values ('jurek@killer.com', 'kuba123');
insert into user_details (email, password) values ('ola@ziemba.com', 'ola123');
insert into user_details (email, password) values ('marta@jurkiewicz.com', 'marta123');
insert into user_details (email, password) values ('emil@bomba.com', 'emil123');
insert into user_details (email, password) values ('dorota@jaworek.com', 'dorota123');
insert into user_details (email, password) values ('ewa@piskarska.com', 'ewa123');
insert into user_details (email, password) values ('leon@bezdomny.com', 'leon123');
insert into user_details (email, password) values ('chris@beck.com', 'chris123');

insert into roles (role) values ('admin');
insert into roles (role) values ('mentor');
insert into roles (role) values ('student');


insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Mateusz', 'Steliga', 1, 2, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Agnieszka', 'Koszany', 2, 2, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Marcin', 'Izworski', 3, 2, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Roman', 'Wolny', 4, 3, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Zenek', 'Prosty', 5, 3, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Ala', 'Paskuda', 6, 3, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Franek', 'Kimono', 7, 1, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Imre', 'Williams', 8, 3, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Max', 'Kolanko', 9, 3, FALSE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Wojtek', 'Tokarz', 10, 3, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Tomek', 'Zielonka', 11, 3, FALSE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Kuba', 'Waldemar', 12, 3, FALSE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Jurek', 'Killer', 13, 3, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Ola', 'Ziemba', 14, 3, FALSE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Marta', 'Jurkiewicz', 15, 3, FALSE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Emil', 'Bomba', 16, 3, FALSE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Dorota', 'Jaworek', 17, 3, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Ewa', 'Piskarska', 18, 3, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Leon', 'Bezdomny', 19, 3, TRUE);
insert into users (first_name, last_name, user_details_id, role_id, isActive) values ('Chris', 'Beck', 20, 3, TRUE);

insert into categories (category) values ('single user');
insert into categories (category) values ('multiple users');


insert into modules (name) values ('ProgBase');
insert into modules (name) values ('JavaOOP');
insert into modules (name) values ('Web with SQL');
insert into modules (name) values ('Advanced');

insert into mentors (user_id, module_id) values (1, 1);
insert into mentors (user_id, module_id) values (2, 2);
insert into mentors (user_id, module_id) values (3, 3);
insert into mentors (user_id, module_id) values (1, 2);
insert into mentors (user_id, module_id) values (2, 3);
insert into mentors (user_id, module_id) values (3, 4);

insert into rewards (name, description, price, category_id, mentor_id, times_ordered) values ('reward 1', 'description 1', 10000, 1, 1, 5);
insert into rewards (name, description, price, category_id, mentor_id, times_ordered) values ('reward 2', 'description 2', 13000, 1, 1, 2);
insert into rewards (name, description, price, category_id, mentor_id, times_ordered) values ('reward 3', 'description 3', 18000, 1, 3, 4);
insert into rewards (name, description, price, category_id, mentor_id, times_ordered) values ('reward 4', 'description 4', 22000, 1, 1, 2);
insert into rewards (name, description, price, category_id, mentor_id, times_ordered) values ('reward 5', 'description 5', 25000, 1, 2, 3);
insert into rewards (name, description, price, category_id, mentor_id, times_ordered) values ('reward 6', 'description 6', 30000, 1, 1, 2);
insert into rewards (name, description, price, category_id, mentor_id, times_ordered) values ('reward 7', 'description 7', 32000, 1, 3, 1);
insert into rewards (name, description, price, category_id, mentor_id, times_ordered) values ('reward 8', 'description 8', 35000, 2, 2, 1);
insert into rewards (name, description, price, category_id, mentor_id, times_ordered) values ('reward 9', 'description 9', 38000, 2, 1, 1);
insert into rewards (name, description, price, category_id, mentor_id, times_ordered) values ('reward 10', 'description 10', 40000, 2, 3, 0);

insert into shared_wallets (reward_id, coins) values (8, 25000);
insert into shared_wallets (reward_id, coins) values (9, 31000);

insert into quest_statuses (status) values ('not started');
insert into quest_statuses (status) values ('in progres');
insert into quest_statuses (status) values ('submitted');
insert into quest_statuses (status) values ('approved');
insert into quest_statuses (status) values ('not approved');

insert into quests (name, description, coins_to_earn, module_id) values ('quest 1', 'description 1', 500, 1);
insert into quests (name, description, coins_to_earn, module_id) values ('quest 2', 'description 2', 1500, 2);
insert into quests (name, description, coins_to_earn, module_id) values ('quest 3', 'description 3', 2000, 3);
insert into quests (name, description, coins_to_earn, module_id) values ('quest 4', 'description 4', 1300, 4);
insert into quests (name, description, coins_to_earn, module_id) values ('quest 5', 'description 5', 3000, 2);
insert into quests (name, description, coins_to_earn, module_id) values ('quest 6', 'description 6', 3500, 1);
insert into quests (name, description, coins_to_earn, module_id) values ('quest 7', 'description 7', 4000, 3);
insert into quests (name, description, coins_to_earn, module_id) values ('quest 8', 'description 8', 2800, 1);
insert into quests (name, description, coins_to_earn, module_id) values ('quest 9', 'description 9', 3200, 2);
insert into quests (name, description, coins_to_earn, module_id) values ('quest 10', 'description 10', 4200, 4);

insert into student_quests (quest_id, quest_status_id, quest_input_area) values (1, 3, 'quest 1 submission');
insert into student_quests (quest_id, quest_status_id, quest_input_area) values (4, 3, 'quest 4 submission');
insert into student_quests (quest_id, quest_status_id, quest_input_area) values (6, 4, 'quest 6 submission');
insert into student_quests (quest_id, quest_status_id, quest_input_area) values (8, 3, 'quest 8 submission');
insert into student_quests (quest_id, quest_status_id, quest_input_area) values (10, 4, 'quest 10 submission');

insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (4, 2, 1, 5000, 1);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (5, 2, null, 6500, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (6, 3, null, 7200, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (8, 2, 2, 8000, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (9, 3, 3, 7100, 2);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (10, 4, null, 6200, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (11, 2, 4, 4200, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (12, 3, null, 7000, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (13, 2, null, 7650, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (14, 3, null, 8000, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (15, 2, 5, 5500, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (16, 3, null, 6000, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (17, 2, null, 5800, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (18, 4, null, 6150, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (19, 3, null, 6900, null);
insert into students (user_id, module_id, student_quest_id, wallet, shared_wallet_id) values (20, 4, null, 8100, null);

insert into order_statuses (status) values ('used');
insert into order_statuses (status) values ('not used');

insert into orders (student_id, reward_id, order_status_id) values (1, 1, 1);
insert into orders (student_id, reward_id, order_status_id) values (4, 1, 1);
insert into orders (student_id, reward_id, order_status_id) values (6, 3, 2);
insert into orders (student_id, reward_id, order_status_id) values (9, 4, 2);
insert into orders (student_id, reward_id, order_status_id) values (12, 5, 1);
insert into orders (student_id, reward_id, order_status_id) values (15, 4, 2);

