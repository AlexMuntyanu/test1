CREATE TABLE NOTES (ID INT PRIMARY KEY ,NOTE_NAME VARCHAR (64), TEXT VARCHAR (64));

create table users(
  username VARCHAR(50) not null primary key,
  password VARCHAR(50) not null,
  enabled boolean not null);

create table authorities (
  id number not null primary key,
  username VARCHAR(50) not null,
  authority VARCHAR(50) not null,
  constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);