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
    PARSEDATETIME('1 Feb 2018 00:00:00 GMT',
    'd MMM yyyy HH:mm:ss z', 'en', 'GMT'),
    PARSEDATETIME('1 Feb 2025 00:00:00 GMT',
    'd MMM yyyy HH:mm:ss z', 'en', 'GMT')
  );

INSERT INTO tourneys (tourneyid, name, is_active, start_date, finish_date)
  VALUES (
    (SELECT sq_tourneyid.nextval from DUAL),
    'test tourney2',
    FALSE,
    PARSEDATETIME('1 Feb 2025 00:00:00 GMT',
    'd MMM yyyy HH:mm:ss z', 'en', 'GMT'),
    PARSEDATETIME('1 Feb 2030 00:00:00 GMT',
    'd MMM yyyy HH:mm:ss z', 'en', 'GMT'),
  );

  INSERT INTO tourneys (tourneyid, name, is_active, start_date, finish_date)
  VALUES (
    (SELECT sq_tourneyid.nextval from DUAL),
    'active tourney1',
    TRUE,
    PARSEDATETIME('1 Feb 2018 00:00:00 GMT',
    'd MMM yyyy HH:mm:ss z', 'en', 'GMT'),
    PARSEDATETIME('1 Feb 2025 00:00:00 GMT',
    'd MMM yyyy HH:mm:ss z', 'en', 'GMT')
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
INSERT INTO player_choices (player_choiceid, tourneyid, memberid, participation, action_date)
  VALUES (
    (SELECT sq_player_choiceid.nextval from DUAL),
    1,
    10,
    TRUE,
    PARSEDATETIME('5 Dec 2018 03:10:06 GMT',
        'd MMM yyyy HH:mm:ss z', 'en', 'GMT'),
  );

