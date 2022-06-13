create table member
(
    MEM_NO       mediumint auto_increment
        primary key,
    MEM_UID      varchar(15)           not null,
    MEM_PWD      varchar(20)           not null,
    MEM_NM       varchar(15)           not null,
    MEM_PHONENO  varchar(11)           not null,
    MEM_ADDR1    varchar(300)          not null,
    MEM_ADDR2    varchar(300)          not null,
    MEM_ADDR3    varchar(300)          not null,
    MEM_EMAIL    varchar(50)           not null,
    MEM_MILEAGE  mediumint default 0   null,
    IS_ADMIN     char      default '0' null,
    `ACCESSIBLE` char      default '1' null,
    constraint MEM_EMAIL
        unique (MEM_EMAIL),
    constraint MEM_UID
        unique (MEM_UID)
)
    charset = utf8
    auto_increment = 12;

INSERT INTO meandbooks.member (MEM_NO, MEM_UID, MEM_PWD, MEM_NM, MEM_PHONENO, MEM_ADDR1, MEM_ADDR2, MEM_ADDR3, MEM_EMAIL, MEM_MILEAGE, IS_ADMIN, `ACCESSIBLE`) VALUES (12, 'normalmember', '123123', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', 'test1@test.com', 36540, '0', '1');
INSERT INTO meandbooks.member (MEM_NO, MEM_UID, MEM_PWD, MEM_NM, MEM_PHONENO, MEM_ADDR1, MEM_ADDR2, MEM_ADDR3, MEM_EMAIL, MEM_MILEAGE, IS_ADMIN, `ACCESSIBLE`) VALUES (13, 'admin', '1234', '관리자', '01098765432', '63308', '제주특별자치도 제주시 구릉동산길 29', '관리자네집', 'admin@meandbooks.com', 0, '1', '1');
