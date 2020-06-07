-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 07, 2020 at 07:23 PM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `projetjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `cours`
--

CREATE TABLE `cours` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cours`
--

INSERT INTO `cours` (`id`, `nom`) VALUES
(1, 'POO Java'),
(2, 'English'),
(5, 'Probabilités'),
(6, 'Analyse'),
(7, 'Droit'),
(8, 'Electronique');

-- --------------------------------------------------------

--
-- Table structure for table `enseignant`
--

CREATE TABLE `enseignant` (
  `id_utilisateur` int(11) DEFAULT NULL,
  `id_cours` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `enseignant`
--

INSERT INTO `enseignant` (`id_utilisateur`, `id_cours`) VALUES
(1, 1),
(2, 1),
(6, 2),
(7, 5),
(8, 6),
(11, 7),
(12, 8),
(13, 5);

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

CREATE TABLE `etudiant` (
  `id_utilisateur` int(11) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `id_groupe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`id_utilisateur`, `numero`, `id_groupe`) VALUES
(4, 111, 1),
(5, 222, 2);

-- --------------------------------------------------------

--
-- Table structure for table `groupe`
--

CREATE TABLE `groupe` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `id_promotion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groupe`
--

INSERT INTO `groupe` (`id`, `nom`, `id_promotion`) VALUES
(1, 'TD02', 1),
(2, 'TD01', 2);

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE `promotion` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`id`, `nom`) VALUES
(1, '2022'),
(2, '2023'),
(3, '2024');

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

CREATE TABLE `salle` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `capacite` int(11) DEFAULT NULL,
  `id_site` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `salle`
--

INSERT INTO `salle` (`id`, `nom`, `capacite`, `id_site`) VALUES
(1, 'EM210', 70, 1),
(2, 'P446', 41, 2),
(3, 'C110', 15, 3),
(4, 'G035', 100, 4),
(5, 'P328', 40, 2),
(6, 'P400', 16, 2),
(7, 'EM510', 38, 1),
(8, 'SC215', 74, 1),
(9, 'C210', 33, 3),
(10, 'C340', 89, 3),
(11, 'G010', 57, 4),
(12, 'G012', 90, 4),
(13, 'L222', 67, 5);

-- --------------------------------------------------------

--
-- Table structure for table `seance`
--

CREATE TABLE `seance` (
  `id` int(11) NOT NULL,
  `semaine` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `heure_debut` time DEFAULT NULL,
  `heure_fin` time DEFAULT NULL,
  `etat` int(11) DEFAULT NULL,
  `id_cours` int(11) DEFAULT NULL,
  `id_type` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seance`
--

INSERT INTO `seance` (`id`, `semaine`, `date`, `heure_debut`, `heure_fin`, `etat`, `id_cours`, `id_type`) VALUES
(1, 10, '2020-03-02', '08:30:00', '10:00:00', 2, 1, 1),
(2, 10, '2020-03-03', '12:00:00', '13:45:00', 2, 2, 2),
(3, 10, '2020-03-04', '08:30:00', '10:00:00', 1, 2, 1),
(4, 10, '2020-03-02', '10:15:00', '11:45:00', 2, 5, 6),
(5, 10, '2020-03-03', '15:30:00', '17:00:00', 3, 6, 4),
(6, 10, '2020-03-05', '12:00:00', '13:30:00', 2, 7, 2),
(7, 10, '2020-03-05', '15:30:00', '17:00:00', 2, 8, 3),
(8, 11, '2020-03-09', '08:30:00', '10:00:00', 2, 1, 5),
(9, 11, '2020-03-11', '12:00:00', '13:30:00', 2, 5, 1),
(10, 11, '2020-03-13', '15:30:00', '17:00:00', 3, 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `seance_enseignants`
--

CREATE TABLE `seance_enseignants` (
  `id_seance` int(11) DEFAULT NULL,
  `id_enseignant` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seance_enseignants`
--

INSERT INTO `seance_enseignants` (`id_seance`, `id_enseignant`) VALUES
(1, 1),
(2, 6),
(3, 6),
(4, 7),
(5, 8),
(6, 11),
(7, 12),
(8, 1),
(9, 13),
(10, 11);

-- --------------------------------------------------------

--
-- Table structure for table `seance_groupes`
--

CREATE TABLE `seance_groupes` (
  `id_seance` int(11) DEFAULT NULL,
  `id_groupe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seance_groupes`
--

INSERT INTO `seance_groupes` (`id_seance`, `id_groupe`) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 1),
(7, 2),
(8, 2),
(9, 2),
(7, 1),
(10, 2);

-- --------------------------------------------------------

--
-- Table structure for table `seance_salles`
--

CREATE TABLE `seance_salles` (
  `id_seance` int(11) DEFAULT NULL,
  `id_salle` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seance_salles`
--

INSERT INTO `seance_salles` (`id_seance`, `id_salle`) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 10),
(5, 8),
(6, 11),
(7, 13),
(8, 6),
(9, 12),
(10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `site`
--

CREATE TABLE `site` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `site`
--

INSERT INTO `site` (`id`, `nom`) VALUES
(1, 'E1'),
(2, 'E2'),
(3, 'E3'),
(4, 'E4'),
(5, 'E5'),
(6, 'CNAM');

-- --------------------------------------------------------

--
-- Table structure for table `type_cours`
--

CREATE TABLE `type_cours` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `type_cours`
--

INSERT INTO `type_cours` (`id`, `nom`) VALUES
(1, 'CM'),
(2, 'TD'),
(3, 'TP'),
(4, 'Soutien'),
(5, 'Projet'),
(6, 'Examen');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `droit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `passwd`, `nom`, `prenom`, `droit`) VALUES
(1, 'jp.segado@ece.fr', '1234', 'SEGADO', 'JP', 2),
(2, 'a.ziane@ece.fr', '1234', 'ZIANE', 'A', 3),
(3, 'admin@ece.fr', '1234', 'ADMIN', 'ADMIN', 1),
(4, 'l.donikian@ece.fr', '1234', 'DONIKIAN', 'L', 4),
(5, 't.popielski@ece.fr', '1234', 'POPIELSKI', 'T', 4),
(6, 'm.leonard@ece.fr', '1234', 'LEONARD', 'M', 3),
(7, 'l.lecor@ece.fr', '1234', 'LECOR', 'L', 2),
(8, 'f.coudray@ece.fr', '1234', 'COUDRAY', 'F', 2),
(11, 'y.maupile@ece.fr', '1234', 'MAUPILE', 'Y', 3),
(12, 'a.mokhber@ece.fr', '1234', 'MOKHBER', 'A', 2),
(13, 'l.delisle@ece.fr', '1234', 'DELISLE', 'L', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `enseignant`
--
ALTER TABLE `enseignant`
  ADD KEY `id_utilisateur` (`id_utilisateur`),
  ADD KEY `id_cours` (`id_cours`);

--
-- Indexes for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD KEY `id_utilisateur` (`id_utilisateur`),
  ADD KEY `id_groupe` (`id_groupe`);

--
-- Indexes for table `groupe`
--
ALTER TABLE `groupe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_promotion` (`id_promotion`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_site` (`id_site`);

--
-- Indexes for table `seance`
--
ALTER TABLE `seance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cours` (`id_cours`),
  ADD KEY `id_type` (`id_type`);

--
-- Indexes for table `seance_enseignants`
--
ALTER TABLE `seance_enseignants`
  ADD KEY `id_seance` (`id_seance`),
  ADD KEY `id_enseignant` (`id_enseignant`);

--
-- Indexes for table `seance_groupes`
--
ALTER TABLE `seance_groupes`
  ADD KEY `id_seance` (`id_seance`),
  ADD KEY `id_groupe` (`id_groupe`);

--
-- Indexes for table `seance_salles`
--
ALTER TABLE `seance_salles`
  ADD KEY `id_seance` (`id_seance`),
  ADD KEY `id_salle` (`id_salle`);

--
-- Indexes for table `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_cours`
--
ALTER TABLE `type_cours`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cours`
--
ALTER TABLE `cours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `groupe`
--
ALTER TABLE `groupe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `promotion`
--
ALTER TABLE `promotion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `salle`
--
ALTER TABLE `salle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `seance`
--
ALTER TABLE `seance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `site`
--
ALTER TABLE `site`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `type_cours`
--
ALTER TABLE `type_cours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `enseignant_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `enseignant_ibfk_2` FOREIGN KEY (`id_cours`) REFERENCES `cours` (`id`);

--
-- Constraints for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `etudiant_ibfk_2` FOREIGN KEY (`id_groupe`) REFERENCES `groupe` (`id`);

--
-- Constraints for table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `groupe_ibfk_1` FOREIGN KEY (`id_promotion`) REFERENCES `promotion` (`id`);

--
-- Constraints for table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_ibfk_1` FOREIGN KEY (`id_site`) REFERENCES `site` (`id`);

--
-- Constraints for table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`id_cours`) REFERENCES `cours` (`id`),
  ADD CONSTRAINT `seance_ibfk_2` FOREIGN KEY (`id_type`) REFERENCES `type_cours` (`id`);

--
-- Constraints for table `seance_enseignants`
--
ALTER TABLE `seance_enseignants`
  ADD CONSTRAINT `seance_enseignants_ibfk_1` FOREIGN KEY (`id_seance`) REFERENCES `seance` (`id`),
  ADD CONSTRAINT `seance_enseignants_ibfk_2` FOREIGN KEY (`id_enseignant`) REFERENCES `utilisateur` (`id`);

--
-- Constraints for table `seance_groupes`
--
ALTER TABLE `seance_groupes`
  ADD CONSTRAINT `seance_groupes_ibfk_1` FOREIGN KEY (`id_seance`) REFERENCES `seance` (`id`),
  ADD CONSTRAINT `seance_groupes_ibfk_2` FOREIGN KEY (`id_groupe`) REFERENCES `groupe` (`id`);

--
-- Constraints for table `seance_salles`
--
ALTER TABLE `seance_salles`
  ADD CONSTRAINT `seance_salles_ibfk_1` FOREIGN KEY (`id_seance`) REFERENCES `seance` (`id`),
  ADD CONSTRAINT `seance_salles_ibfk_2` FOREIGN KEY (`id_salle`) REFERENCES `salle` (`id`);
