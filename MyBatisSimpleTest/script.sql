
drop table tblAddress;
drop sequence seqAddress;

create table tblAddress(
    seq number primary key,
    name varchar2(30) not null,
    age number(3) not null,
    address varchar2(300) not null
);

create sequence seqAddress;

create table tblEmail (
    seq number primary key,
    email varchar2(100) not null,
    pseq number not null references tblAddress(seq)
);

create sequence seqEmail;

select * from tblEmail;
select * from tblAddress;