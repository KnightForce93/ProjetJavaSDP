-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 06, 2020 at 03:41 PM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `projetjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `Cours`
--

CREATE TABLE `Cours` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Cours`
--

INSERT INTO `Cours` (`id`, `nom`) VALUES
(1, 'POO Java'),
(2, 'English');

-- --------------------------------------------------------

--
-- Table structure for table `Enseignant`
--

CREATE TABLE `Enseignant` (
  `id_utilisateur` int(11) DEFAULT NULL,
  `id_cours` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Enseignant`
--

INSERT INTO `Enseignant` (`id_utilisateur`, `id_cours`) VALUES
(1, 1),
(2, 1),
(6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Etudiant`
--

CREATE TABLE `Etudiant` (
  `id_utilisateur` int(11) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `id_groupe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Etudiant`
--

INSERT INTO `Etudiant` (`id_utilisateur`, `numero`, `id_groupe`) VALUES
(4, 111, 1),
(5, 222, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Groupe`
--

CREATE TABLE `Groupe` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `id_promotion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Groupe`
--

INSERT INTO `Groupe` (`id`, `nom`, `id_promotion`) VALUES
(1, 'TD02', 1),
(2, 'TD01', 2);

-- --------------------------------------------------------

--
-- Table structure for table `Promotion`
--

CREATE TABLE `Promotion` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Promotion`
--

INSERT INTO `Promotion` (`id`, `nom`) VALUES
(1, '2022'),
(2, '2023'),
(3, '2024');

-- --------------------------------------------------------

--
-- Table structure for table `Salle`
--

CREATE TABLE `Salle` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `capacite` int(11) DEFAULT NULL,
  `id_site` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Salle`
--

INSERT INTO `Salle` (`id`, `nom`, `capacite`, `id_site`) VALUES
(1, 'EM210', 70, 1),
(2, 'P446', 41, 2),
(3, 'C110', 15, 3),
(4, 'G035', 100, 4);

-- --------------------------------------------------------

--
-- Table structure for table `Seance`
--

CREATE TABLE `Seance` (
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
-- Dumping data for table `Seance`
--

INSERT INTO `Seance` (`id`, `semaine`, `date`, `heure_debut`, `heure_fin`, `etat`, `id_cours`, `id_type`) VALUES
(1, 10, '2020-03-02', '08:30:00', '10:00:00', 2, 1, 1),
(2, 10, '2020-03-03', '11:45:00', '13:45:00', 2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Seance_enseignants`
--

CREATE TABLE `Seance_enseignants` (
  `id_seance` int(11) DEFAULT NULL,
  `id_enseignant` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Seance_enseignants`
--

INSERT INTO `Seance_enseignants` (`id_seance`, `id_enseignant`) VALUES
(1, 1),
(2, 6);

-- --------------------------------------------------------

--
-- Table structure for table `Seance_groupes`
--

CREATE TABLE `Seance_groupes` (
  `id_seance` int(11) DEFAULT NULL,
  `id_groupe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Seance_groupes`
--

INSERT INTO `Seance_groupes` (`id_seance`, `id_groupe`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Seance_salles`
--

CREATE TABLE `Seance_salles` (
  `id_seance` int(11) DEFAULT NULL,
  `id_salle` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Seance_salles`
--

INSERT INTO `Seance_salles` (`id_seance`, `id_salle`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Site`
--

CREATE TABLE `Site` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Site`
--

INSERT INTO `Site` (`id`, `nom`) VALUES
(1, 'E1'),
(2, 'E2'),
(3, 'E3'),
(4, 'E4'),
(5, 'E5'),
(6, 'CNAM');

-- --------------------------------------------------------

--
-- Table structure for table `Type_cours`
--

CREATE TABLE `Type_cours` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Type_cours`
--

INSERT INTO `Type_cours` (`id`, `nom`) VALUES
(1, 'CM'),
(2, 'TD'),
(3, 'TP'),
(4, 'Soutien'),
(5, 'Projet'),
(6, 'Examen');

-- --------------------------------------------------------

--
-- Table structure for table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `droit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Utilisateur`
--

INSERT INTO `Utilisateur` (`id`, `email`, `passwd`, `nom`, `prenom`, `droit`) VALUES
(1, 'jp.segado@ece.fr', '1234', 'SEGADO', 'JP', 2),
(2, 'a.ziane@ece.fr', '1234', 'ZIANE', 'A', 3),
(3, 'admin@ece.fr', '1234', 'ADMIN', 'ADMIN', 1),
(4, 'l.donikian@ece.fr', '1234', 'DONIKIAN', 'L', 4),
(5, 't.popielski@ece.fr', '1234', 'POPIELSKI', 'T', 4),
(6, 'm.leonard@ece.fr', '1234', 'LEONARD', 'M', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Cours`
--
ALTER TABLE `Cours`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Enseignant`
--
ALTER TABLE `Enseignant`
  ADD KEY `id_utilisateur` (`id_utilisateur`),
  ADD KEY `id_cours` (`id_cours`);

--
-- Indexes for table `Etudiant`
--
ALTER TABLE `Etudiant`
  ADD KEY `id_utilisateur` (`id_utilisateur`),
  ADD KEY `id_groupe` (`id_groupe`);

--
-- Indexes for table `Groupe`
--
ALTER TABLE `Groupe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_promotion` (`id_promotion`);

--
-- Indexes for table `Promotion`
--
ALTER TABLE `Promotion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Salle`
--
ALTER TABLE `Salle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_site` (`id_site`);

--
-- Indexes for table `Seance`
--
ALTER TABLE `Seance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cours` (`id_cours`),
  ADD KEY `id_type` (`id_type`);

--
-- Indexes for table `Seance_enseignants`
--
ALTER TABLE `Seance_enseignants`
  ADD KEY `id_seance` (`id_seance`),
  ADD KEY `id_enseignant` (`id_enseignant`);

--
-- Indexes for table `Seance_groupes`
--
ALTER TABLE `Seance_groupes`
  ADD KEY `id_seance` (`id_seance`),
  ADD KEY `id_groupe` (`id_groupe`);

--
-- Indexes for table `Seance_salles`
--
ALTER TABLE `Seance_salles`
  ADD KEY `id_seance` (`id_seance`),
  ADD KEY `id_salle` (`id_salle`);

--
-- Indexes for table `Site`
--
ALTER TABLE `Site`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Type_cours`
--
ALTER TABLE `Type_cours`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Cours`
--
ALTER TABLE `Cours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Groupe`
--
ALTER TABLE `Groupe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Promotion`
--
ALTER TABLE `Promotion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Salle`
--
ALTER TABLE `Salle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Seance`
--
ALTER TABLE `Seance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Site`
--
ALTER TABLE `Site`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `Type_cours`
--
ALTER TABLE `Type_cours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Enseignant`
--
ALTER TABLE `Enseignant`
  ADD CONSTRAINT `enseignant_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `Utilisateur` (`id`),
  ADD CONSTRAINT `enseignant_ibfk_2` FOREIGN KEY (`id_cours`) REFERENCES `Cours` (`id`);

--
-- Constraints for table `Etudiant`
--
ALTER TABLE `Etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `Utilisateur` (`id`),
  ADD CONSTRAINT `etudiant_ibfk_2` FOREIGN KEY (`id_groupe`) REFERENCES `Groupe` (`id`);

--
-- Constraints for table `Groupe`
--
ALTER TABLE `Groupe`
  ADD CONSTRAINT `groupe_ibfk_1` FOREIGN KEY (`id_promotion`) REFERENCES `Promotion` (`id`);

--
-- Constraints for table `Salle`
--
ALTER TABLE `Salle`
  ADD CONSTRAINT `salle_ibfk_1` FOREIGN KEY (`id_site`) REFERENCES `Site` (`id`);

--
-- Constraints for table `Seance`
--
ALTER TABLE `Seance`
  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`id_cours`) REFERENCES `Cours` (`id`),
  ADD CONSTRAINT `seance_ibfk_2` FOREIGN KEY (`id_type`) REFERENCES `Type_cours` (`id`);

--
-- Constraints for table `Seance_enseignants`
--
ALTER TABLE `Seance_enseignants`
  ADD CONSTRAINT `seance_enseignants_ibfk_1` FOREIGN KEY (`id_seance`) REFERENCES `Seance` (`id`),
  ADD CONSTRAINT `seance_enseignants_ibfk_2` FOREIGN KEY (`id_enseignant`) REFERENCES `Utilisateur` (`id`);

--
-- Constraints for table `Seance_groupes`
--
ALTER TABLE `Seance_groupes`
  ADD CONSTRAINT `seance_groupes_ibfk_1` FOREIGN KEY (`id_seance`) REFERENCES `Seance` (`id`),
  ADD CONSTRAINT `seance_groupes_ibfk_2` FOREIGN KEY (`id_groupe`) REFERENCES `Groupe` (`id`);

--
-- Constraints for table `Seance_salles`
--
ALTER TABLE `Seance_salles`
  ADD CONSTRAINT `seance_salles_ibfk_1` FOREIGN KEY (`id_seance`) REFERENCES `Seance` (`id`),
  ADD CONSTRAINT `seance_salles_ibfk_2` FOREIGN KEY (`id_salle`) REFERENCES `Salle` (`id`);
