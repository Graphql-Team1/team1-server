-- Drop tables if they exist
DROP TABLE IF EXISTS follow;
DROP TABLE IF EXISTS member;

-- Create member table
CREATE TABLE member (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        username VARCHAR(255) NOT NULL,
                        profile_img VARCHAR(255),
                        follower INT NOT NULL DEFAULT 0,
                        following INT NOT NULL DEFAULT 0,
                        post_count INT NOT NULL DEFAULT 0
);

-- Create follow table
CREATE TABLE follow (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        follower_id BIGINT NOT NULL,
                        following_id BIGINT NOT NULL,
                        CONSTRAINT fk_follower FOREIGN KEY (follower_id) REFERENCES member(id),
                        CONSTRAINT fk_following FOREIGN KEY (following_id) REFERENCES member(id)
);