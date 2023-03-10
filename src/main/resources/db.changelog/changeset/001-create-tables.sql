--liquibase formatted sql

--changeset vpetrovaa:create_films_tables

create schema if not exists cinema_schema;
set schema 'cinema_schema';

create table if not exists films
(
    id bigserial,
	name varchar(45) not null,
	year int not null,
	genre varchar(45) not null,
	showing_date timestamp not null,
	price real not null,
	primary key (id)
);
