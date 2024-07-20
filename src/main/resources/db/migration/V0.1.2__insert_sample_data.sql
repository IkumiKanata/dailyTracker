-- ユーザーの追加
INSERT INTO user (username, email, password) VALUES
                                                 ('user1', 'user1@example.com', 'password123'),
                                                 ('user2', 'user2@example.com', 'password456'),
                                                 ('user3', 'user3@example.com', 'password789');

-- 習慣の追加
INSERT INTO habit (user_id, habit_name, frequency) VALUES
                                                       (1, 'ランニング', '毎日'),
                                                       (1, '読書', '週5回'),
                                                       (2, '瞑想', '毎日'),
                                                       (3, 'ジョギング', '週3回');

-- 習慣の完了記録の追加
INSERT INTO habit_completion (habit_id, user_id, date_completed) VALUES
                                                                     (1, 1, '2024-07-01'),
                                                                     (2, 1, '2024-07-02'),
                                                                     (1, 1, '2024-07-03'),
                                                                     (3, 2, '2024-07-01'),
                                                                     (4, 3, '2024-07-02');
