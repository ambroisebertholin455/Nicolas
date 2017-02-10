-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 10, 2017 at 01:46 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inscription`
--

-- --------------------------------------------------------

--
-- Table structure for table `dossier`
--

CREATE TABLE `dossier` (
  `ID` varchar(10) NOT NULL,
  `LETTRE_TRANSFER` varchar(5) NOT NULL,
  `RELEVE_NOTE_UT_SORTANTE` varchar(5) NOT NULL,
  `COPIE_DIPLOME` varchar(5) NOT NULL,
  `ATTESTATION_UT_SORT` varchar(5) NOT NULL,
  `CODE_INSCRIPTION` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dossier`
--

INSERT INTO `dossier` (`ID`, `LETTRE_TRANSFER`, `RELEVE_NOTE_UT_SORTANTE`, `COPIE_DIPLOME`, `ATTESTATION_UT_SORT`, `CODE_INSCRIPTION`) VALUES
('TVA22MS-22', 'Oui', 'Oui', 'Oui', 'Oui', 'TVA82MS-98'),
('TVA78MS-85', 'Oui', 'Oui', 'Oui', 'Oui', 'TVA82MS-98');

-- --------------------------------------------------------

--
-- Table structure for table `enseignement_primaire`
--

CREATE TABLE `enseignement_primaire` (
  `ID` varchar(10) NOT NULL DEFAULT '',
  `DATE_DEBUT` date DEFAULT NULL,
  `DATE_FIN` date DEFAULT NULL,
  `ETABLISSEMNT_A` varchar(30) DEFAULT NULL,
  `ETABLISSEMNT_B` varchar(30) DEFAULT NULL,
  `ETABLISSEMNT_C` varchar(30) DEFAULT NULL,
  `CODE_INSCRIPTION` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enseignement_primaire`
--

INSERT INTO `enseignement_primaire` (`ID`, `DATE_DEBUT`, `DATE_FIN`, `ETABLISSEMNT_A`, `ETABLISSEMNT_B`, `ETABLISSEMNT_C`, `CODE_INSCRIPTION`) VALUES
('TVA63MS-20', '2008-09-21', '2017-02-01', 'OUI', 'OUI', 'OUI', 'TVA82MS-98'),
('TVA93MS-36', '2008-09-21', '2017-02-01', 'OUI', 'OUI', 'OUI', 'TVA82MS-98');

-- --------------------------------------------------------

--
-- Table structure for table `enseignement_secondaire`
--

CREATE TABLE `enseignement_secondaire` (
  `ID` varchar(10) NOT NULL DEFAULT '',
  `DATE_DEBUT` date DEFAULT NULL,
  `DATE_FIN` date DEFAULT NULL,
  `ETABLISSEMNT_A` varchar(30) DEFAULT NULL,
  `ETABLISSEMNT_B` varchar(30) DEFAULT NULL,
  `ETABLISSEMNT_C` varchar(30) DEFAULT NULL,
  `CODE_INSCRIPTION` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enseignement_secondaire`
--

INSERT INTO `enseignement_secondaire` (`ID`, `DATE_DEBUT`, `DATE_FIN`, `ETABLISSEMNT_A`, `ETABLISSEMNT_B`, `ETABLISSEMNT_C`, `CODE_INSCRIPTION`) VALUES
('TVA39MS-48', '2008-09-21', '2017-02-01', 'OUI', 'OUI', 'OUI', 'TVA82MS-98');

-- --------------------------------------------------------

--
-- Table structure for table `enseignement_universitaire`
--

CREATE TABLE `enseignement_universitaire` (
  `ID` varchar(10) NOT NULL DEFAULT '',
  `DATE_DEBUT` date DEFAULT NULL,
  `DATE_FIN` date DEFAULT NULL,
  `ETABLISSEMNT_A` varchar(30) DEFAULT NULL,
  `ETABLISSEMNT_B` varchar(30) DEFAULT NULL,
  `ETABLISSEMNT_C` varchar(30) DEFAULT NULL,
  `CODE_INSCRIPTION` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enseignement_universitaire`
--

INSERT INTO `enseignement_universitaire` (`ID`, `DATE_DEBUT`, `DATE_FIN`, `ETABLISSEMNT_A`, `ETABLISSEMNT_B`, `ETABLISSEMNT_C`, `CODE_INSCRIPTION`) VALUES
('TVA95MS-62', '2008-09-21', '2017-02-01', 'OUI', 'OUI', 'OUI', 'TVA82MS-98');

-- --------------------------------------------------------

--
-- Table structure for table `inscription`
--

CREATE TABLE `inscription` (
  `CODE_INSCRIPTION` varchar(10) NOT NULL DEFAULT '',
  `NOM` varchar(20) NOT NULL,
  `PRENOM` varchar(20) NOT NULL,
  `DATE_NAISSANCE` date NOT NULL,
  `LIEU_NAISSANCE` varchar(20) NOT NULL,
  `NIF_CIN` varchar(10) NOT NULL,
  `DATE_INSCRIPTION` date NOT NULL,
  `NO_ORDRE_BACC` varchar(10) NOT NULL,
  `STATUT_MATRIMONIAL` varchar(10) NOT NULL,
  `ADRESSE` varchar(30) NOT NULL,
  `TELEPHONE` varchar(12) NOT NULL,
  `REFERENCE_ETRANGE` varchar(10) NOT NULL,
  `PAYS` varchar(255) NOT NULL,
  `DICIPLINE_CHOISIE` varchar(255) NOT NULL,
  `GROUPE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inscription`
--

INSERT INTO `inscription` (`CODE_INSCRIPTION`, `NOM`, `PRENOM`, `DATE_NAISSANCE`, `LIEU_NAISSANCE`, `NIF_CIN`, `DATE_INSCRIPTION`, `NO_ORDRE_BACC`, `STATUT_MATRIMONIAL`, `ADRESSE`, `TELEPHONE`, `REFERENCE_ETRANGE`, `PAYS`, `DICIPLINE_CHOISIE`, `GROUPE`) VALUES
('Phili22', 'Phili', 'Ashley', '1992-09-14', 'Chancerelle', '01-1992-0', '2017-02-12', '0101012265', 'Celiba', 'Montagne noire', '47510810', 'Moi mem', 'Haiti', 'Sc informatique', 'median'),
('TVA82MS-98', 'Phili', 'Ashley', '1992-09-14', 'Chancerelle', '01-1992-0', '2017-02-12', '0101012265', 'Celiba', 'Montagne noire', '47510810', 'Moi mem', 'Haiti', 'Sc informatique', 'median');

-- --------------------------------------------------------

--
-- Table structure for table `lien_parente`
--

CREATE TABLE `lien_parente` (
  `ID` varchar(11) NOT NULL,
  `NOM` varchar(20) NOT NULL,
  `PRENOM` varchar(255) NOT NULL,
  `LIEN_PARENTE` varchar(255) NOT NULL,
  `CODE_INSCRIPTION` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lien_parente`
--

INSERT INTO `lien_parente` (`ID`, `NOM`, `PRENOM`, `LIEN_PARENTE`, `CODE_INSCRIPTION`) VALUES
('TVA90MS-41', 'Phili', 'Jean', 'pere', 'TVA82MS-98');

-- --------------------------------------------------------

--
-- Table structure for table `pieces`
--

CREATE TABLE `pieces` (
  `ID` varchar(10) NOT NULL,
  `PHOTOCOPIE_CERTIFICAT_BACC` varchar(5) NOT NULL,
  `RELEVE_NOTE_BACC` varchar(5) NOT NULL,
  `PHOTOCOPIE_ACTE_NAISSACEE` varchar(5) NOT NULL,
  `CERTIFICAT_VIE_MOEURS` varchar(5) NOT NULL,
  `PHOTO_EDENTITE` varchar(5) NOT NULL,
  `CODE_INSCRIPTION` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pieces`
--

INSERT INTO `pieces` (`ID`, `PHOTOCOPIE_CERTIFICAT_BACC`, `RELEVE_NOTE_BACC`, `PHOTOCOPIE_ACTE_NAISSACEE`, `CERTIFICAT_VIE_MOEURS`, `PHOTO_EDENTITE`, `CODE_INSCRIPTION`) VALUES
('TVA56MS-38', 'oui', 'oui', 'oui', 'oui', 'oui', 'TVA82MS-98');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dossier`
--
ALTER TABLE `dossier`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_INSCRIPTION_D` (`CODE_INSCRIPTION`);

--
-- Indexes for table `enseignement_primaire`
--
ALTER TABLE `enseignement_primaire`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_INSCRIPTION_P` (`CODE_INSCRIPTION`);

--
-- Indexes for table `enseignement_secondaire`
--
ALTER TABLE `enseignement_secondaire`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_INSCRIPTION_S` (`CODE_INSCRIPTION`);

--
-- Indexes for table `enseignement_universitaire`
--
ALTER TABLE `enseignement_universitaire`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_INSCRIPTION_U` (`CODE_INSCRIPTION`);

--
-- Indexes for table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`CODE_INSCRIPTION`);

--
-- Indexes for table `lien_parente`
--
ALTER TABLE `lien_parente`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_INSCRIPTION_L` (`CODE_INSCRIPTION`);

--
-- Indexes for table `pieces`
--
ALTER TABLE `pieces`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_INSCRIPTION_I` (`CODE_INSCRIPTION`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dossier`
--
ALTER TABLE `dossier`
  ADD CONSTRAINT `FK_INSCRIPTION_D` FOREIGN KEY (`CODE_INSCRIPTION`) REFERENCES `inscription` (`CODE_INSCRIPTION`) ON DELETE CASCADE;

--
-- Constraints for table `enseignement_primaire`
--
ALTER TABLE `enseignement_primaire`
  ADD CONSTRAINT `FK_INSCRIPTION_P` FOREIGN KEY (`CODE_INSCRIPTION`) REFERENCES `inscription` (`CODE_INSCRIPTION`) ON DELETE CASCADE;

--
-- Constraints for table `enseignement_secondaire`
--
ALTER TABLE `enseignement_secondaire`
  ADD CONSTRAINT `FK_INSCRIPTION_S` FOREIGN KEY (`CODE_INSCRIPTION`) REFERENCES `inscription` (`CODE_INSCRIPTION`) ON DELETE CASCADE;

--
-- Constraints for table `enseignement_universitaire`
--
ALTER TABLE `enseignement_universitaire`
  ADD CONSTRAINT `FK_INSCRIPTION_U` FOREIGN KEY (`CODE_INSCRIPTION`) REFERENCES `inscription` (`CODE_INSCRIPTION`) ON DELETE CASCADE;

--
-- Constraints for table `lien_parente`
--
ALTER TABLE `lien_parente`
  ADD CONSTRAINT `FK_INSCRIPTION_L` FOREIGN KEY (`CODE_INSCRIPTION`) REFERENCES `inscription` (`CODE_INSCRIPTION`) ON DELETE CASCADE;

--
-- Constraints for table `pieces`
--
ALTER TABLE `pieces`
  ADD CONSTRAINT `FK_INSCRIPTION_I` FOREIGN KEY (`CODE_INSCRIPTION`) REFERENCES `inscription` (`CODE_INSCRIPTION`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
