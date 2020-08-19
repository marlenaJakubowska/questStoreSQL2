SELECT "role", count (*) AS total
FROM users INNER JOIN "role" on users.role_id = "role".id
GROUP BY "role"
ORDER BY "total" ASC;

SELECT "role", count(*), CAST((ROUND(count(role_id) * 100/ (SELECT COUNT("role") FROM users INNER JOIN "role" on users.role_id = "role".id))) AS varchar(100)) || '%' AS percentages
FROM users INNER JOIN "role" on users.role_id = "role".id
GROUP BY "role"
ORDER BY "count" ASC;
