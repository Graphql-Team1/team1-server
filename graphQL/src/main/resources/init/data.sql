-- Insert dummy data into member table
INSERT INTO member (username, profile_img, follower, following, post_count) VALUES
                                                                                ('user1', 'profile1.jpg', 100, 50, 20),
                                                                                ('user2', 'profile2.jpg', 80, 30, 15),
                                                                                ('user3', 'profile3.jpg', 120, 70, 25),
                                                                                ('user4', 'profile4.jpg', 90, 40, 18);

-- Insert dummy data into follow table
INSERT INTO follow (follower_id, following_id) VALUES
                                                   (1, 2),
                                                   (1, 3),
                                                   (2, 1),
                                                   (3, 1),
                                                   (4, 1),
                                                   (4, 2);