drop table if exists "user";
drop table if exists "user_selected_artist";

create table if not exists "user"(
    id serial PRIMARY KEY not null,
    login varchar(100) unique not null,
    password varchar(100) not null,
    created TIMESTAMP
);

create table if not exists user_selected_artist(
    id serial not null,
    user_id int not null,
    artist_name varchar(100) not null,
    created TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);

insert into "user"(login, "password") values('testLogin', 'testPassword');
insert into "user_selected_artist"(user_id, artist_name) values(1, 'Metallica');
insert into "user_selected_artist"(user_id, artist_name) values(1, 'AC/DC');

select * from "user";
select * from "user_selected_artist";

truncate table "user" cascade;
truncate table "user_selected_artist" cascade;