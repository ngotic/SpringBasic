create table tblCode (
    seq number primary key,         -- 번호(PK)
    subject varchar2(500) not null, -- 제목
    code varchar2(2000) not null,   -- 코드 조각
    regdate date default sysdate not null, 
    language varchar2(50) not null  -- 언어종류
);

create sequence seqCode;

select * from tblCode;