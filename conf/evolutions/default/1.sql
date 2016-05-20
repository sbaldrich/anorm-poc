
# --- !Ups
CREATE TABLE movies(name VARCHAR(100), stars INTEGER);

INSERT INTO movies VALUES('fight club', 4);
INSERT INTO movies VALUES('Batman v Superman', 1);


# --- !Downs

DROP TABLE movies;