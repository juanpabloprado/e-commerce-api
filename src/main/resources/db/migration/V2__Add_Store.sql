CREATE TABLE store (
  id bigint auto_increment,
  version bigint,
  name varchar(50) not null,
  primary key (id));

CREATE TABLE product (
  id bigint auto_increment,
  version bigint,
  store_id bigint,
  name varchar(100) not null,
  price decimal(20, 2),
  description varchar(255),
  primary key (id));

insert into store (name, version) values ('amazon.com.mx', 0);
insert into store (name, version) values ('liverpool.com.mx', 0);
insert into store (name, version) values ('linio.com.mx', 0);