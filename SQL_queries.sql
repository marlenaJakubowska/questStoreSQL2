--task number 1
SELECT "role", count (*) AS total
FROM users INNER JOIN roles on users.role_id = roles.id
GROUP BY "role"
ORDER BY "total";


--task number 2
SELECT "role", count(*), CAST((ROUND(count(role_id) * 100/ (SELECT COUNT("role") FROM users INNER JOIN roles on users.role_id = roles.id))) AS varchar(100)) || '%' AS percentages
FROM users INNER JOIN roles on users.role_id = roles.id
GROUP BY "role"
ORDER BY "count" ASC;


--task number 3
SELECT roles.role,
    sum(case when users.isactive = TRUE then 1 else 0 end) AS active,
    sum(case when users.isactive = FALSE then 1 else 0 end) AS not_active,
	count(*) AS total
FROM users INNER JOIN roles on users.role_id = roles.id
GROUP BY role
ORDER BY role ASC;


--task number 4
SELECT modules.name, count (*) AS total
FROM students INNER JOIN modules on students.module_id = modules.id
GROUP BY modules.name
ORDER BY total ASC;


-- task number 5
SELECT modules.name, count (students.module_id) AS total
FROM students
RIGHT JOIN modules on students.module_id = modules.id
GROUP BY modules.name
ORDER BY total DESC;


-- task number 6
SELECT modules.name, count (students.module_id) AS total,
CAST((ROUND(count(students.module_id) * 100/ (SELECT COUNT(students.id) FROM students))) AS varchar(100)) || ' %' AS percentages
FROM students
RIGHT JOIN modules on students.module_id = modules.id
GROUP BY modules.name
ORDER BY total DESC;


-- task number 7
SELECT "status", COUNT(*) AS total, CAST((ROUND(count(quest_statuses.id) * 100/ (SELECT COUNT("status") FROM student_quests INNER JOIN quest_statuses on student_quests.quest_status_id = quest_statuses.id))) AS varchar(100)) || '%' AS percentages
FROM student_quests INNER JOIN quest_statuses on student_quests.quest_status_id = quest_statuses.id
GROUP BY "status";


-- task number 8 Nazwa questa oraz liczba studentów którzy go ukończyli - top 3 najpopularniejszych skończonych questów, w kolejności od najpopularniejszego
SELECT quests.name, count(student_quests.quest_status_id) as total
FROM quests
INNER JOIN student_quests ON quests.id = student_quests.quest_id
INNER JOIN quest_statuses ON student_quests.quest_status_id = quest_statuses.id
WHERE quest_statuses.status='approved'
GROUP BY quests.name
ORDER BY total DESC LIMIT 3;


-- task 9 Nazwa questa oraz liczba studentów którzy go rozpoczeli i/lub ukończyli - top 3 najpopularniejszych rozpoczętych questów, w kolejności od najpopularniejszego
SELECT quests.name, count(student_quests.quest_status_id) as total
FROM quests
INNER JOIN student_quests ON quests.id = student_quests.quest_id
INNER JOIN quest_statuses ON student_quests.quest_status_id = quest_statuses.id
WHERE quest_statuses.status='approved' OR quest_statuses.status='in progres' OR quest_statuses.status='submitted'
GROUP BY quests.name
ORDER BY total DESC LIMIT 3;


-- task 10 Nazwisko i imię studenta oraz liczba ukończonych questów - top 5 studentów,
 w kolejności od studenta z największą liczbą ukończonych questówa następnie w kolajności alfabetycznej - TO IMPROVE

SELECT users.last_name, users.first_name, count(student_quests.id) as total
FROM users
INNER JOIN students ON users.id = students.user_id
INNER JOIN student_quests ON students.student_quest_id = student_quests.id
INNER JOIN quest_statuses ON student_quests.quest_status_id = quest_statuses.id
WHERE quest_statuses.status = 'approved'
GROUP BY users.last_name, users.first_name
ORDER BY total DESC LIMIT 5;


-- task number 13 Nazwisko i imię studenta oraz liczba zakupionych artefaktów - top 5 studentóœ, którzy kupili najwięcej artefaktów.
SELECT users.last_name, users.first_name, count(orders.student_id) as total
FROM users
INNER JOIN students ON users.id = students.user_id
INNER JOIN orders ON students.id = orders.student_id
GROUP BY users.last_name, users.first_name
ORDER BY total DESC LIMIT 5;


-- task number 14 Nazwizka i imiona studentów, którzy nie kupili żadnego artefaktu, w kolejności alfabetycznej.
SELECT users.last_name, users.first_name
FROM users
INNER JOIN students ON users.id = students.user_id
WHERE students.id NOT IN (SELECT student_id FROM orders)
ORDER BY last_name;


-- task 15 Nazwa kategorii, liczba artefaktóœ oraz % z całkowitej liczby artefaktóœ dla zadanych kategorii
select 'bought' as name, count(DISTINCT reward_id),
(count(DISTINCT reward_id)*100 / (SELECT count(*) from rewards)) || ' %' AS percentage
from orders
union
select 'never_bought' as name, count(id), (count(id)*100 / (SELECT count(*) from rewards)) || ' %' AS percentage
from rewards
WHERE rewards.id NOT IN (SELECT reward_id FROM orders);
