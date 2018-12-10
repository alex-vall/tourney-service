DROP TABLE IF EXISTS tourneys;
DROP TABLE IF EXISTS player_choices;

DROP SEQUENCE IF EXISTS sq_tourneyid;
DROP SEQUENCE IF EXISTS sq_player_choiceid;

CREATE SEQUENCE sq_tourneyid;
CREATE SEQUENCE sq_player_choiceid;

CREATE TABLE tourneys
(
  tourneyid       INTEGER GENERATED BY DEFAULT AS IDENTITY SEQUENCE sq_tourneyid PRIMARY KEY,
  name            VARCHAR2(200),
  is_active       BOOLEAN,
  start_date      TIMESTAMP,
  finish_date     TIMESTAMP
);

CREATE TABLE player_choices
(
  player_choiceid   INTEGER GENERATED BY DEFAULT AS IDENTITY SEQUENCE sq_player_choiceid PRIMARY KEY,
  tourneyid         INTEGER,
  memberid          INTEGER,
  participation     BOOLEAN,
  action_date       TIMESTAMP
);



