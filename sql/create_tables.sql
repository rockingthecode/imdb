DROP TABLE MOVIE;
DROP TABLE CHARACTER;
DROP TABLE ACTOR;
DROP TABLE DIRECTOR;

CREATE TABLE IF NOT EXISTS movie (
  id INT NOT NULL,
  title varchar(250) NOT NULL,
  genre varchar(50) NOT NULL,
  director_id INT NOT NULL,
  rating numeric,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS CHARACTER (
  id INT NOT NULL,
  movie_id INT,
  actor_id INT,
  name varchar(250) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS actorEntity (
  id INT NOT NULL,
  first_name varchar(250) NOT NULL,
  last_name varchar(250) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS directorResponse (
  id INT NOT NULL,
  first_name varchar(250) NOT NULL,
  last_name varchar(250) NOT NULL,
  PRIMARY KEY (id)
);
