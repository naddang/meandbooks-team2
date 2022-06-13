create table no_mem_orders
(
    ORDERS_NO      varchar(10)      not null
        primary key,
    BOOK_NO        varchar(8)       not null,
    ORDERS_NM      varchar(15)      not null,
    ORDERS_PHONENO varchar(11)      not null,
    ORDERS_ADDR1   varchar(300)     not null,
    ORDERS_ADDR2   varchar(300)     not null,
    ORDERS_ADDR3   varchar(300)     not null,
    ORDERS_DATE    datetime         not null,
    ORDERS_QTY     smallint         not null,
    ORDERS_STATUS  char default '1' null,
    constraint FK_BOOK_TO_NO_MEM_ORDER_1
        foreign key (BOOK_NO) references book (BOOK_NO)
            on delete cascade
)
    charset = utf8;

