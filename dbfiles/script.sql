create table bbs_anime
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null
);

create table bbs_animewith
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null,
    withc       int          null
);

create table bbs_food
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null
);

create table bbs_foodwith
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null,
    withc       int          null
);

create table bbs_forcomplain
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null
);

create table bbs_forcomplainwith
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null,
    withc       int          null
);

create table bbs_historystory
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null
);

create table bbs_historystorywith
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null,
    withc       int          null
);

create table bbs_military
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null
);

create table bbs_militarywith
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null,
    withc       int          null
);

create table bbs_political
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null
);

create table bbs_politicalwith
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null,
    withc       int          null
);

create table bbs_travel
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null
);

create table bbs_travelwith
(
    id          int auto_increment
        primary key,
    title       varchar(255) null,
    context     text         null,
    createdtime varchar(255) null,
    changetime  varchar(255) null,
    user        varchar(255) null,
    withc       int          null
);

create table bbs_user
(
    id        int auto_increment
        primary key,
    username  varchar(255) null,
    password  varchar(255) null,
    userroles varchar(255) null,
    userpics  text         null,
    messages  varchar(255) null
);


