ALTER TABLE ETimeRecord DROP FOREIGN KEY FKETimeRecor439226;
ALTER TABLE EAzienda DROP FOREIGN KEY FKEAzienda275569;
ALTER TABLE EAzienda DROP FOREIGN KEY FKEAzienda775837;
ALTER TABLE EProgetto DROP FOREIGN KEY FKEProgetto227142;
ALTER TABLE ESottoprogetto DROP FOREIGN KEY FKESottoprog284899;
ALTER TABLE ESottoprogetto DROP FOREIGN KEY FKESottoprog925786;
ALTER TABLE ETask DROP FOREIGN KEY FKETask442129;
ALTER TABLE ETimeRecord DROP FOREIGN KEY FKETimeRecor456926;
ALTER TABLE ETariffa DROP FOREIGN KEY ETariffa;
ALTER TABLE ETariffa DROP FOREIGN KEY ETariffa2;
ALTER TABLE EDipendente DROP FOREIGN KEY FKEDipendent992843;
ALTER TABLE EDipendente DROP FOREIGN KEY FKEDipendent364337;
DROP TABLE IF EXISTS EStipendio;
DROP TABLE IF EXISTS ETimeRecord;
DROP TABLE IF EXISTS ETask;
DROP TABLE IF EXISTS ESottoprogetto;
DROP TABLE IF EXISTS EProgetto;
DROP TABLE IF EXISTS EAzienda;
DROP TABLE IF EXISTS EMarketing;
DROP TABLE IF EXISTS EDipendente;
DROP TABLE IF EXISTS EDirezione;
DROP TABLE IF EXISTS ETariffa;
CREATE TABLE EStipendio (ID int(11) NOT NULL AUTO_INCREMENT, Ammontare double NOT NULL, Unita varchar(255), PRIMARY KEY (ID));
CREATE TABLE ETimeRecord (ID int(11) NOT NULL AUTO_INCREMENT, EDipendenteCodiceFiscale varchar(255), ETaskIdTask int(11) NOT NULL, TimeInizio date NOT NULL, TimeFine date NOT NULL, Descrizione varchar(255), PRIMARY KEY (ID));
CREATE TABLE ETask (IdTask int(11) NOT NULL AUTO_INCREMENT, ESottoprogettoIdSottoprogetto int(11) NOT NULL, Descrizione varchar(255), NomeTask varchar(255), PRIMARY KEY (IdTask));
CREATE TABLE ESottoprogetto (IdSottoprogetto int(11) NOT NULL AUTO_INCREMENT, EDipendenteCodiceFiscale varchar(255), EProgettoIdProgetto int(11) NOT NULL, NomeSottoprogetto varchar(255), PRIMARY KEY (IdSottoprogetto));
CREATE TABLE EProgetto (IdProgetto int(11) NOT NULL AUTO_INCREMENT, EAziendaNomeAzienda varchar(255) NOT NULL, NomeProgetto varchar(255), PRIMARY KEY (IdProgetto));
CREATE TABLE EAzienda (NomeAzienda varchar(255) NOT NULL, EDirezioneID int(11) NOT NULL, EMarketingID int(11) NOT NULL, Indirizzo varchar(255), PRIMARY KEY (NomeAzienda));
CREATE TABLE EMarketing (ID int(11) NOT NULL AUTO_INCREMENT, GiornoPaga int(11) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE EDipendente (CodiceFiscale varchar(255) NOT NULL, EDirezioneID int(11) NOT NULL, EStipendioID int(11) NOT NULL, IdDipendente int(11) NOT NULL, NomeDipendente varchar(255), CognomeDipendente varchar(255), Livello varchar(255), Discriminator varchar(255) NOT NULL, PRIMARY KEY (CodiceFiscale));
CREATE TABLE EDirezione (ID int(11) NOT NULL AUTO_INCREMENT, PRIMARY KEY (ID));
CREATE TABLE ETariffa (Quantita double NOT NULL, Unita varchar(255), EDipendenteCodiceFiscale varchar(255) NOT NULL, ETaskIdTask int(11) NOT NULL, PRIMARY KEY (EDipendenteCodiceFiscale, ETaskIdTask));
ALTER TABLE ETimeRecord ADD INDEX FKETimeRecor439226 (ETaskIdTask), ADD CONSTRAINT FKETimeRecor439226 FOREIGN KEY (ETaskIdTask) REFERENCES ETask (IdTask);
ALTER TABLE EAzienda ADD INDEX FKEAzienda275569 (EMarketingID), ADD CONSTRAINT FKEAzienda275569 FOREIGN KEY (EMarketingID) REFERENCES EMarketing (ID);
ALTER TABLE EAzienda ADD INDEX FKEAzienda775837 (EDirezioneID), ADD CONSTRAINT FKEAzienda775837 FOREIGN KEY (EDirezioneID) REFERENCES EDirezione (ID);
ALTER TABLE EProgetto ADD INDEX FKEProgetto227142 (EAziendaNomeAzienda), ADD CONSTRAINT FKEProgetto227142 FOREIGN KEY (EAziendaNomeAzienda) REFERENCES EAzienda (NomeAzienda);
ALTER TABLE ESottoprogetto ADD INDEX FKESottoprog284899 (EProgettoIdProgetto), ADD CONSTRAINT FKESottoprog284899 FOREIGN KEY (EProgettoIdProgetto) REFERENCES EProgetto (IdProgetto);
ALTER TABLE ESottoprogetto ADD INDEX FKESottoprog925786 (EDipendenteCodiceFiscale), ADD CONSTRAINT FKESottoprog925786 FOREIGN KEY (EDipendenteCodiceFiscale) REFERENCES EDipendente (CodiceFiscale);
ALTER TABLE ETask ADD INDEX FKETask442129 (ESottoprogettoIdSottoprogetto), ADD CONSTRAINT FKETask442129 FOREIGN KEY (ESottoprogettoIdSottoprogetto) REFERENCES ESottoprogetto (IdSottoprogetto);
ALTER TABLE ETimeRecord ADD INDEX FKETimeRecor456926 (EDipendenteCodiceFiscale), ADD CONSTRAINT FKETimeRecor456926 FOREIGN KEY (EDipendenteCodiceFiscale) REFERENCES EDipendente (CodiceFiscale);
ALTER TABLE ETariffa ADD INDEX ETariffa (EDipendenteCodiceFiscale), ADD CONSTRAINT ETariffa FOREIGN KEY (EDipendenteCodiceFiscale) REFERENCES EDipendente (CodiceFiscale);
ALTER TABLE ETariffa ADD INDEX ETariffa2 (ETaskIdTask), ADD CONSTRAINT ETariffa2 FOREIGN KEY (ETaskIdTask) REFERENCES ETask (IdTask);
ALTER TABLE EDipendente ADD INDEX FKEDipendent992843 (EStipendioID), ADD CONSTRAINT FKEDipendent992843 FOREIGN KEY (EStipendioID) REFERENCES EStipendio (ID);
ALTER TABLE EDipendente ADD INDEX FKEDipendent364337 (EDirezioneID), ADD CONSTRAINT FKEDipendent364337 FOREIGN KEY (EDirezioneID) REFERENCES EDirezione (ID);
