BEGIN TRANSACTION

insert into benutzer (benutzername,email ,passwort,aktiv)
values	('Flo', 'flo@sfsadh.at', '132456', 1),
		('testuser2', 'user@test.com', 'testtest123', 1),
		('username', 'username@test.coms', 'passwort', 0);


insert into aktivitaet (bezeichnung)
values	('Laufen'),
		('Wasser trinken'),
		('Sport machen'),
		('Fitnessstudio gehen');

insert into intervall (bezeichnung, anzahl)
values	('Woche', 3),
		('Tag', 2),
		('Monat', 4),
		('Woche', 5),
		('Monat', 1);

insert into metrik (bezeichnung, einheit)
values	('kilometer', 'km'),
		('Anzahl', 'stk'),
		('Liter', 'l'),
		('Stunden', 'h');

insert into gruppen (bezeichnung, code, is_private, aktiv)
values	('Flo', 'M34RT', 1, 1),
		('testuser2', 'te1st', 1, 1),
		('username', 'user15', 1, 1),
		('Meine Freunde', '1245', 0, 1);

insert into benutzergruppen (bid, gid)
values	(1,1),
		(2,2),
		(3,3),
		(1,4),
		(2,4);


insert into vorsatz (bezeichnung, gid, aktivitaet, intervall, start_datum, zielmenge, metrik, aktiv)
values	('Ich gehe laufen', 1, '3', '1', '2022-11-03', 5, '1', 1),
		('Wir sind Freunde und laufen gern', 4, '2', '2', '2022-12-01',  25, '1', 1);

insert into fortschritt (bid, datum, aktivitaet, metrik)
values (1, '2022-11-05', 1, 1)


COMMIT TRANSACTION

--select * from benutzer;
--select * from vorsatz;



