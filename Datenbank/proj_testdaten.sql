USE Taskapp;

/*****************************************************
	CREATE TABLES - 03.11.2022
	GROUP: 3
	MEMBER: Florian Waltersdorfer
			Frederick Van Bockryck, 
			Jenny Le
*****************************************************/


BEGIN TRANSACTION


INSERT INTO Benutzer (Benutzername, Email, Passwort, Aktiv)
VALUES	('Max_Mustermann', 'max.mustermann@test.com', 'ùÉ)â¶ÙhÆ§$f–œÏA€CMzïFh¡»Ÿ’Ü5uöç’¨:a:¬¨ tJ[_ð}¸‘.Sðƒ3{_', 1),
		('Markus_Meier', 'markus.meier@test.com', 'EAC27BAC6', 1),
		('Sabine_Sauer', 'sabine.sauer@test.com', 'EC8F1FD08A85', 0),
		('Michael_Jack', 'michael.jack@test.com', 'QAC2755555', 1),
		('Max_Fischer', 'max.fischer@test.com', 'SWHDD08A8544', 1),
		('Karina_Kauf', 'karina.kauf@test.com', 'DGBSAJD677', 1),
		('Klaus_Kauf', 'klaus.kauf@test.com', 'ADFGHS5551', 1);

INSERT INTO Aktivitaet (Bezeichnung)
VALUES	('Laufen'),
		('Wasser trinken'),
		('Sport machen'),
		('Fitnessstudio gehen');

INSERT INTO Intervall (Bezeichnung, Anzahl)
VALUES	('Woche', 3),
		('Tag', 2),
		('Monat', 4),
		('Woche', 5),
		('Monat', 1);

INSERT INTO Metrik (Bezeichnung, einheit)
VALUES	('Keine', '--'),
		('Kilometer', 'km'),
		('Anzahl', 'stk'),
		('Liter', 'l'),
		('Stunden', 'h');

INSERT INTO Gruppen (Bezeichnung, Code, IstPrivat, Aktiv)
VALUES	('Gruppe 1', 'M34RT', 1, 1),
		('Gruppe 2', 'te1st', 1, 1),
		('Gruppe 3', 'user15', 1, 0),
		('Gruppe 4', '1245ef', 1, 1),
		('Gruppe 5', '56g654', 1, 1),
		('Gruppe 6', 'sads3d', 1, 1),
		('Gruppe 7', '23dd2s', 1, 1),
		('Gruppe 8', '1245qq', 0, 1),
		('Gruppe 9', '12sw45', 0, 1);

INSERT INTO Benutzergruppen (IDGruppe, IDBenutzer)
VALUES	(1,1),
		(2,2),
		(3,3),
		(4,4),
		(5,5),
		(6,6),
		(7,7),
		(8,6), (8,7),
		(9,1), (9,2), (9,5), (9,6), (9,7);

INSERT INTO Vorsatz (IDGruppe, Bezeichnung, Aktivitaet, Intervall, Startdatum, Zielmenge, Metrik, Aktiv)
VALUES	(1, 'Ich gehe laufen', 1, 1, '2022-11-03 10:00', 5, 2, 1),
		(2, 'Regelmäßig Trinken', 2, 2, '2022-10-03 09:00', 1, 4, 1),
		(4, 'Mehr Sport machen!', 3, 3, '2022-09-01 19:00', 1, 1, 0),
		(5, 'Ich will ins Fitnessstudio', 4, 4, '2022-10-03 15:00', 2, 3, 1),
		(6, '3 Liter trinken', 4, 5, '2022-08-05 09:00', 1, 4, 1),
		(8, 'Wir sind Verwandte und laufen gern', 1, 5, '2022-12-01 10:00',  25, 2, 1),
		(9, 'Wir sind Freunde und laufen gern', 1, 2, '2022-10-10 20:45',  25, 2, 1);

INSERT INTO Fortschritt (IDBenutzer, Datum, Aktivitaet, Metrik, Zielmenge)
VALUES	(1, '2022-11-05', 1, 2, 2),
		(2, '2022-10-15', 2, 4, 1),
		(4, '2022-10-05', 3, 1, 1),
		(5, '2022-11-02', 4, 3, 1),
		(6, '2022-11-03', 4, 4, 5),
		(7, '2022-12-15', 1, 2, 5),
		(7, '2022-12-16', 1, 2, 5);


COMMIT TRANSACTION
GO


SELECT * FROM Benutzer;
SELECT * FROM Aktivitaet;
SELECT * FROM Intervall;
SELECT * FROM Metrik;
SELECT * FROM Gruppen;
SELECT * FROM Benutzergruppen;
SELECT * FROM Vorsatz;
SELECT * FROM Fortschritt;