BEGIN;
DROP SCHEMA IF EXISTS movieland CASCADE;
CREATE SCHEMA movieland;

DROP TABLE IF EXISTS movieland.reviews;
DROP TABLE IF EXISTS movieland.movie_genre;
DROP TABLE IF EXISTS movieland.users;
DROP TABLE IF EXISTS movieland.movies;
DROP TABLE IF EXISTS movieland.genres;

CREATE TABLE movieland.users
(
   user_id  serial         NOT NULL,
   name     varchar(100)   NOT NULL,
   email    varchar(100)   NOT NULL,
   role     varchar(15)    NOT NULL,
   hash     varchar(100)   NOT NULL,
   salt     varchar(100)   NOT NULL
);
ALTER TABLE movieland.users
   ADD CONSTRAINT users_pkey
   PRIMARY KEY (user_id);

CREATE UNIQUE INDEX email_unique ON movieland.users (email);

CREATE TABLE movieland.movies
(
   movie_id       serial          NOT NULL,
   name           varchar(100)    NOT NULL,
   name_original  varchar(100)    NOT NULL,
   year           varchar(50),
   country        varchar(250),
   description    varchar(2000),
   rating         numeric(10,2),
   price          numeric(10,2),
   picture_path   varchar(2000)
);
ALTER TABLE movieland.movies
   ADD CONSTRAINT movies_pkey
   PRIMARY KEY (movie_id);

CREATE TABLE movieland.reviews (
	review_id serial primary key,
	movie_id integer not null references movieland.movies(movie_id),
	user_id integer not null references movieland.users(user_id),
	text varchar(4000)
);
CREATE UNIQUE INDEX review_UNIQUE ON movieland.reviews (movie_id, user_id);

CREATE TABLE movieland.genres (
	genre_id serial primary key,
	name varchar(50) not null
);
CREATE UNIQUE INDEX name_UNIQUE ON movieland.genres (name);

CREATE TABLE movieland.movie_genre (
	movie_id integer not null references movieland.movies(movie_id),
	genre_id integer not null references movieland.genres(genre_id)
);
CREATE UNIQUE INDEX movie_genre_UNIQUE ON movieland.movie_genre (movie_id, genre_id);

COMMIT;