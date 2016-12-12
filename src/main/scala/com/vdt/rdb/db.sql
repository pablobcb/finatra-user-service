CREATE TABLE article (
    id bigserial primary key,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    date_created timestamp default current_timestamp
);