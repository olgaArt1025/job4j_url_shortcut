create table if not exists sites(
      id serial primary key,
      login text,
      password varchar(2000),
      site text unique
);

create table if not exists urls(
     id serial primary key,
     url varchar(2000),
     code text unique,
     count int
);