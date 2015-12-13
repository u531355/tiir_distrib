-- Schema: public

-- DROP SCHEMA public;



CREATE TABLE Banque(
   id_banque  SERIAL PRIMARY KEY,
   iban_start           TEXT      NOT NULL,
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