create table users (
   username varchar2(50) not null primary key,
   password varchar2(50) not null,
   enabled char(1) default '1'
);

create table authorities (
   username varchar2(50) not null,
   authority varchar2(50) not null,
   constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username, authority);

insert into users (username, password) values('hong', '1111');
insert into users (username, password) values('test', '1111');
insert into users (username, password) values('admin', '1111');

insert into authorities(username, authority) values('hong', 'ROLE_MEMBER');
insert into authorities(username, authority) values('test', 'ROLE_MEMBER');
insert into authorities(username, authority) values('admin', 'ROLE_MEMBER');
insert into authorities(username, authority) values('admin', 'ROLE_ADMIN');

commit;


drop table tbl_member ;
drop table tbl_member_auth;
DROP TABLE tbl_member CASCADE CONSTRAINTS;

drop table tblmember CASCADE CONSTRAINTS;

-- 회원가입한 날짜 >>>> 이게 있어야 최근 가입한 회원 목록을 관리자가 조회한다. 
create table tbl_member (
   userid varchar2(50) not null primary key,
   userpw varchar2(100) not null,
   username varchar2(100) not null,
   regdate date default sysdate,
   updatedate date default sysdate,
   enabled char(1) default '1'
);

create table tbl_member_auth (
   userid varchar2(50) not null,
   auth varchar2(50) not null,
   constraint fk_member_auth foreign key(userid) references tbl_member(userid)
);


select * from tbl_member;
select * from tbl_member_auth;


select 
    m.userid,
    m.userpw,
    m.username,
    m.enabled,
    m.regdate,
    m.updatedate,
    a.auth
from tbl_member m 
    left outer join tbl_member_auth a 
        on m.userid = a.userid
            where m.userid = 'lion';
    
-- outer join을 썼다. 

create table persistent_logins (
   username varchar(64) not null,
   series varchar(64) primary key,
   token varchar(64) not null,
   last_used timestamp not null
);


select * from persistent_logins;


create table tblMember (
	id varchar2(30) not null primary key,
	name varchar2(30) not null,
	pw varchar2(65) not null,
	email varchar2(100) not null,
	gender char(1) not null,
	regdate date default sysdate not null,
	enabled char(1) default '1'
);

create table tblAuth(
	id varchar2(30) not null references tblMember(id),
	auth varchar2(50) not null
);


alter table tblMember modify (pw varchar2(65));

commit;

select * from tblMember;



select 
    m.id,
    pw,
    name,
    email,
    gender,
    regdate, enabled, auth
from tblMember m
    left outer join tblAuth a 
        on m.id = a.id
            where m.id='lion';

drop table tblBoard CASCADE CONSTRAINTS;

create table tblBoard;

create table tblBoard (
    seq number primary key,
    subject varchar2(1000) not null,
    content varchar2(2000) not null,
    regdate date default sysdate not null,
    id varchar2(30) not null references tblMember(id)
);

