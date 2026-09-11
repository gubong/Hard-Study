/***********notice************/
--다음글
select a.nextNo, b.title
from(
    select min(no) as nextNo 
    from jsl_권구봉_notice a
    where no > 'N005'
    )a, jsl_권구봉_notice b
where a.nextNo = b.no;

--이전글
select a.preNo, b.title
from(
    select max(no) as preNo 
    from jsl_권구봉_notice a
    where no < 'N005'
    )a, jsl_권구봉_notice b
where a.preNo = b.no;



--히트증가
update jsl_권구봉_notice
set hit = hit +1
where no = 'N001';

rollback;

select n.no,n.title,n.content,n.attach,
        m.name as reg_name, n.hit, to_char(n.reg_date,'yyyy-MM-dd') as reg_date
from jsl_권구봉_notice n, jsl_홍길동_member m
where n.reg_id = m.id
and n.no = 'N004';



select * from(
    select rownum as rnum, tbl.* 
    from (
        select n.no,n.title,m.name, to_char(n.reg_date,'yy/MM/dd') as reg_date, n.hit
        from jsl_권구봉_news n,jsl_권구봉_member m
        where n.reg_id = m.id
        and n.title like '%%'
        order by n.no desc
    ) tbl)
where rnum >=5 and rnum<=8;


------목록조회---------
select * from(
    select rownum as rnum, tbl.* 
     from (
        select * from(
        select rownum as rnum, tbl.* 
        from (
            select count(*) as count
            from jsl_권구봉_notice
            where title like '%%'; 
    ) tbl)
where rnum >=5 and rnum<=8;

------목록조회--------

select * from(
    select rownum as rnum, tbl.* 
    from (
        select n.no,n.title,n.attach,m.name as reg_name,
                to_char(n.reg_date,'yyyy-MM-dd') as reg_date,
                n.hit
        from jsl_권구봉_notice n,jsl_권구봉_member m
        where n.reg_id = m.id
        and title like '%%'
        order by n.no desc
    ) tbl)
where rnum >=5 and rnum<=9;


-----등롥-----
insert into jsl_권구봉_notice
(no,title,content,attach,reg_id,reg_date)
values
('N001','a','a','a','manager','2026-05-05');

rollback;

--공지사항--
create table jsl_권구봉_notice(
    no varchar2(4) not null primary key,
    title varchar2(100) not null,
    content varchar2(2000) not null,
    attach varchar2(100),
    hit number(3) default 0,
    reg_id varchar2(20) not null,
    reg_date date not null
);




/**************news*******************/
delete from jsl_권구봉_news
where no = 'N003';

--N005라고 치면 4,6번 조회해오기  다음글.
update jsl_권구봉_news
set title = 'a',
    content = 'a',
    reg_date = '2026-09-09'
where no = 'N003';

rollback;

select a.no,title
from(
    select min(no) as no 
    from jsl_권구봉_news
    where no > 'N007'
)a,jsl_권구봉_news b
where a.no = b.no;

--이전글
select a.no,title
from(
    select max(no) as no 
    from jsl_권구봉_news
    where no < 'N007'
)a,jsl_권구봉_news b
where a.no = b.no;

update jsl_권구봉_news
set hit = hit + 1
where no = 'N003';

ROLLBACK;

select n.no,n.title,n.content,n.hit,n.reg_id,m.name as reg_name,
        to_char(n.reg_date,'yyyy-MM-dd') as reg_date
from jsl_권구봉_news n,jsl_권구봉_member m
where n.reg_id = m.id
and n.no='N003';

select COUNT(*) as count
from jsl_권구봉_news
where title like '%%';


select rownum, no,title
from jsl_홍길동_news;


select * from(
    select rownum as rnum, tbl.* 
    from (
        select n.no,n.title,m.name, to_char(n.reg_date,'yy/MM/dd') as reg_date, n.hit
        from jsl_권구봉_news n,jsl_권구봉_member m
        where n.reg_id = m.id
        and n.title like '%%'
        order by n.no desc
    ) tbl)
where rnum >=5 and rnum<=8;

insert into jsl_권구봉_news
(no,title,content,reg_id,reg_date)
values
('N004','a','a','manager','2026-09-02');

select max(no) as no
from jsl_권구봉_news;

delete from jsl_권구봉_news;

insert into jsl_권구봉_news
(no,title,content,reg_id,reg_date)
values
('N003','제목3','내용3','manager','2026-08-08');

commit;
rollback;

create table jsl_권구봉_news(
    no varchar2(4) not null primary key,
    title varchar2(100) not null,
    content varchar2(2000) not null,
    hit number(3) default 0,
    reg_id varchar2(20) not null,
    reg_date date not null
);



/*************************회원 member*****************************/
update jsl_권구봉_member
set password = '111'
where id = 'aaa';


update jsl_권구봉_member
    set  exit_date = to_date('2026-08-31 14:22:30' , 'yyyy-MM-dd hh24:mi:ss')
where id = 'aaa';

rollback;

update jsl_권구봉_member
set name = 'q',
    job = 'q',
    tell_1 = 'q',
    tell_2 = 'q',
    tell_3 = 'q',
    mobile_1 = 'q',
    mobile_2 = 'q',
    mobile_3 = 'q',
    email_1 = 'q',
    email_2 = 'q',
    update_date = to_date('2026-08-31 14:22:30' , 'yyyy-MM-dd hh24:mi:ss')
where id = 'aaa';

rollback;
    
select name
from  jsl_권구봉_member
where id = 'bbb'
and password='F6E0A1E2AC41945A9AA7FF8A8AAACEBC12A3BCC981A929AD5CF81A9E11AE'
and exit_date is null;


select id,name,password,job,nvl(tell_1,' '),nvl(tell_2,'-'),tell_3,
		mobile_1,mobile_2,mobile_3,
		email_1,email_2,
		reg_date,update_date,exit_date
from jsl_권구봉_member
where id  = 'fff';


create table jsl_권구봉(
    id varchar(20) not null primary key,
    name varchar(20) not null,
    password varchar(70) not null,
    job varchar(20) not null,
    tell_1 varchar(3),
    tell_2 varchar(4),
    tell_3 varchar(4),
    mobile_1 varchar(3) not null,
    mobile_2 varchar(4) not null,
    mobile_3 varchar(4) not null,
    email_1 varchar(20) not null,
    email_2 varchar(20) not null,
    reg_date date not null,
    update_date date,
    exit_date date
);



DELETE FROM student_권구봉
WHERE syear = '1'
and sclass = '1'
and sno = '1';

rollback;

update student_권구봉
set kor = '1',
    eng = '1',
    mat = '1'
where syear = '1'
and sclass = '1'
and sno = '1';

rollback;

drop table news_권구봉;

commit;

insert into member_홍길동
(id,name,area,age)
values
('888','홍길자','대전',25);

update member_권구봉
set name = '보보봉',
    area = '대전',
    age = 25
where id = '101';







CREATE TABLE news_권구봉(
    no varchar2(5) not null,
    title varchar2(100) not null,
    content varchar2(500) not null,
    hit NUMBER(4) default 0,
    reg_date DATE not null
);

select id,name,area,age
from member_홍길동
where name like '%동%'
order by id;




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


