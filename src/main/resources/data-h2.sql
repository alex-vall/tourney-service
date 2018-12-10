INSERT INTO tourneys (tourneyid, name, is_active, start_date, finish_date)
  VALUES (
    (SELECT sq_tourneyid.nextval from DUAL),
    'test tourney2',
    FALSE,
    PARSEDATETIME('3 Feb 2018 03:05:06 GMT',
    'd MMM yyyy HH:mm:ss z', 'en', 'GMT'),
    PARSEDATETIME('3 Mar 2018 03:05:06 GMT',
    'd MMM yyyy HH:mm:ss z', 'en', 'GMT')
  );

INSERT INTO tourneys (tourneyid, name, is_active, start_date, finish_date)
  VALUES (
    (SELECT sq_tourneyid.nextval from DUAL),
    'test tourney1',
    TRUE,
    CURRENT_TIMESTAMP(),
    DATEADD('MONTH', 1, CURRENT_TIMESTAMP())
  );

INSERT INTO tourneys (tourneyid, name, is_active, start_date, finish_date)
  VALUES (
    (SELECT sq_tourneyid.nextval from DUAL),
    'test tourney2',
    FALSE,
    DATEADD('MONTH', 1, CURRENT_TIMESTAMP()),
    DATEADD('MONTH', 2, CURRENT_TIMESTAMP())
  );

  INSERT INTO tourneys (tourneyid, name, is_active, start_date, finish_date)
  VALUES (
    (SELECT sq_tourneyid.nextval from DUAL),
    'active tourney1',
    TRUE,
    CURRENT_TIMESTAMP(),
    DATEADD('MONTH', 1, CURRENT_TIMESTAMP())
  );

INSERT INTO player_choices (player_choiceid, tourneyid, memberid, participation, action_date)
  VALUES (
    (SELECT sq_player_choiceid.nextval from DUAL),
    2,
    10,
    FALSE,
    PARSEDATETIME('5 Dec 2018 03:05:06 GMT',
        'd MMM yyyy HH:mm:ss z', 'en', 'GMT'),
  );

