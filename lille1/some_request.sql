-- Database: distrib

-- DROP DATABASE distrib;
﻿-- Schema: public

-- DROP SCHEMA public;



CREATE TABLE Banque(
   id_banque  SERIAL PRIMARY KEY,
   card_start           TEXT      NOT NULL,
   url            TEXT       NOT NULL
);

CREATE TABLE Virement(
   id_virement  SERIAL PRIMARY KEY,
   date           DATE      NOT NULL,
   montant            DECIMAL       NOT NULL,
   iban_from	TEXT 	NOT NULL,
   iban_to	TEXT 	NOT NULL,
   id_banque	INTEGER NOT NULL
);

CREATE TABLE Distributeur(
   id_distributeur  SERIAL PRIMARY KEY,
   montant           DECIMAL      NOT NULL
);
CREATE TABLE Retrait(
   id_retrait  SERIAL PRIMARY KEY,
   date           DATE      NOT NULL,
   montant            DECIMAL       NOT NULL,
   iban_from	TEXT 	NOT NULL,
   id_banque	INTEGER NOT NULL
);
DELETE FROM Banque where iban_start= "7"
UPDATE Banque SET url = "54.77.138.201:8080" where iban_start="7"
SELECT * FROM Banque
DELETE FROM banque where card_start like '2' INSERT INTO Banque (iban_start, url) VALUES ('2','babalouman.suroot.com:8080/banque');

Insert into Distributeur (montant) VALUES ('100')