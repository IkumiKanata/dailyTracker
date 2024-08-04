INSERT INTO role (authority)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id)
VALUES (1, 1),
       (2, 1),
       (3, 2);
