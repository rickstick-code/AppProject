use waltersd21;

BEGIN TRANSACTION

create table benutzer (
	bid int not null identity(1,1),
	benutzername varchar(100) not null,
	email varchar(100) not null,
	passwort varchar(100) not null,
	aktiv bit not null default 1,
	constraint pk_benutzer primary key (bid),
	constraint uk_benutzer_benutzername unique (benutzername),
	constraint uk_benutzer_email unique (email)

	);


create table gruppen (
	gid int not null identity(1,1),
	bezeichnung varchar(100) not null,
	code varchar(100) not null,
	is_private bit not null default 1,
	aktiv bit not null default 1,
	constraint pk_gruppen primary key (gid),
	constraint uk_gruppen_code unique (code)
	);


create table benutzergruppen (
	bid int not null,
	gid int not null,
	constraint pk_benutzergruppen primary key (bid,gid),
	constraint fk_benutzergruppen_benutzer foreign key (bid) references benutzer(bid),
	constraint fk_benutzergruppen_gruppen foreign key (gid) references gruppen(gid)
	);


create table intervall (
	id int not null identity(1,1),
	bezeichnung varchar(100) not null,
	anzahl smallint not null,
	constraint pk_intervall primary key (id),
	constraint uk_intervall_bezeichnung_anzahl unique (bezeichnung, anzahl)
	);


create table aktivitaet (
	id int not null identity(1,1),
	bezeichnung varchar(100) not null,
	constraint pk_aktivitaet primary key (id),
	constraint uk_aktivitaet_bezeichnung unique (bezeichnung)
	);


create table metrik (
	id int not null identity(1,1),
	bezeichnung varchar(100) not null,
	einheit varchar(10) not null,
	constraint pk_metrik primary key (id),
	constraint uk_metrik_einheit unique (einheit)
	);


create table fortschritt (
	id int not null identity(1,1),
	bid int not null,
	datum date not null default sysdatetime(),
	aktivitaet int not null,
	metrik int not null,
	constraint pk_fortschritt primary key (id),
	constraint fk_fortschritt_benutzer foreign key (bid) references benutzer(bid),
	constraint fk_fortschritt_aktivitaet foreign key (aktivitaet) references aktivitaet(id),
	constraint fk_fortschritt_metrik foreign key (metrik) references metrik(id)
	);


create table vorsatz (
	id int not null identity(1,1),
	bezeichnung varchar(100) not null,
	gid int not null,
	aktivitaet int not null,
	intervall int not null,
	start_datum date not null default sysdatetime(),
	zielmenge int not null,
	metrik int not null,
	aktiv bit not null default 1,
	constraint pk_vorsatz primary key (id),
	constraint fk_vorsatz_gruppen foreign key (gid) references gruppen(gid),
	constraint fk_vorsatz_aktivitaet foreign key (aktivitaet) references aktivitaet(id),
	constraint fk_vorsatz_intervall foreign key (intervall) references intervall(id),
	constraint fk_vorsatz_metrik foreign key (metrik) references metrik(id),
	constraint ck_voratz_start_datum check (start_datum > '2022-11-01')
	);

COMMIT TRANSACTION

GO




/*
BEGIN TRANSACTION

drop table vorsatz;
drop table fortschritt;
drop table metrik;
drop table aktivitaet;
drop table intervall;
drop table benutzergruppen;
drop table gruppen;
drop table benutzer;

COMMIT TRANSACTION
GO
*/
