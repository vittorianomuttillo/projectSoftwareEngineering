ALTER TABLE EAzienda DROP FOREIGN KEY FKEAzienda775837;
ALTER TABLE EProgetto DROP FOREIGN KEY FKEProgetto227142;
ALTER TABLE EDipendente DROP FOREIGN KEY FKEDipendent626166;
ALTER TABLE EDipendente DROP FOREIGN KEY FKEDipendent364337;
ALTER TABLE ESottoprogetto DROP FOREIGN KEY FKESottoprog284899;
ALTER TABLE ESottoprogetto DROP FOREIGN KEY FKESottoprog925786;
ALTER TABLE ETask DROP FOREIGN KEY FKETask442129;
ALTER TABLE ETask_EDipendente DROP FOREIGN KEY FKETask_EDip663018;
ALTER TABLE ETask_EDipendente DROP FOREIGN KEY FKETask_EDip354681;
DROP TABLE IF EXISTS EAzienda;
DROP TABLE IF EXISTS EDipendente;
DROP TABLE IF EXISTS EDirezione;
DROP TABLE IF EXISTS EProgetto;
DROP TABLE IF EXISTS ESottoprogetto;
DROP TABLE IF EXISTS ETariffa;
DROP TABLE IF EXISTS ETask;
DROP TABLE IF EXISTS ETask_EDipendente;
CREATE TABLE EAzienda (NomeAzienda varchar(255) NOT NULL, EDirezioneID int(11) NOT NULL, Indirizzo varchar(255), PRIMARY KEY (NomeAzienda));
CREATE TABLE EDipendente (CodiceFiscale varchar(255) NOT NULL, EDirezioneID int(11) NOT NULL, ETariffaID int(11), IdDipendente int(11) NOT NULL, NomeDipendente varchar(255), CognomeDipendente varchar(255), Discriminator varchar(255) NOT NULL, PRIMARY KEY (CodiceFiscale));
CREATE TABLE EDirezione (ID int(11) NOT NULL AUTO_INCREMENT, PRIMARY KEY (ID));
CREATE TABLE EProgetto (IdProgetto int(11) NOT NULL AUTO_INCREMENT, EAziendaNomeAzienda varchar(255) NOT NULL, NomeProgetto varchar(255), PRIMARY KEY (IdProgetto));
CREATE TABLE ESottoprogetto (IdSottoprogetto int(11) NOT NULL AUTO_INCREMENT, EDipendenteCodiceFiscale varchar(255), EProgettoIdProgetto int(11) NOT NULL, NomeSottoprogetto varchar(255), PRIMARY KEY (IdSottoprogetto));
CREATE TABLE ETariffa (ID int(11) NOT NULL AUTO_INCREMENT, Quantita double NOT NULL, Unita varchar(255), PRIMARY KEY (ID));
CREATE TABLE ETask (IdTask int(11) NOT NULL AUTO_INCREMENT, ESottoprogettoIdSottoprogetto int(11) NOT NULL, Descrizione varchar(255), NomeTask varchar(255), PRIMARY KEY (IdTask));
CREATE TABLE ETask_EDipendente (ETaskIdTask int(11) NOT NULL, EDipendenteCodiceFiscale varchar(255) NOT NULL, PRIMARY KEY (ETaskIdTask, EDipendenteCodiceFiscale));
ALTER TABLE EAzienda ADD INDEX FKEAzienda775837 (EDirezioneID), ADD CONSTRAINT FKEAzienda775837 FOREIGN KEY (EDirezioneID) REFERENCES EDirezione (ID);
ALTER TABLE EProgetto ADD INDEX FKEProgetto227142 (EAziendaNomeAzienda), ADD CONSTRAINT FKEProgetto227142 FOREIGN KEY (EAziendaNomeAzienda) REFERENCES EAzienda (NomeAzienda);
ALTER TABLE EDipendente ADD INDEX FKEDipendent626166 (ETariffaID), ADD CONSTRAINT FKEDipendent626166 FOREIGN KEY (ETariffaID) REFERENCES ETariffa (ID);
ALTER TABLE EDipendente ADD INDEX FKEDipendent364337 (EDirezioneID), ADD CONSTRAINT FKEDipendent364337 FOREIGN KEY (EDirezioneID) REFERENCES EDirezione (ID);
ALTER TABLE ESottoprogetto ADD INDEX FKESottoprog284899 (EProgettoIdProgetto), ADD CONSTRAINT FKESottoprog284899 FOREIGN KEY (EProgettoIdProgetto) REFERENCES EProgetto (IdProgetto);
ALTER TABLE ESottoprogetto ADD INDEX FKESottoprog925786 (EDipendenteCodiceFiscale), ADD CONSTRAINT FKESottoprog925786 FOREIGN KEY (EDipendenteCodiceFiscale) REFERENCES EDipendente (CodiceFiscale);
ALTER TABLE ETask ADD INDEX FKETask442129 (ESottoprogettoIdSottoprogetto), ADD CONSTRAINT FKETask442129 FOREIGN KEY (ESottoprogettoIdSottoprogetto) REFERENCES ESottoprogetto (IdSottoprogetto);
ALTER TABLE ETask_EDipendente ADD INDEX FKETask_EDip663018 (ETaskIdTask), ADD CONSTRAINT FKETask_EDip663018 FOREIGN KEY (ETaskIdTask) REFERENCES ETask (IdTask);
ALTER TABLE ETask_EDipendente ADD INDEX FKETask_EDip354681 (EDipendenteCodiceFiscale), ADD CONSTRAINT FKETask_EDip354681 FOREIGN KEY (EDipendenteCodiceFiscale) REFERENCES EDipendente (CodiceFiscale);
