INSERT into NOTES (ID,NOTE_NAME,TEXT) values ('1','note one'  , 'note text go here');
INSERT into NOTES (ID,NOTE_NAME,TEXT) values ('2','note two'  , 'note text go here');
INSERT into NOTES (ID,NOTE_NAME,TEXT) values ('3','note third', 'note text go here');
INSERT into NOTES (ID,NOTE_NAME,TEXT) values ('4','note four' , 'note text go here');
INSERT into NOTES (ID,NOTE_NAME,TEXT) values ('5','note five' , 'note text go here');


insert into users (username, password, enabled) values ('log', '1a1dc91c907325c69271ddf0c944bc72', true);
insert into authorities (username, authority) values ('log', 'ROLE_USER');


insert into users (username, password, enabled) values ('admin', '1a1dc91c907325c69271ddf0c944bc72', true);
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
