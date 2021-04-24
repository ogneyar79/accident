CREATE TABLE accident
(
    id      serial primary key,
    nombre  varchar(100),
    desc    varchar(2000),
    address varchar(200)
);


CREATE TABLE IF NOT EXISTS accident
(
    id      serial primary key,
    nombre  VARCHAR(100) not null,
    description    TEXT,
    address varchar(200)
    );