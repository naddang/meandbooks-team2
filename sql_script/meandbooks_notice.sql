create table notice
(
    NOTI_NO      mediumint auto_increment
        primary key,
    NOTI_TITLE   varchar(100)  not null,
    NOTI_CONTENT varchar(3000) not null,
    NOTI_DATE    datetime      not null
)
    charset = utf8
    auto_increment = 5;

INSERT INTO meandbooks.notice (NOTI_NO, NOTI_TITLE, NOTI_CONTENT, NOTI_DATE) VALUES (5, '테스트1', '테스트입니다
테스트입니다
테스트입니다
테스트입니다
테스트입니다
', '2022-06-13 14:42:34');
INSERT INTO meandbooks.notice (NOTI_NO, NOTI_TITLE, NOTI_CONTENT, NOTI_DATE) VALUES (6, '테스트2', '테스트입니다
테스트입니다
테스트입니다
테스트입니다
테스트입니다
', '2022-06-13 14:42:42');
INSERT INTO meandbooks.notice (NOTI_NO, NOTI_TITLE, NOTI_CONTENT, NOTI_DATE) VALUES (7, '테스트3', '테스트입니다
테스트입니다
테스트입니다
테스트입니다
테스트입니다
', '2022-06-13 14:42:45');
INSERT INTO meandbooks.notice (NOTI_NO, NOTI_TITLE, NOTI_CONTENT, NOTI_DATE) VALUES (8, '테스트4', '테스트입니다
테스트입니다
테스트입니다
테스트입니다
테스트입니다
', '2022-06-13 14:42:48');
INSERT INTO meandbooks.notice (NOTI_NO, NOTI_TITLE, NOTI_CONTENT, NOTI_DATE) VALUES (9, '테스트5', '테스트입니다
테스트입니다
테스트입니다
테스트입니다
테스트입니다
', '2022-06-13 14:42:51');
INSERT INTO meandbooks.notice (NOTI_NO, NOTI_TITLE, NOTI_CONTENT, NOTI_DATE) VALUES (10, '테스트6', '테스트입니다
테스트입니다
테스트입니다
테스트입니다
테스트입니다
', '2022-06-13 14:42:55');
INSERT INTO meandbooks.notice (NOTI_NO, NOTI_TITLE, NOTI_CONTENT, NOTI_DATE) VALUES (11, '테스트7', '테스트입니다
테스트입니다
테스트입니다
테스트입니다
테스트입니다
', '2022-06-13 14:43:00');
INSERT INTO meandbooks.notice (NOTI_NO, NOTI_TITLE, NOTI_CONTENT, NOTI_DATE) VALUES (12, '테스트8', '테스트입니다
테스트입니다
테스트입니다
테스트입니다
테스트입니다
', '2022-06-13 14:43:03');
INSERT INTO meandbooks.notice (NOTI_NO, NOTI_TITLE, NOTI_CONTENT, NOTI_DATE) VALUES (13, '테스트9', '테스트입니다
테스트입니다
테스트입니다
테스트입니다
테스트입니다
', '2022-06-13 14:43:07');
INSERT INTO meandbooks.notice (NOTI_NO, NOTI_TITLE, NOTI_CONTENT, NOTI_DATE) VALUES (14, '테스트10', '테스트입니다
테스트입니다
테스트입니다
테스트입니다
테스트입니다
', '2022-06-13 14:43:11');
INSERT INTO meandbooks.notice (NOTI_NO, NOTI_TITLE, NOTI_CONTENT, NOTI_DATE) VALUES (15, '테스트11', '테스트입니다
테스트입니다
테스트입니다
테스트입니다
테스트입니다
', '2022-06-13 14:43:15');
