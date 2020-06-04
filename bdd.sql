CREATE TABLE `Utilisateur` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `email` varchar(255),
  `passwd` varchar(255),
  `nom` varchar(255),
  `prenom` varchar(255),
  `droit` int
);

CREATE TABLE `Promotion` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255)
);

CREATE TABLE `Groupe` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255),
  `id_promotion` int
);

CREATE TABLE `Etudiant` (
  `id_utilisateur` int,
  `numero` int,
  `id_groupe` int
);

CREATE TABLE `Cours` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255)
);

CREATE TABLE `Type_cours` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255)
);

CREATE TABLE `Enseignant` (
  `id_utilisateur` int,
  `id_cours` int
);

CREATE TABLE `Site` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255)
);

CREATE TABLE `Salle` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255),
  `capacite` int,
  `id_site` int
);

CREATE TABLE `Seance` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `semaine` int,
  `date` date,
  `heure_debut` datetime,
  `heure_fin` datetime,
  `etat` int,
  `id_cours` int,
  `id_type` int
);

CREATE TABLE `Seance_groupes` (
  `id_seance` int,
  `id_groupe` int
);

CREATE TABLE `Seance_enseignants` (
  `id_seance` int,
  `id_enseignant` int
);

CREATE TABLE `Seance_salles` (
  `id_seance` int,
  `id_salle` int
);

ALTER TABLE `Groupe` ADD FOREIGN KEY (`id_promotion`) REFERENCES `Promotion` (`id`);

ALTER TABLE `Etudiant` ADD FOREIGN KEY (`id_utilisateur`) REFERENCES `Utilisateur` (`id`);

ALTER TABLE `Etudiant` ADD FOREIGN KEY (`id_groupe`) REFERENCES `Groupe` (`id`);

ALTER TABLE `Enseignant` ADD FOREIGN KEY (`id_utilisateur`) REFERENCES `Utilisateur` (`id`);

ALTER TABLE `Cours` ADD FOREIGN KEY (`id`) REFERENCES `Enseignant` (`id_cours`);

ALTER TABLE `Salle` ADD FOREIGN KEY (`id_site`) REFERENCES `Site` (`id`);

ALTER TABLE `Seance` ADD FOREIGN KEY (`id_cours`) REFERENCES `Cours` (`id`);

ALTER TABLE `Seance` ADD FOREIGN KEY (`id_type`) REFERENCES `Type_cours` (`id`);

ALTER TABLE `Seance_groupes` ADD FOREIGN KEY (`id_seance`) REFERENCES `Seance` (`id`);

ALTER TABLE `Seance_groupes` ADD FOREIGN KEY (`id_groupe`) REFERENCES `Groupe` (`id`);

ALTER TABLE `Seance_enseignants` ADD FOREIGN KEY (`id_seance`) REFERENCES `Seance` (`id`);

ALTER TABLE `Seance_enseignants` ADD FOREIGN KEY (`id_enseignant`) REFERENCES `Utilisateur` (`id`);

ALTER TABLE `Seance_salles` ADD FOREIGN KEY (`id_seance`) REFERENCES `Seance` (`id`);

ALTER TABLE `Seance_salles` ADD FOREIGN KEY (`id_salle`) REFERENCES `Salle` (`id`);
