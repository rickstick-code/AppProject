use waltersd21;

/*****************************************************
	CREATE TABLES - 03.11.2022
	GROUP: 3
	MEMBER: Florian Waltersdorfer
			Frederick Van Bockryck, 
			Jenny Le
*****************************************************/


BEGIN TRANSACTION


DROP TABLE Vorsatz;
DROP TABLE Fortschritt;
DROP TABLE Metrik;
DROP TABLE Aktivitaet;
DROP TABLE Intervall;
DROP TABLE Benutzergruppengruppen;
DROP TABLE Gruppen;
DROP TABLE Benutzergruppen;


CREATE TABLE Benutzergruppen (
	ID INT NOT NULL IDENTITY(1,1),
	Benutzergruppenname VARCHAR(100) NOT NULL,
	Email VARCHAR(100) NOT NULL,
	Passwort VARCHAR(100) NOT NULL,
	Aktiv BIT NOT NULL DEFAULT 1,
	CONSTRAINT pk_Benutzergruppen PRIMARY KEY (ID),
	CONSTRAINT uk_Benutzergruppen_Benutzergruppenname UNIQUE (Benutzergruppenname),
	CONSTRAINT uk_Benutzergruppen_Email UNIQUE (Email)
);


CREATE TABLE Gruppen (
	ID INT NOT NULL IDENTITY(1,1),
	Bezeichnung VARCHAR(100) NOT NULL,
	Code VARCHAR(100) NOT NULL,
	IstPrivat BIT NOT NULL DEFAULT 1,
	Aktiv BIT NOT NULL DEFAULT 1,
	CONSTRAINT pk_Gruppen PRIMARY KEY (ID),
	CONSTRAINT uk_Gruppen_Code UNIQUE (Code)
);


CREATE TABLE Benutzergruppengruppen (
	IDBenutzer INT NOT NULL,
	IDGruppe INT NOT NULL,
	CONSTRAINT pk_Benutzergruppengruppen PRIMARY KEY (IDBenutzer, IDGruppe),
	CONSTRAINT fk_Benutzergruppengruppen_Benutzergruppen FOREIGN KEY (IDBenutzer) REFERENCES Benutzergruppen(ID),
	CONSTRAINT fk_Benutzergruppengruppen_Gruppen FOREIGN KEY (IDGruppe) REFERENCES Gruppen(ID)
);


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
	IDBenutzer INT NOT NULL,
	Datum DATE NOT NULL DEFAULT GETDATE(),
	Aktivitaet INT NOT NULL,
	Metrik INT NOT NULL,
	CONSTRAINT pk_Fortschritt PRIMARY KEY (ID),
	CONSTRAINT fk_Fortschritt_Benutzergruppen FOREIGN KEY (IDBenutzer) REFERENCES Benutzergruppen(ID),
	CONSTRAINT fk_Fortschritt_Aktivitaet FOREIGN KEY (Aktivitaet) REFERENCES Aktivitaet(ID),
	CONSTRAINT fk_Fortschritt_Metrik FOREIGN KEY (Metrik) REFERENCES Metrik(ID)
);


CREATE TABLE Vorsatz (
	ID INT NOT NULL IDENTITY(1,1),
	IDGruppe INT NOT NULL,
	Bezeichnung VARCHAR(100) NOT NULL,
	Aktivitaet INT NOT NULL,
	Intervall INT NOT NULL,
	Startdatum DATE NOT NULL DEFAULT GETDATE(),
	Zielmenge INT NOT NULL,
	Metrik INT NOT NULL,
	Aktiv BIT NOT NULL DEFAULT 1,
	CONSTRAINT pk_Vorsatz PRIMARY KEY (ID),
	CONSTRAINT fk_Vorsatz_Gruppen FOREIGN KEY (IDGruppe) REFERENCES Gruppen(ID),
	CONSTRAINT fk_Vorsatz_Aktivitaet FOREIGN KEY (Aktivitaet) REFERENCES Aktivitaet(ID),
	CONSTRAINT fk_Vorsatz_Intervall FOREIGN KEY (Intervall) REFERENCES Intervall(ID),
	CONSTRAINT fk_Vorsatz_Metrik FOREIGN KEY (Metrik) REFERENCES Metrik(ID),
	--CONSTRAINT ck_Vorsatz_start_datum CHECK (Startdatum > '2022-11-01')
);


COMMIT TRANSACTION
GO
