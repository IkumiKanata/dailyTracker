INSERT INTO role (authority)
VALUES ('USER'),
       ('ADMIN');

INSERT INTO user_role (user_id, role_id)
VALUES (1, 1),
       (2, 1),
       (3, 2);
