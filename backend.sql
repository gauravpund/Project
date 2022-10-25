SELECT * FROM atm.atmmachine;


CREATE TABLE `atmmachine` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `balance` float DEFAULT NULL,
  `transaction` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



+------------+----------+---------+-------------+
| username   | password | balance | transaction |
+------------+----------+---------+-------------+
| pundgaurav | Gaurav   |     500 |        5000 |
| NULL       | NULL     |    NULL |         500 |
| NULL       | NULL     |    NULL |        55.5 |
| NULL       | NULL     |    NULL |        -587 |
| NULL       | NULL     |    NULL |         500 |
+------------+----------+---------+-------------+