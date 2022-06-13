create table qna_a
(
    A_NO      mediumint auto_increment
        primary key,
    Q_NO      mediumint     not null,
    MEM_NO    mediumint     not null,
    A_CONTENT varchar(3000) not null,
    A_DATE    datetime      not null,
    constraint FK_MEMBER_TO_QNA_A_1
        foreign key (MEM_NO) references member (MEM_NO)
            on delete cascade,
    constraint FK_QNA_TO_QNA_A_1
        foreign key (Q_NO) references qna_q (Q_NO)
            on delete cascade
)
    charset = utf8
    auto_increment = 3;

INSERT INTO meandbooks.qna_a (A_NO, Q_NO, MEM_NO, A_CONTENT, A_DATE) VALUES (3, 5, 12, '문의답변입니다..', '2022-06-13 15:04:25');
INSERT INTO meandbooks.qna_a (A_NO, Q_NO, MEM_NO, A_CONTENT, A_DATE) VALUES (4, 3, 12, '문의답변입니다..', '2022-06-13 15:04:29');
