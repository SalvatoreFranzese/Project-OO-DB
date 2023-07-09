/* Tabelle */

CREATE TABLE Utente (
    id_User CHAR(5) PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    isAdmin BOOLEAN DEFAULT 'FALSE',
    CONSTRAINT uniqueUsername UNIQUE(username)
);

CREATE TABLE Artista(
    id_Artist CHAR(5) PRIMARY KEY,
    firstName VARCHAR(30) NOT NULL,
    secondName VARCHAR(30) NOT NULL,
    birthDate VARCHAR(30) NOT NULL,
    city VARCHAR(30) NOT NULL,
    followers INTEGER NOT NULL,
    nomeDArte VARCHAR(30) NOT NULL
);

CREATE TABLE Following (
    id_Following CHAR(5) PRIMARY KEY,
    id_Artist CHAR(5),
    id_User CHAR(5),
    CONSTRAINT FK1 FOREIGN KEY (id_User) REFERENCES Utente(id_User) ON DELETE SET DEFAULT,
    CONSTRAINT FK2 FOREIGN KEY (id_Artist) REFERENCES Artista(id_Artist) ON DELETE SET DEFAULT,
    CONSTRAINT NoSelfFollow CHECK (id_Artist <> id_User)
);

CREATE TABLE Album(
    id_Album CHAR(5) PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    genere VARCHAR(30) NOT NULL,
    songNumber INTEGER NOT NULL
);

CREATE TABLE Singolo(
    id_Single CHAR(5) PRIMARY KEY,
    nameSingle VARCHAR(30) NOT NULL,
    duration INTEGER NOT NULL,
    genere VARCHAR(30) NOT NULL
);

CREATE TABLE EP(
    id_EP CHAR(5) PRIMARY KEY,
    nameEP VARCHAR(20) NOT NULL,
    songNumber INTEGER NOT NULL,
    genere VARCHAR(20) NOT NULL
);

CREATE TABLE Pubblica(
    id_Release INTEGER PRIMARY KEY,
    releaseDate DATE NOT NULL,
    id_Artist CHAR(5),
    id_Album CHAR(5),
	id_Single CHAR(5),
    id_EP CHAR(5),
    CONSTRAINT FK1 FOREIGN KEY (id_Artist) REFERENCES Artista(id_Artist) ON DELETE CASCADE,
    CONSTRAINT FK2 FOREIGN KEY (id_Album) REFERENCES Album(id_Album) ON DELETE CASCADE,
    CONSTRAINT FK3 FOREIGN KEY (id_Single) REFERENCES Singolo(id_Single) ON DELETE CASCADE,
    CONSTRAINT FK4 FOREIGN KEY (id_EP) REFERENCES EP(id_EP) ON DELETE CASCADE
);

CREATE TABLE Brano(
    id_Song CHAR(5) PRIMARY KEY,
    songName VARCHAR(30) NOT NULL,
    songDuration INTEGER NOT NULL,
    genereSong VARCHAR(30) NOT NULL,
    id_Album CHAR(5),
    CONSTRAINT FK2 FOREIGN KEY (id_Album) REFERENCES Album(id_Album) ON DELETE CASCADE
);

/* Sequenze */

CREATE SEQUENCE codiceUtente
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 1000
NO CYCLE;

CREATE SEQUENCE codiceFollowing
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 1000
NO CYCLE;

CREATE SEQUENCE codicePubblica
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 1000
NO CYCLE;

CREATE SEQUENCE codiceBrano
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 1000
NO CYCLE;

CREATE SEQUENCE codiceSingolo
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 1000
NO CYCLE;

CREATE SEQUENCE codiceEP
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 1000
NO CYCLE;

/* Trigger id following */

CREATE OR REPLACE FUNCTION idFollowingSequence() RETURNS trigger AS
$BODY$
BEGIN
   	new.id_Following := NEXTVAL('codiceFollowing');
	RETURN NEW;
END;
$BODY$
language plpgsql;

CREATE TRIGGER insertIdFollowing_trigger
BEFORE INSERT ON Following
FOR EACH ROW
EXECUTE PROCEDURE idFollowingSequence();

/* Trigger id utente */

CREATE OR REPLACE FUNCTION idUtenteSequence() RETURNS trigger AS
$BODY$
BEGIN
   	new.id_User := NEXTVAL('codiceUtente');
	RETURN NEW;
END;
$BODY$
language plpgsql;

CREATE TRIGGER insertIdUser_trigger
BEFORE INSERT ON Utente
FOR EACH ROW
EXECUTE PROCEDURE idUtenteSequence();

/* Trigger id pubblica */

CREATE OR REPLACE FUNCTION idPubblicaSequence() RETURNS trigger AS
$BODY$
BEGIN
   	new.id_Release := NEXTVAL('codicePubblica');
	RETURN NEW;
END;
$BODY$
language plpgsql;

CREATE TRIGGER insertIdPubblica_trigger
BEFORE INSERT ON Pubblica
FOR EACH ROW
EXECUTE PROCEDURE idPubblicaSequence();

/*Trigger id brano*/

CREATE OR REPLACE FUNCTION idBranoSequence() RETURNS trigger AS
$BODY$
BEGIN
   	new.id_Song := NEXTVAL('codiceBrano');
	RETURN NEW;
END;
$BODY$
language plpgsql;

CREATE TRIGGER insertIdBrano_trigger
BEFORE INSERT ON Brano
FOR EACH ROW
EXECUTE PROCEDURE idBranoSequence();

/* Incrementa followers */

CREATE OR REPLACE FUNCTION incrementaFollow() RETURNS trigger AS
$BODY$
BEGIN
    UPDATE Artista as A
    SET followers = followers + 1
    WHERE A.id_artist =  NEW.id_Artist;
	RETURN NEW;
END;
$BODY$
language plpgsql;

CREATE TRIGGER incrementaFollowersTrigger
AFTER INSERT ON Following
FOR EACH ROW
EXECUTE PROCEDURE incrementaFollow();

/* Decrementa followers */

CREATE OR REPLACE FUNCTION decrementaFollow() RETURNS trigger AS
$BODY$
BEGIN
    UPDATE Artista as A
    SET followers = followers - 1
    WHERE A.id_artist IN (SELECT id_Artist FROM Following AS F WHERE id_Following = OLD.id_Following AND A.id_Artist = F.id_Artist);
	RETURN NEW;
END;
$BODY$
language plpgsql;

CREATE TRIGGER decrementaFollowersTrigger
AFTER DELETE ON Following
FOR EACH ROW
EXECUTE PROCEDURE decrementaFollow();