create table review
(
    REV_NO      mediumint auto_increment
        primary key,
    MEM_NO      mediumint     not null,
    BOOK_NO     varchar(8)    not null,
    REV_TITLE   varchar(100)  not null,
    REV_CONTENT varchar(3000) not null,
    REV_RATING  tinyint       not null,
    REV_DATE    datetime      not null,
    constraint FK_BOOK_TO_REVIEW_1
        foreign key (BOOK_NO) references book (BOOK_NO)
            on delete cascade,
    constraint FK_MEMBER_TO_REVIEW_1
        foreign key (MEM_NO) references member (MEM_NO)
            on delete cascade
)
    charset = utf8
    auto_increment = 7;

