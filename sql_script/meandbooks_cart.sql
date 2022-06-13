create table cart
(
    CART_NO  varchar(10) not null
        primary key,
    MEM_NO   mediumint   not null,
    BOOK_NO  varchar(8)  not null,
    CART_QTY smallint    not null,
    constraint FK_BOOK_TO_CART_1
        foreign key (BOOK_NO) references book (BOOK_NO)
            on delete cascade,
    constraint FK_MEMBER_TO_CART_1
        foreign key (MEM_NO) references member (MEM_NO)
            on delete cascade
)
    charset = utf8;

INSERT INTO meandbooks.cart (CART_NO, MEM_NO, BOOK_NO, CART_QTY) VALUES ('2206130001', 12, '1110004', 1);
INSERT INTO meandbooks.cart (CART_NO, MEM_NO, BOOK_NO, CART_QTY) VALUES ('2206130002', 12, '1110004', 1);
INSERT INTO meandbooks.cart (CART_NO, MEM_NO, BOOK_NO, CART_QTY) VALUES ('2206130003', 12, '1110004', 4);
INSERT INTO meandbooks.cart (CART_NO, MEM_NO, BOOK_NO, CART_QTY) VALUES ('2206130004', 12, '1110004', 1);
INSERT INTO meandbooks.cart (CART_NO, MEM_NO, BOOK_NO, CART_QTY) VALUES ('2206130005', 12, '1110004', 1);
