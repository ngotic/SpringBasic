create table tblMyBatis(
    seq number primary key,          -- 번호
    name varchar2(30) not null,      -- 이름
    age number not null,             -- 나이
    address varchar2(300) not null , -- 주소
    gender char(1) not null          -- 성별(m, f)
);

create sequence seqMyBatis;

insert into tblMyBatis(seq, name, age, address, gender )
        values(seqMyBatis.nextVal, '장보고', 25, '서울시 강서구', 'm');
        
commit;


select * from  tblMyBatis;

select seqMyBatis.nextVal from dual;

