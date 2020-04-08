--adapted to MySQL:
create table artists(
    id integer not null PRIMARY KEY,
    name varchar(100) not null,
    country varchar(100)
)
/
create table albums(
    id integer not null PRIMARY KEY,
    name varchar(100) not null,
    artist_id integer not null FOREIGN KEY,
    release_year integer
)
/