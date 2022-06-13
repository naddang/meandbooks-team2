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
