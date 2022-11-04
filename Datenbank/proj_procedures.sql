USE Taskapp;

/*****************************************************
	CREATE TABLES - 03.11.2022
	GROUP: 3
	MEMBER: Florian Waltersdorfer
			Frederick Van Bockryck, 
			Jenny Le
*****************************************************/


BEGIN TRANSACTION
GO


--- Procedure um das Passwort zu checken ---
CREATE OR ALTER PROCEDURE sp_checkPasswort

	@Benutzername VARCHAR(100),
	@Passwort VARCHAR(100),
	@Ausgabe BIT OUTPUT

AS
BEGIN
	--Stand: 04.11.2022
	SET NOCOUNT ON;
	IF (SELECT COUNT(*) FROM Benutzer 
		WHERE	Benutzername = @Benutzername AND 
				Passwort = CAST(HASHBYTES('SHA2_512', @Passwort + 'Salz') AS varchar(100))) = 1
	BEGIN
		SET @Ausgabe = 1
	END ELSE BEGIN
		SET @Ausgabe = 0
	END
END
GO

--- Procedure um ein Passwort zu setzten ---
CREATE OR ALTER PROCEDURE sp_createPasswort

	@Benutzername VARCHAR(100),-- default null setzten
	@OldPasswort VARCHAR(100),-- default null setzten
	@NewPasswort VARCHAR(100),
	@Ausgabe BIT OUTPUT

AS
BEGIN
	--Stand: 04.11.2022
	
	/*
		Wenn Benutzername nicht existiert, kreire mit New Passwort
		Wenn Benutzername existiert gleiche old passwort und nutzername ab(use procedure we already have)
		und wenn das passt dann change passwort
	*/
END



COMMIT TRANSACTION
GO



--- Test Passwort check---
UPDATE Benutzer SET Passwort = CAST(HASHBYTES('SHA2_512', '123' + 'Salz') AS VARCHAR(100)) WHERE Benutzername = 'Max_Mustermann';
DECLARE @Ausgabe BIT
EXEC sp_checkPasswort @Benutzername = 'Max_Mustermann', @Passwort = '123', @Ausgabe = @Ausgabe OUTPUT
PRINT @Ausgabe;
