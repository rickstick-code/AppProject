
/*****************************************************
	CREATE TABLES - 03.11.2022
	GROUP: 3
	MEMBER: Florian Waltersdorfer
			Frederick Van Bockryck, 
			Jenny Le
*****************************************************/


BEGIN TRANSACTION


INSERT INTO Benutzer (Benutzername, Email, Passwort, Aktiv)
VALUES	('Flo', 'flo@sfsadh.at', '132456', 1),
		('testuser2', 'user@test.com', 'testtest123', 1),
		('username', 'username@test.coms', 'Passwort', 0);

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
VALUES	('Kilometer', 'km'),
		('Anzahl', 'stk'),
		('Liter', 'l'),
		('Stunden', 'h');

INSERT INTO Gruppen (Bezeichnung, Code, IstPrivat, Aktiv)
VALUES	('Flo', 'M34RT', 1, 1),
		('testuser2', 'te1st', 1, 1),
		('username', 'user15', 1, 1),
		('Meine Freunde', '1245', 0, 1);


INSERT INTO Benutzergruppen (IDBenutzer, IDGruppe)
VALUES	(1,1),
		(2,2),
		(3,3),
		(1,4),
		(2,4);

INSERT INTO Vorsatz (IDGruppe, Bezeichnung, Aktivitaet, Intervall, Startdatum, Zielmenge, Metrik, Aktiv)
VALUES	(1, 'Ich gehe laufen', '3', '1', '2022-11-03', 5, '1', 1),
		('Wir sind Freunde und laufen gern', 4, '2', '2', '2022-12-01',  25, '1', 1);

INSERT INTO Fortschritt (IDBenutzer, Datum, Aktivitaet, Metrik)
VALUES (1, '2022-11-05', 1, 1)


COMMIT TRANSACTION
GO



