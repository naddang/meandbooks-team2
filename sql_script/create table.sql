drop database meandbooks;
create database meandbooks;
use meandbooks;

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
    charset = utf8;
INSERT INTO meandbooks.member (MEM_NO, MEM_UID, MEM_PWD, MEM_NM, MEM_PHONENO, MEM_ADDR1, MEM_ADDR2, MEM_ADDR3, MEM_EMAIL, MEM_MILEAGE, IS_ADMIN, `ACCESSIBLE`) VALUES (12, 'normalmember', '123123', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', 'test1@test.com', 36540, '0', '1');
INSERT INTO meandbooks.member (MEM_NO, MEM_UID, MEM_PWD, MEM_NM, MEM_PHONENO, MEM_ADDR1, MEM_ADDR2, MEM_ADDR3, MEM_EMAIL, MEM_MILEAGE, IS_ADMIN, `ACCESSIBLE`) VALUES (13, 'admin', '1234', '관리자', '01098765432', '63308', '제주특별자치도 제주시 구릉동산길 29', '관리자네집', 'admin@meandbooks.com', 0, '1', '1');
create table book
(
    BOOK_NO       varchar(8)    not null
        primary key,
    BOOK_NM       varchar(100)  not null,
    BOOK_DESC     varchar(3000) not null,
    BOOK_PRICE    mediumint     not null,
    BOOK_STOCK    smallint      not null,
    BOOK_IMG      varchar(1000) null,
    BOOK_PUB      varchar(60)   not null,
    BOOK_AUTHOR   varchar(60)   not null,
    BOOK_PUB_DATE date          not null,
    BOOK_ISBN     varchar(20)   null,
    BOOK_PAGE     smallint      null,
    constraint BOOK_ISBN
        unique (BOOK_ISBN)
)
    charset = utf8;
INSERT INTO meandbooks.book (BOOK_NO, BOOK_NM, BOOK_DESC, BOOK_PRICE, BOOK_STOCK, BOOK_IMG, BOOK_PUB, BOOK_AUTHOR, BOOK_PUB_DATE, BOOK_ISBN, BOOK_PAGE) VALUES ('1110001', '아노말리', '파리-뉴욕 간 여객기가 석 달이라는 시간 차를 두고 도플갱어처럼 똑같은 사람들을 싣고 동일 지점에서 난기류를 겪은 전대미문의 사건을 그린 2020년 공쿠르상 수상작 『아노말리』가 민음사에서 출간되었다. ‘아노말리’는 ‘이상’, ‘변칙’이라는 뜻으로, 주로 기상학이나 데이터 과학에서 ‘이상 현상’, ‘차이 값’이라는 의미로 쓰인다. 『아노말리』는 예년처럼 11월 첫 주 파리 드루앙 레스토랑에서 공쿠르상 수상작으로 발표되지 못했다. 코비드19로 인한 록다운 때문에 영업이 불가해진 동네 서점들에 연대하는 뜻으로 발표가 유예된 것이다. 공쿠르상은 상금이 10유로밖에 안 되지만 수상작이 되면 날개 돋친 듯이 팔리기 때문에, 공쿠르 시즌은 프랑스 서점가의 대목이다. 에르베 르 텔리에는 예년보다 석 주 늦게, 거리 두기 방침에 따라 온라인 줌으로 수상자의 영예를 안았다. 1991년부터 단편, 장편, 희곡, 시 등 장르를 넘나들며 작품을 쓰고, 수학자, 언어학자, 과학 기자, 만평가, 라디오 프로그램 고정 출연자 등 다방면으로 활동해 온 작가의 여덟 번째 장편소설에 주어진 상이었다.', 16200, 100, '아노말리.jpg', '민음사', '에르베 르 텔리에', '2022-05-26', '8937427222', 480);
INSERT INTO meandbooks.book (BOOK_NO, BOOK_NM, BOOK_DESC, BOOK_PRICE, BOOK_STOCK, BOOK_IMG, BOOK_PUB, BOOK_AUTHOR, BOOK_PUB_DATE, BOOK_ISBN, BOOK_PAGE) VALUES ('1110002', '당신은 결국 무엇이든 해내는 사람', '흔들리고 떠밀리고 넘어져도 나는, 당신은, 우리는
결국 해낼 것이라는 믿음의 문장들
『내가 죽으면 장례식에 누가 와줄까』를 통해 수많은 독자의 사랑을 받은 김상현 작가의 신작이 3년 만에 출간되었다. 전작을 통해 인간관계와 행복에 대해 따뜻한 시선과 위로의 문장을 전했다면, 신작 『당신은 결국 무엇이든 해내는 사람』은 더 나아가 나 자신을 제대로 바라볼 수 있는 힘을, 수많은 시행착오에도 불구하고 우리는 무엇이든 이루어낼 수 있는 사람임을, 희망과 믿음의 문장들로 담아냈다.

1장 ‘삶에 아무것도 남지 않은 것만 같을 때’에서는 좌절하고 무기력해지는 불안한 날들 속에서도 결국 나만의 속도를 찾아가는 과정을 담고 있으며, 2장 ‘불안하지 않다면 어떠한 고민도 없다는 거니까’에서는 불안하다는 것은 결국 지금보다 더 나은 방향으로 나아가고자 것임을 긍정적인 다짐과 자세를 통해 이야기하고 있다. 마지막으로 3장 ‘무엇이 되더라도 무엇을 하더라도’에서는 그 어떤 길이라도 멈춰있지만 않으면 언젠가는 반드시 원하는 목적지에 도착할 것이라는 위로와 함께 결국 우리는 무엇이든 해낼 수 있는 사람이라는 희망을 전하고 있다. 삶에 아무 것도 남지 않은 것만 같을 때, 무엇을 해야 할지 알 수 없어 막막할 때, 이 책이 당신을 한 걸음 더 나아가게 하는 희망의 메시지가 되어 줄 것이다.', 13500, 50, 'l9788960907423.jpg', '필름', '김상현', '2022-04-20', '1188469991', 208);
INSERT INTO meandbooks.book (BOOK_NO, BOOK_NM, BOOK_DESC, BOOK_PRICE, BOOK_STOCK, BOOK_IMG, BOOK_PUB, BOOK_AUTHOR, BOOK_PUB_DATE, BOOK_ISBN, BOOK_PAGE) VALUES ('1110003', '어금니 깨물기', '『마음사전』 『한 글자 사전』의 김소연 시인 신작 산문 어금니를 깨물며 타인과 일상을 버티는 힘과 사랑에 대하여', 13050, 300, 'l9791188469994.jpg', '마음산책', '김소연', '2022-06-05', '8960907421', 228);
INSERT INTO meandbooks.book (BOOK_NO, BOOK_NM, BOOK_DESC, BOOK_PRICE, BOOK_STOCK, BOOK_IMG, BOOK_PUB, BOOK_AUTHOR, BOOK_PUB_DATE, BOOK_ISBN, BOOK_PAGE) VALUES ('1110004', '결제 테스트용 도서', '결제 테스트용 도서 입니다', 100, 6953, 'bono.jpg', '테스트', '테스트', '2022-06-13', '123', 1);
INSERT INTO meandbooks.book (BOOK_NO, BOOK_NM, BOOK_DESC, BOOK_PRICE, BOOK_STOCK, BOOK_IMG, BOOK_PUB, BOOK_AUTHOR, BOOK_PUB_DATE, BOOK_ISBN, BOOK_PAGE) VALUES ('1110005', '재고없을때 결제불가 테스트', '재고없을때 결제불가 테스트용 도서입니다.', 100, 0, 'bono.jpg', '테스트', '테스트', '2022-05-04', '56431', 1);
INSERT INTO meandbooks.book (BOOK_NO, BOOK_NM, BOOK_DESC, BOOK_PRICE, BOOK_STOCK, BOOK_IMG, BOOK_PUB, BOOK_AUTHOR, BOOK_PUB_DATE, BOOK_ISBN, BOOK_PAGE) VALUES ('1220001', '어른의 시간', '“조금씩 더 나아질 때 우리는 어른이 된다”

20살이 넘으면 어른인 걸까? 처음부터 ''어른스러운 어른''은 없다. 계속 새로운 상황에 놓이면서 불확실성에 익숙해질 때, 완벽하지 않지만 조금씩 나아갈 때, 온전한 자기자신으로의 어른이 될 수 있다고 저자는 약속한다. 전 스탠퍼드대 신입생학부 학장인 저자가 수백명의 20대를 만나 ''어른의 시간''을 거치는 과정을 인생 수업처럼 담았다. 각자의 성장통으로 힘든 날들에 가이드가 될 것이다.', 16200, 10, 'adulttime.jpg', '온워드', '줄리 리스콧-헤임스', '2022-06-01', '1168982529', 400);
INSERT INTO meandbooks.book (BOOK_NO, BOOK_NM, BOOK_DESC, BOOK_PRICE, BOOK_STOCK, BOOK_IMG, BOOK_PUB, BOOK_AUTHOR, BOOK_PUB_DATE, BOOK_ISBN, BOOK_PAGE) VALUES ('1220002', '신녀성의 레미장센', '대한민국에서 가장 핫한 자기관리 컨설턴트 신녀성이 말하는
인생의 만족도를 최상위 레벨로 바꾼 여자들의 비밀

“당당하게 욕망하고 우아하게 쟁취하라.
당신의 삶은 더욱 풍요롭고, 건강하고, 새로워질 수 있다.”', 15300, 20, 'l9791158512446.jpg', '토네이도', '안상아', '2022-06-22', '1158512449', 336);
INSERT INTO meandbooks.book (BOOK_NO, BOOK_NM, BOOK_DESC, BOOK_PRICE, BOOK_STOCK, BOOK_IMG, BOOK_PUB, BOOK_AUTHOR, BOOK_PUB_DATE, BOOK_ISBN, BOOK_PAGE) VALUES ('1220003', '더 버는 내가 되는 법', '외모도, 능력도 심지어 이름마저 평범하고,
자신감은커녕 겸손과 쭈글 그 중간 어디쯤에서
인싸도 아싸도 아닌 그럴싸한 나는 무엇으로 더 벌 수 있을까?
', 12600, 100, null, '북스톤', '김짠부', '2022-05-10', '1191211665', 224);
create table faq
(
    FAQ_NO      mediumint auto_increment
        primary key,
    FAQ_CATE    char          not null,
    FAQ_TITLE   varchar(100)  not null,
    FAQ_CONTENT varchar(3000) not null
)
    charset = utf8
    auto_increment = 3;

INSERT INTO meandbooks.faq (FAQ_NO, FAQ_CATE, FAQ_TITLE, FAQ_CONTENT) VALUES (3, '1', '반품교환문의 테스트입니다', '반품교환문의 테스트입니다반품교환문의 테스트입니다반품교환문의 테스트입니다반품교환문의 테스트입니다반품교환문의 테스트입니다
반품교환문의 테스트입니다반품교환문의 테스트입니다
반품교환문의 테스트입니다반품교환문의 테스트입니다');
INSERT INTO meandbooks.faq (FAQ_NO, FAQ_CATE, FAQ_TITLE, FAQ_CONTENT) VALUES (4, '2', '결제문의 테스트입니다', '결제문의 테스트입니다결제문의 테스트입니다결제문의 테스트입니다결제문의 테스트입니다결제문의 테스트입니다결제문의 테스트입니다결제문의 테스트입니다결제문의 테스트입니다결제문의 테스트입니다결제문의 테스트입니다결제문의 테스트입니다결제문의 테스트입니다결제문의 테스트입니다');
INSERT INTO meandbooks.faq (FAQ_NO, FAQ_CATE, FAQ_TITLE, FAQ_CONTENT) VALUES (5, '3', '상품문의 테스트입니다', '상품문의 테스트입니다상품문의 테스트입니다상품문의 테스트입니다상품문의 테스트입니다상품문의 테스트입니다상품문의 테스트입니다상품문의 테스트입니다상품문의 테스트입니다상품문의 테스트입니다상품문의 테스트입니다상품문의 테스트입니다');
INSERT INTO meandbooks.faq (FAQ_NO, FAQ_CATE, FAQ_TITLE, FAQ_CONTENT) VALUES (6, '4', '배송문의 테스트입니다', '배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다배송문의 테스트입니다');
INSERT INTO meandbooks.faq (FAQ_NO, FAQ_CATE, FAQ_TITLE, FAQ_CONTENT) VALUES (7, '5', '개인정보문의 테스트입니다', '개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다개인정보문의 테스트입니다');
INSERT INTO meandbooks.faq (FAQ_NO, FAQ_CATE, FAQ_TITLE, FAQ_CONTENT) VALUES (8, '6', '기타문의 테스트입니다', '기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다기타문의 테스트입니다');

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

create table orders
(
    ORDERS_NO      varchar(10)      not null
        primary key,
    MEM_NO         mediumint        not null,
    BOOK_NO        varchar(8)       not null,
    ORDERS_NM      varchar(15)      not null,
    ORDERS_PHONENO varchar(11)      not null,
    ORDERS_ADDR1   varchar(300)     not null,
    ORDERS_ADDR2   varchar(300)     not null,
    ORDERS_ADDR3   varchar(300)     not null,
    ORDERS_DATE    datetime         not null,
    ORDERS_QTY     smallint         not null,
    ORDERS_STATUS  char default '1' null,
    constraint FK_BOOK_TO_ORDERS_1
        foreign key (BOOK_NO) references book (BOOK_NO)
            on delete cascade,
    constraint FK_MEMBER_TO_ORDERS_1
        foreign key (MEM_NO) references member (MEM_NO)
            on delete cascade
)
    charset = utf8;

INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130001', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 15:22:42', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130002', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 15:26:39', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130003', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:31', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130004', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:31', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130005', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:31', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130006', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:31', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130007', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:32', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130008', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:32', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130009', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:32', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130010', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:32', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130011', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:32', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130012', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:32', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130013', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:32', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130014', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:32', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130015', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:32', 1, '1');
INSERT INTO meandbooks.orders (ORDERS_NO, MEM_NO, BOOK_NO, ORDERS_NM, ORDERS_PHONENO, ORDERS_ADDR1, ORDERS_ADDR2, ORDERS_ADDR3, ORDERS_DATE, ORDERS_QTY, ORDERS_STATUS) VALUES ('2206130016', 12, '1110004', '김평범', '01012345678', '13536', '경기 성남시 분당구 판교역로28번길 3-2', '테스트입니다', '2022-06-13 16:19:32', 1, '1');

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
    charset = utf8;
    
INSERT INTO meandbooks.review (REV_NO, MEM_NO, BOOK_NO, REV_TITLE, REV_CONTENT, REV_RATING, REV_DATE) VALUES (7, 12, '1110004', 'asda', 'asdsa', 3, '2022-06-13 16:31:39');
INSERT INTO meandbooks.review (REV_NO, MEM_NO, BOOK_NO, REV_TITLE, REV_CONTENT, REV_RATING, REV_DATE) VALUES (8, 12, '1110004', 'afddfd', 'faadsf', 3, '2022-06-13 16:31:51');
INSERT INTO meandbooks.review (REV_NO, MEM_NO, BOOK_NO, REV_TITLE, REV_CONTENT, REV_RATING, REV_DATE) VALUES (9, 12, '1110004', 'dafsaf', 'sdagasdg', 3, '2022-06-13 16:31:55');
INSERT INTO meandbooks.review (REV_NO, MEM_NO, BOOK_NO, REV_TITLE, REV_CONTENT, REV_RATING, REV_DATE) VALUES (10, 12, '1110004', '테스트리뷰1', '테스트리뷰1테스트리뷰1테스트리뷰1', 3, '2022-06-13 16:32:08');
INSERT INTO meandbooks.review (REV_NO, MEM_NO, BOOK_NO, REV_TITLE, REV_CONTENT, REV_RATING, REV_DATE) VALUES (11, 12, '1110004', '테스트리뷰2', '테스트리뷰2테스트리뷰2테스트리뷰2테스트리뷰2', 3, '2022-06-13 16:33:05');
INSERT INTO meandbooks.review (REV_NO, MEM_NO, BOOK_NO, REV_TITLE, REV_CONTENT, REV_RATING, REV_DATE) VALUES (12, 12, '1110004', '테스트리뷰3', '테스트리뷰2테스트리뷰2테스트리뷰2', 3, '2022-06-13 16:33:08');
INSERT INTO meandbooks.review (REV_NO, MEM_NO, BOOK_NO, REV_TITLE, REV_CONTENT, REV_RATING, REV_DATE) VALUES (13, 12, '1110004', '테스트리뷰4', '테스트리뷰2테스트리뷰2테스트리뷰2', 5, '2022-06-13 16:33:13');
INSERT INTO meandbooks.review (REV_NO, MEM_NO, BOOK_NO, REV_TITLE, REV_CONTENT, REV_RATING, REV_DATE) VALUES (14, 12, '1110004', '테스트리뷰5', '테스트리뷰5테스트리뷰5테스트리뷰5테스트리뷰5', 3, '2022-06-13 16:33:20');

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
    charset = utf8;

INSERT INTO meandbooks.rev_cmt (CMT_NO, REV_NO, MEM_NO, CMT_CONTENT, CMT_DATE) VALUES (27, 7, 12, 'asdsa', '2022-06-13 16:31:43');
INSERT INTO meandbooks.rev_cmt (CMT_NO, REV_NO, MEM_NO, CMT_CONTENT, CMT_DATE) VALUES (28, 7, 12, 'fff', '2022-06-13 16:31:45');
INSERT INTO meandbooks.rev_cmt (CMT_NO, REV_NO, MEM_NO, CMT_CONTENT, CMT_DATE) VALUES (29, 14, 12, '테스트댓글1', '2022-06-13 16:33:27');
INSERT INTO meandbooks.rev_cmt (CMT_NO, REV_NO, MEM_NO, CMT_CONTENT, CMT_DATE) VALUES (30, 14, 12, '테스트댓글2', '2022-06-13 16:33:30');
INSERT INTO meandbooks.rev_cmt (CMT_NO, REV_NO, MEM_NO, CMT_CONTENT, CMT_DATE) VALUES (31, 14, 12, '테스트댓글3', '2022-06-13 16:33:33');
INSERT INTO meandbooks.rev_cmt (CMT_NO, REV_NO, MEM_NO, CMT_CONTENT, CMT_DATE) VALUES (32, 13, 12, 'ㅁㄴㅇㅁㅇ', '2022-06-13 16:34:17');
INSERT INTO meandbooks.rev_cmt (CMT_NO, REV_NO, MEM_NO, CMT_CONTENT, CMT_DATE) VALUES (33, 13, 12, 'ㄴㅁㅇㅁㅇㄴ', '2022-06-13 16:34:19');
INSERT INTO meandbooks.rev_cmt (CMT_NO, REV_NO, MEM_NO, CMT_CONTENT, CMT_DATE) VALUES (34, 11, 12, 'ㅁㄴㅇㅁㅇ', '2022-06-13 16:34:22');



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
