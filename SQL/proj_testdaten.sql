USE Taskapp;

/*****************************************************
	CREATE TABLES - 03.11.2022
	GROUP: 3
	MEMBER: Florian Waltersdorfer
			Frederick Van Bockryck, 
			Jenny Le
*****************************************************/


BEGIN TRANSACTION

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

INSERT INTO Vorsatz (Bezeichnung, Aktivitaet, Intervall, Startdatum, Zielmenge, Metrik, Aktiv)
VALUES	('Ich gehe laufen', 1, 1, '2022-11-03 10:00', 5, 2, 1),
		('Regelm‰ﬂig Trinken', 2, 2, '2022-10-03 09:00', 1, 4, 1),
		('Mehr Sport machen!', 3, 3, '2022-09-01 19:00', 1, 1, 0),
		('Ich will ins Fitnessstudio', 4, 4, '2022-10-03 15:00', 2, 3, 1),
		('3 Liter trinken', 4, 5, '2022-08-05 09:00', 1, 4, 1),

INSERT INTO Fortschritt (Datum, Aktivitaet, Metrik, Zielmenge)
VALUES	('2022-11-05', 1, 2, 2),
		('2022-10-15', 2, 4, 1),
		('2022-10-05', 3, 1, 1),
		('2022-11-02', 4, 3, 1),
		('2022-11-03', 4, 4, 5),
		('2022-12-15', 1, 2, 5),
		('2022-12-16', 1, 2, 5);


COMMIT TRANSACTION
GO


SELECT * FROM Aktivitaet;
SELECT * FROM Intervall;
SELECT * FROM Metrik;
SELECT * FROM Vorsatz;
SELECT * FROM Fortschritt;