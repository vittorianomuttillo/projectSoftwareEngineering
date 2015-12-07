-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generato il: Gen 29, 2014 alle 13:59
-- Versione del server: 5.5.16
-- Versione PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `time-logging`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `eazienda`
--

CREATE TABLE IF NOT EXISTS `eazienda` (
  `NomeAzienda` varchar(255) NOT NULL,
  `EDirezioneID` int(11) NOT NULL,
  `EMarketingID` int(11) NOT NULL,
  `Indirizzo` varchar(255) DEFAULT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`NomeAzienda`),
  KEY `FKEAzienda275569` (`EMarketingID`),
  KEY `FKEAzienda775837` (`EDirezioneID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `eazienda`
--

INSERT INTO `eazienda` (`NomeAzienda`, `EDirezioneID`, `EMarketingID`, `Indirizzo`, `Password`) VALUES
('Ausbleden SpA', 1, 1, 'asd', 'password');

-- --------------------------------------------------------

--
-- Struttura della tabella `edipendente`
--

CREATE TABLE IF NOT EXISTS `edipendente` (
  `CodiceFiscale` varchar(255) NOT NULL,
  `EDirezioneID` int(11) NOT NULL,
  `EStipendioID` int(11) NOT NULL,
  `IdDipendente` int(11) NOT NULL,
  `NomeDipendente` varchar(255) DEFAULT NULL,
  `CognomeDipendente` varchar(255) DEFAULT NULL,
  `Livello` varchar(255) DEFAULT NULL,
  `Discriminator` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`CodiceFiscale`),
  KEY `FKEDipendent992843` (`EStipendioID`),
  KEY `FKEDipendent364337` (`EDirezioneID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `edipendente`
--

INSERT INTO `edipendente` (`CodiceFiscale`, `EDirezioneID`, `EStipendioID`, `IdDipendente`, `NomeDipendente`, `CognomeDipendente`, `Livello`, `Discriminator`, `Password`) VALUES
('lmbdnl89', 1, 2, 1, 'Daniele', 'Leombruni', 'basso', 'EConsulente', 'password'),
('lucfin', 1, 3, 3, 'Luca', 'Finocchio', 'alto', 'EConsulente', 'password'),
('vttmtt', 1, 1, 2, 'Vittoriano', 'Muttillo', 'medio', 'EManager', 'password');

-- --------------------------------------------------------

--
-- Struttura della tabella `edirezione`
--

CREATE TABLE IF NOT EXISTS `edirezione` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `edirezione`
--

INSERT INTO `edirezione` (`ID`) VALUES
(1);

-- --------------------------------------------------------

--
-- Struttura della tabella `emarketing`
--

CREATE TABLE IF NOT EXISTS `emarketing` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GiornoPaga` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `emarketing`
--

INSERT INTO `emarketing` (`ID`, `GiornoPaga`) VALUES
(1, 25);

-- --------------------------------------------------------

--
-- Struttura della tabella `eprogetto`
--

CREATE TABLE IF NOT EXISTS `eprogetto` (
  `IdProgetto` int(11) NOT NULL AUTO_INCREMENT,
  `EAziendaNomeAzienda` varchar(255) NOT NULL,
  `NomeProgetto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdProgetto`),
  KEY `FKEProgetto227142` (`EAziendaNomeAzienda`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `eprogetto`
--

INSERT INTO `eprogetto` (`IdProgetto`, `EAziendaNomeAzienda`, `NomeProgetto`) VALUES
(1, 'Ausbleden SpA', 'Progetto Arnaldo');

-- --------------------------------------------------------

--
-- Struttura della tabella `esottoprogetto`
--

CREATE TABLE IF NOT EXISTS `esottoprogetto` (
  `IdSottoprogetto` int(11) NOT NULL AUTO_INCREMENT,
  `EDipendenteCodiceFiscale` varchar(255) DEFAULT NULL,
  `EProgettoIdProgetto` int(11) NOT NULL,
  `NomeSottoprogetto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdSottoprogetto`),
  KEY `FKESottoprog284899` (`EProgettoIdProgetto`),
  KEY `FKESottoprog925786` (`EDipendenteCodiceFiscale`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `esottoprogetto`
--

INSERT INTO `esottoprogetto` (`IdSottoprogetto`, `EDipendenteCodiceFiscale`, `EProgettoIdProgetto`, `NomeSottoprogetto`) VALUES
(1, 'vttmtt', 1, 'Sottoprogetto Capocchia');

-- --------------------------------------------------------

--
-- Struttura della tabella `estipendio`
--

CREATE TABLE IF NOT EXISTS `estipendio` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ammontare` double NOT NULL,
  `Unita` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dump dei dati per la tabella `estipendio`
--

INSERT INTO `estipendio` (`ID`, `Ammontare`, `Unita`) VALUES
(1, 1500, 'euro'),
(2, 3000, 'euro'),
(3, 3000, 'euro/ora');

-- --------------------------------------------------------

--
-- Struttura della tabella `etariffa`
--

CREATE TABLE IF NOT EXISTS `etariffa` (
  `Quantita` double NOT NULL,
  `Unita` varchar(255) DEFAULT NULL,
  `EDipendenteCodiceFiscale` varchar(255) NOT NULL,
  `ETaskIdTask` int(11) NOT NULL,
  PRIMARY KEY (`EDipendenteCodiceFiscale`,`ETaskIdTask`),
  KEY `ETariffa` (`EDipendenteCodiceFiscale`),
  KEY `ETariffa2` (`ETaskIdTask`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `etariffa`
--

INSERT INTO `etariffa` (`Quantita`, `Unita`, `EDipendenteCodiceFiscale`, `ETaskIdTask`) VALUES
(4, 'euro/ora', 'lmbdnl89', 33),
(5, 'euro/ora', 'lmbdnl89', 34),
(100, 'euro/ora', 'lucfin', 32),
(2, 'euro/ora', 'lucfin', 34),
(6, 'euro/ora', 'lucfin', 35);

-- --------------------------------------------------------

--
-- Struttura della tabella `etask`
--

CREATE TABLE IF NOT EXISTS `etask` (
  `IdTask` int(11) NOT NULL AUTO_INCREMENT,
  `ESottoprogettoIdSottoprogetto` int(11) NOT NULL,
  `Descrizione` varchar(255) DEFAULT NULL,
  `NomeTask` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdTask`),
  KEY `FKETask442129` (`ESottoprogettoIdSottoprogetto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=36 ;

--
-- Dump dei dati per la tabella `etask`
--

INSERT INTO `etask` (`IdTask`, `ESottoprogettoIdSottoprogetto`, `Descrizione`, `NomeTask`) VALUES
(32, 1, 'Progetto Cicerone', 'Ingegneria del Software'),
(33, 1, 'Progetto Tarantino', 'Sistemi Interattivi'),
(34, 1, 'Progetto Pomante', 'Sistemi Embedded - 2012/2013'),
(35, 1, 'Progetto Santucci', 'Comunicazioni Wireless');

-- --------------------------------------------------------

--
-- Struttura della tabella `etimerecord`
--

CREATE TABLE IF NOT EXISTS `etimerecord` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EDipendenteCodiceFiscale` varchar(255) DEFAULT NULL,
  `ETaskIdTask` int(11) NOT NULL,
  `TimeInizio` date NOT NULL,
  `TimeFine` date NOT NULL,
  `Secondi` bigint(50) NOT NULL,
  `Descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKETimeRecor439226` (`ETaskIdTask`),
  KEY `FKETimeRecor456926` (`EDipendenteCodiceFiscale`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dump dei dati per la tabella `etimerecord`
--

INSERT INTO `etimerecord` (`ID`, `EDipendenteCodiceFiscale`, `ETaskIdTask`, `TimeInizio`, `TimeFine`, `Secondi`, `Descrizione`) VALUES
(21, 'lmbdnl89', 32, '2014-01-27', '2014-01-27', 9000000, 'Implementazione interfaccia'),
(22, 'lucfin', 32, '2014-01-27', '2014-01-27', 10800000, 'Implementazione server'),
(23, 'lmbdnl89', 33, '2014-01-28', '2014-01-28', 3600000, 'Mokup');

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `eazienda`
--
ALTER TABLE `eazienda`
  ADD CONSTRAINT `FKEAzienda275569` FOREIGN KEY (`EMarketingID`) REFERENCES `emarketing` (`ID`),
  ADD CONSTRAINT `FKEAzienda775837` FOREIGN KEY (`EDirezioneID`) REFERENCES `edirezione` (`ID`);

--
-- Limiti per la tabella `edipendente`
--
ALTER TABLE `edipendente`
  ADD CONSTRAINT `FKEDipendent364337` FOREIGN KEY (`EDirezioneID`) REFERENCES `edirezione` (`ID`),
  ADD CONSTRAINT `FKEDipendent992843` FOREIGN KEY (`EStipendioID`) REFERENCES `estipendio` (`ID`);

--
-- Limiti per la tabella `eprogetto`
--
ALTER TABLE `eprogetto`
  ADD CONSTRAINT `FKEProgetto227142` FOREIGN KEY (`EAziendaNomeAzienda`) REFERENCES `eazienda` (`NomeAzienda`);

--
-- Limiti per la tabella `esottoprogetto`
--
ALTER TABLE `esottoprogetto`
  ADD CONSTRAINT `FKESottoprog284899` FOREIGN KEY (`EProgettoIdProgetto`) REFERENCES `eprogetto` (`IdProgetto`),
  ADD CONSTRAINT `FKESottoprog925786` FOREIGN KEY (`EDipendenteCodiceFiscale`) REFERENCES `edipendente` (`CodiceFiscale`);

--
-- Limiti per la tabella `etariffa`
--
ALTER TABLE `etariffa`
  ADD CONSTRAINT `ETariffa` FOREIGN KEY (`EDipendenteCodiceFiscale`) REFERENCES `edipendente` (`CodiceFiscale`),
  ADD CONSTRAINT `ETariffa2` FOREIGN KEY (`ETaskIdTask`) REFERENCES `etask` (`IdTask`);

--
-- Limiti per la tabella `etask`
--
ALTER TABLE `etask`
  ADD CONSTRAINT `FKETask442129` FOREIGN KEY (`ESottoprogettoIdSottoprogetto`) REFERENCES `esottoprogetto` (`IdSottoprogetto`);

--
-- Limiti per la tabella `etimerecord`
--
ALTER TABLE `etimerecord`
  ADD CONSTRAINT `FKETimeRecor439226` FOREIGN KEY (`ETaskIdTask`) REFERENCES `etask` (`IdTask`),
  ADD CONSTRAINT `FKETimeRecor456926` FOREIGN KEY (`EDipendenteCodiceFiscale`) REFERENCES `edipendente` (`CodiceFiscale`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
