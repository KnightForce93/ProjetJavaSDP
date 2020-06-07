-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 07, 2020 at 10:48 AM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `projetjava`
--

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
(2, 10, '2020-03-03', '12:00:00', '13:30:00', 2, 2, 2),
(3, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Seance`
--
ALTER TABLE `Seance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cours` (`id_cours`),
  ADD KEY `id_type` (`id_type`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Seance`
--
ALTER TABLE `Seance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Seance`
--
ALTER TABLE `Seance`
  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`id_cours`) REFERENCES `Cours` (`id`),
  ADD CONSTRAINT `seance_ibfk_2` FOREIGN KEY (`id_type`) REFERENCES `Type_cours` (`id`);
