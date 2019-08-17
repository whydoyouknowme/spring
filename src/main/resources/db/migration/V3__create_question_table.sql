CREATE TABLE question
(
    id int PRIMARY KEY AUTO_INCREMENT,
    title varchar(50),
    description text,
    gmt_create bigint,
    gmt_modified bigint,
    tag varchar(256),
    creator int,
    comment_count int DEFAULT 0,
    view_count int DEFAULT 0,
    like_count int DEFAULT 0
);