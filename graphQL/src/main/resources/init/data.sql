-- Insert dummy data into member table
INSERT INTO member (username, profile_img, follower, following, post_count) VALUES
                                                                                ('성은', 'profile1.jpg', 2, 3, 20),
                                                                                ('아름', 'profile2.jpg', 1, 2, 15),
                                                                                ('승연', 'profile3.jpg', 1, 1, 25),
                                                                                ('sopt', 'profile4.jpg', 2, 0, 18);

-- Insert dummy data into follow table
INSERT INTO follow (follower_id, following_id) VALUES
                                                   (1, 2),
                                                   (1, 3),
                                                   (2, 1),
                                                   (3, 1),
                                                   (4, 1),
                                                   (4, 2);