# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table task (
  id                        varchar(255) not null,
  filename                  varchar(255),
  constraint pk_task primary key (id))
;

create table user (
  id                        varchar(255) not null,
  fname                     varchar(255),
  lname                     varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (id))
;


create table user_task (
  user_id                        varchar(255) not null,
  task_id                        varchar(255) not null,
  constraint pk_user_task primary key (user_id, task_id))
;
create sequence task_seq;

create sequence user_seq;




alter table user_task add constraint fk_user_task_user_01 foreign key (user_id) references user (id) on delete restrict on update restrict;

alter table user_task add constraint fk_user_task_task_02 foreign key (task_id) references task (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists task;

drop table if exists user;

drop table if exists user_task;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists task_seq;

drop sequence if exists user_seq;

