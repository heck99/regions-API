create table if NOT EXISTS regions
(
   id integer not null,
   full_name varchar(255) not null,
   short_name varchar(50) not null,
   primary key(id)
);

