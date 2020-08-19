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