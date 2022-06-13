create table rev_cmt
(
    CMT_NO      mediumint auto_increment
        primary key,
    REV_NO      mediumint     not null,
    MEM_NO      mediumint     not null,
    CMT_CONTENT varchar(1000) not null,
    CMT_DATE    datetime      not null,
    constraint FK_MEMBER_TO_REV_CMT_1
        foreign key (MEM_NO) references member (MEM_NO)
            on delete cascade,
    constraint FK_REVIEW_TO_REV_CMT_1
        foreign key (REV_NO) references review (REV_NO)
            on delete cascade
)
    charset = utf8
    auto_increment = 27;

