create table qna_q
(
    Q_NO         mediumint auto_increment
        primary key,
    MEM_NO       mediumint     not null,
    Q_TITLE      varchar(100)  not null,
    Q_CONTENT    varchar(3000) not null,
    Q_DATE       datetime      not null,
    Q_PWD        varchar(20)   not null,
    Q_CATE       char          not null,
    ACCESS_LEVEL char          not null,
    constraint FK_MEMBER_TO_QNA_Q_1
        foreign key (MEM_NO) references member (MEM_NO)
            on delete cascade
)
    charset = utf8
    auto_increment = 3;

INSERT INTO meandbooks.qna_q (Q_NO, MEM_NO, Q_TITLE, Q_CONTENT, Q_DATE, Q_PWD, Q_CATE, ACCESS_LEVEL) VALUES (3, 12, '문의 테스트입니다', '문의 테스트입니다문의 테스트입니다문의 테스트입니다문의 테스트입니다문의 테스트입니다문의 테스트입니다', '2022-06-13 14:48:57', '0', '1', '1');
INSERT INTO meandbooks.qna_q (Q_NO, MEM_NO, Q_TITLE, Q_CONTENT, Q_DATE, Q_PWD, Q_CATE, ACCESS_LEVEL) VALUES (4, 12, '문의 테스트입니다2', '문의 테스트입니다2문의 테스트입니다2문의 테스트입니다2문의 테스트입니다2문의 테스트입니다2문의 테스트입니다2문의 테스트입니다2문의 테스트입니다2문의 테스트입니다2', '2022-06-13 14:49:06', '0', '1', '0');
INSERT INTO meandbooks.qna_q (Q_NO, MEM_NO, Q_TITLE, Q_CONTENT, Q_DATE, Q_PWD, Q_CATE, ACCESS_LEVEL) VALUES (5, 12, '문의 테스트입니다3', '문의 테스트입니다3문의 테스트입니다3문의 테스트입니다3문의 테스트입니다3문의 테스트입니다3문의 테스트입니다3문의 테스트입니다3문의 테스트입니다3문의 테스트입니다3문의 테스트입니다3', '2022-06-13 14:49:11', '0', '1', '1');
