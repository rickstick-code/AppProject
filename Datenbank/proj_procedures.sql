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


--- Procedure xy ---



COMMIT TRANSACTION
GO


--- Test Passwort check---
DECLARE @Ausgabe BIT
EXEC sp_checkPasswort @Benutzername = 'Max_Mustermann', @Passwort = '123', @Ausgabe = @Ausgabe OUTPUT
PRINT @Ausgabe;
