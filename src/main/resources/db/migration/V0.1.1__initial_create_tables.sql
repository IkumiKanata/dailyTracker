CREATE TABLE user
(
    user_id  INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE habit
(
    habit_id   INT AUTO_INCREMENT PRIMARY KEY,
    user_id    INT          NOT NULL,
    habit_name VARCHAR(255) NOT NULL,
    frequency  VARCHAR(50)  NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (user_id)
);

CREATE TABLE habit_completion
(
    completion_id  INT AUTO_INCREMENT PRIMARY KEY,
    habit_id       INT  NOT NULL,
    user_id        INT  NOT NULL,
    date_completed DATE NOT NULL,
    FOREIGN KEY (habit_id) REFERENCES habit (habit_id),
    FOREIGN KEY (user_id) REFERENCES user (user_id),
    UNIQUE (habit_id, date_completed)
);

