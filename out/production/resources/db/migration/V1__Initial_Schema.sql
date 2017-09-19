CREATE TABLE role (
  id bigint auto_increment,
  version bigint,
  name varchar(50) not null,
  primary key (id));

-- Insert role
INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_ACTUATOR');

CREATE TABLE user (
  id bigint auto_increment,
  version bigint,
  username varchar(20) not null,
  password varchar(100) not null,
  enabled boolean not null,
  registration_date timestamp,
  primary key (id));

CREATE TABLE user_role (
  id bigint auto_increment,
  user_id bigint,
  role_id bigint,
  primary key (id),
  constraint fk_user foreign key (user_id) references user (id),
  constraint fk_role foreign key (role_id) references role (id));

-- Insert two users (passwords are both 'password')
insert into user (username,enabled,password) values ('user',true,'$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u');
insert into user (username,enabled,password) values ('admin',true,'$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u');

insert into user_role (user_id, role_id) values (1, 1);
insert into user_role (user_id, role_id) values (2, 1);
insert into user_role (user_id, role_id) values (2, 2);
insert into user_role (user_id, role_id) values (2, 3);