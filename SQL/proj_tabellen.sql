USE Taskapp;

/*****************************************************
	CREATE TABLES - 03.11.2022
	GROUP: 3
	MEMBER:	Florian Waltersdorfer
			Frederick Van Bockryck, 
			Jenny Le
			Jakob Schöllauf
*****************************************************/


BEGIN TRANSACTION


DROP TABLE Vorsatz;
DROP TABLE Fortschritt;
DROP TABLE Metrik;
DROP TABLE Aktivitaet;
DROP TABLE Intervall;



CREATE TABLE Intervall (
	ID INT NOT NULL IDENTITY(1,1),
	Bezeichnung VARCHAR(100) NOT NULL,
	Anzahl INT NOT NULL,
	CONSTRAINT pk_Intervall PRIMARY KEY (ID),
	CONSTRAINT uk_Intervall_Bezeichnung_Anzahl UNIQUE (Bezeichnung, Anzahl)
);


CREATE TABLE Aktivitaet (
	ID INT NOT NULL IDENTITY(1,1),
	Bezeichnung VARCHAR(100) NOT NULL,
	CONSTRAINT pk_Aktivitaet PRIMARY KEY (ID),
	CONSTRAINT uk_Aktivitaet_Bezeichnung UNIQUE (Bezeichnung)
);


CREATE TABLE Metrik (
	ID INT NOT NULL IDENTITY(1,1),
	Bezeichnung VARCHAR(100) NOT NULL,
	Einheit VARCHAR(10) NOT NULL,
	CONSTRAINT pk_Metrik PRIMARY KEY (ID),
	CONSTRAINT uk_Metrik_Einheit UNIQUE (Einheit)
);


CREATE TABLE Fortschritt (
	ID INT NOT NULL IDENTITY(1,1),
	Datum DATE NOT NULL DEFAULT GETDATE(),
	Aktivitaet INT NOT NULL,
	Metrik INT NOT NULL,
	Zielmenge INT NOT NULL,
	CONSTRAINT pk_Fortschritt PRIMARY KEY (ID),
	CONSTRAINT fk_Fortschritt_Aktivitaet FOREIGN KEY (Aktivitaet) REFERENCES Aktivitaet(ID),
	CONSTRAINT fk_Fortschritt_Metrik FOREIGN KEY (Metrik) REFERENCES Metrik(ID)
);


CREATE TABLE Vorsatz (
	ID INT NOT NULL IDENTITY(1,1),
	Bezeichnung VARCHAR(100) NOT NULL,
	Aktivitaet INT NOT NULL,
	Intervall INT NOT NULL,
	Startdatum DATE NOT NULL DEFAULT GETDATE(),
	Zielmenge INT NOT NULL,
	Metrik INT NOT NULL,
	Aktiv BIT NOT NULL DEFAULT 1,
	CONSTRAINT pk_Vorsatz PRIMARY KEY (ID),
	CONSTRAINT fk_Vorsatz_Aktivitaet FOREIGN KEY (Aktivitaet) REFERENCES Aktivitaet(ID),
	CONSTRAINT fk_Vorsatz_Intervall FOREIGN KEY (Intervall) REFERENCES Intervall(ID),
	CONSTRAINT fk_Vorsatz_Metrik FOREIGN KEY (Metrik) REFERENCES Metrik(ID),
);


COMMIT TRANSACTION
GO
