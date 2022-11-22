drop table if exists "user" cascade;
drop table if exists "user_selected_artist" cascade;
drop table if exists "user_suitable_track" cascade;

create table if not exists "user"(
    id serial PRIMARY KEY not null,
    login varchar(100) unique not null,
    password varchar(100) not null,
    created TIMESTAMP default current_timestamp
);

create table if not exists user_selected_artist(
    id serial PRIMARY KEY not null,
    user_id int not null,
    artist_name varchar(400) not null,
    artist_photo_url varchar(400) not null,
    created TIMESTAMP default current_timestamp,
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);

create table if not exists user_suitable_track(
    id serial PRIMARY KEY not null,
    user_id int not null,
    artist_name varchar(400) not null,
    track_name varchar(400) not null,
    track_photo_url varchar(400) not null,
    created TIMESTAMP default current_timestamp,
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);

insert into "user"(login, "password") values('testLogin', 'testPassword');
insert into "user_selected_artist"(user_id, artist_name, artist_photo_url) values(1, 'Slayer', 'https://yt3.ggpht.com/ytc/AMLnZu9bNCWZSDP2yS9WWB9Kzg0LgnADmH7XsjrnCFpy=s900-c-k-c0x00ffffff-no-rj');
insert into "user_selected_artist"(user_id, artist_name, artist_photo_url) values(1, 'Guns''n''Roses', 'https://i.scdn.co/image/ab6761610000e5eb50defaf9fc059a1efc541f4c');
insert into "user_suitable_track"(user_id, artist_name, track_name, track_photo_url)
    values(1, 'Metallica', 'Enter Sandman', 'https://upload.wikimedia.org/wikipedia/ru/6/6f/Enter_Sansman.jpg');
insert into "user_suitable_track"(user_id, artist_name, track_name, track_photo_url)
    values(1, 'AC/DC', 'Thunderstruck', 'https://upload.wikimedia.org/wikipedia/ru/e/e5/ACDCThunderstruck.jpg');

select * from "user";
select * from "user_selected_artist";
select * from "user_suitable_track";

truncate table "user_suitable_track" cascade;
truncate table "user_selected_artist" cascade;
truncate table "user" cascade;
