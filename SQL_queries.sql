SELECT "role", count (*) AS total
FROM users INNER JOIN roles on users.role_id = roles.id
GROUP BY "role"
ORDER BY "total";


SELECT "role", count(*), CAST((ROUND(count(role_id) * 100/ (SELECT COUNT("role") FROM users INNER JOIN roles on users.role_id = roles.id))) AS varchar(100)) || '%' AS percentages
FROM users INNER JOIN roles on users.role_id = roles.id
GROUP BY "role"
ORDER BY "count" ASC;


SELECT roles.role,
    sum(case when users.isactive = TRUE then 1 else 0 end) AS active,
    sum(case when users.isactive = FALSE then 1 else 0 end) AS not_active,
	count(*) AS total
FROM users INNER JOIN roles on users.role_id = roles.id
GROUP BY role
ORDER BY role ASC;


SELECT modules.name, count (*) AS total
FROM students INNER JOIN modules on students.module_id = modules.id
GROUP BY modules.name
ORDER BY total ASC;







// task number 7
SELECT "status", COUNT(*) AS total, CAST((ROUND(count(quest_statuses.id) * 100/ (SELECT COUNT("status") FROM student_quests INNER JOIN quest_statuses on student_quests.quest_status_id = quest_statuses.id))) AS varchar(100)) || '%' AS percentages
FROM student_quests INNER JOIN quest_statuses on student_quests.quest_status_id = quest_statuses.id
GROUP BY "status";