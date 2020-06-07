-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 07, 2020 at 07:16 PM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `projetjava`
--

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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `seance`
--
ALTER TABLE `seance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cours` (`id_cours`),
  ADD KEY `id_type` (`id_type`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `seance`
--
ALTER TABLE `seance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`id_cours`) REFERENCES `cours` (`id`),
  ADD CONSTRAINT `seance_ibfk_2` FOREIGN KEY (`id_type`) REFERENCES `type_cours` (`id`);