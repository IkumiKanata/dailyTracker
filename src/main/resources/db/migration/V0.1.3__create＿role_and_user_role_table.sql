-- Role テーブルの作成
CREATE TABLE role
(
    role_id   INT AUTO_INCREMENT PRIMARY KEY,
    authority VARCHAR(255) NOT NULL
);



CREATE TABLE user_role
(
    user_id INT,
    role_id INT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES `user` (user_id),
    FOREIGN KEY (role_id) REFERENCES role (role_id)
);
