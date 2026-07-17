--데이터조작어. DML 
-- 삭제,수정,삽입,조회  /  deletefrom , update, insert, select.
--sql에서는 (null)은 공백을 의미함.  진짜 null과는 상이함.

--삭제
DELETE from member_권구봉
where age >24 ;


rollback;
commit;

--수정
update member_권구봉
set area ='대구'
where area = '대전'
and age >= 25;


--여러데이터를수정할때
update member_권구봉
set name = '트럼프',
    area = '뉴욕'
where id = '201';


update member_권구봉
set name = '김부산',
    area = '부산',
    age = 7
where id = '201';




commit;



--정렬조회
--기본 1234오름차순/  desc 붙이면 내림차순 / a,b 라면 a먼저 정렬 후 같은 a중에 b 정렬.
SELECT id,name,area,age
from member_홍길동
order by area desc, name;


--전체조회
SELECT id,name,area,age
from member_홍길동;


--조건조회
SELECT id,name,area,age
FROM "MEMBER_홍길동"
where age>10
and area = '서울';


SELECT id,name,area,age 
from member_홍길동
where area = '대전'
and age>=20
and age<27;

--인서트한후엔 반드시. 롤백or커밋해야함.
ROLLBACK;

COMMIT;
--지금상태로확정. 롤백시에도 보존됨.


insert into member_권구봉
(id,name,area,age)
values
('401','이길동','대전',25);

insert into member_권구봉
(id,name,area,age)
values
('501','치길동','대전',25);


insert into member_권구봉
(id,name,area,age)
VALUES
('601','육공일','',30);

insert into member_권구봉
(id,name,area)
values
('701','김잡김','집');

--모든컬럼에값을넣을거면 타입을안써도됨
insert into member_권구봉
values
('801','길길길','대전',3);

insert into "MEMBER_권구봉"
values
('901','구길동','부산',29);




drop table member_권구봉;

create table member_권구봉(
    id varchar2(3) not null PRIMARY KEY,
    name varchar2(10) not null,
    area varchar2(10),
    age number(3) default 0   
);


CREATE TABLE news_권구봉(
    no varchar2(5) not null,
    title varchar2(100) not null,
    content varchar2(500) not null,
    hit NUMBER(4) default 0,
    reg_date DATE not null
);


