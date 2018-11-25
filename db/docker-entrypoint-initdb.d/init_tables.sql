
create table users
(
  id       serial                                      not null,
  username varchar(20)                                 not null,
  password varchar(20)                                 not null,
  token    varchar,
  role     varchar default 'user' :: character varying not null,
  primary key (id)
);

create table traders
(
  id      integer          not null,
  userid  integer          not null,
  name    varchar(20)      not null,
  info    varchar          not null,
  image   bytea,
  primary key (id),
  foreign key (userid) references users
);

create table realestate
(
  id        integer          not null,
  traderid  integer          not null,
  name      varchar(20)      not null,
  info      varchar          not null,
  image     bytea,
  primary key (id),
  foreign key (traderid) references traders
);

create table posts
(
  id            integer                   not null,
  isvalid       boolean default true      not null,
  realestateid  integer                   not null,
  date          date                      not null,
  views         integer default 0         not null,
  primary key (id),
  foreign key (realestateid) references realestate
);