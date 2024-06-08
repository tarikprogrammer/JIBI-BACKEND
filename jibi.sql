-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le : sam. 08 juin 2024 à 13:19
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `jibi`
--

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

CREATE TABLE `account` (
  `plafond` int(11) NOT NULL,
  `solde` double NOT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `ref` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`plafond`, `solde`, `client_id`, `id`, `ref`) VALUES
(5000, 0.10911009996731479, 1, 1, '5418108581514011102117916192917151117147824'),
(5000, 4829.5, 2, 2, '3183152261320243492371426311121717813213318');

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `agence_entity`
--

CREATE TABLE `agence_entity` (
  `agence_id` bigint(20) NOT NULL,
  `agence_name` varchar(255) DEFAULT NULL,
  `numero_pattente` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `agence_entity`
--

INSERT INTO `agence_entity` (`agence_id`, `agence_name`, `numero_pattente`) VALUES
(1, 'JIBI', 'JIBI4563');

-- --------------------------------------------------------

--
-- Structure de la table `agent`
--

CREATE TABLE `agent` (
  `agence_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `addresse` varchar(255) DEFAULT NULL,
  `date_naissance` varchar(255) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `numero_de_piece_identite` varchar(255) DEFAULT NULL,
  `numero_imm` varchar(255) DEFAULT NULL,
  `numero_patente` varchar(255) DEFAULT NULL,
  `piece_identite` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `agent`
--

INSERT INTO `agent` (`agence_id`, `id`, `addresse`, `date_naissance`, `file`, `fname`, `lname`, `numero_de_piece_identite`, `numero_imm`, `numero_patente`, `piece_identite`) VALUES
(1, 1, 'casa', '2024-05-22', 'images.jpg', 'tarik', 'belaid', 'MJ14905', '64646', 'JIBI4563', 'CIN');

-- --------------------------------------------------------

--
-- Structure de la table `agent_profile`
--

CREATE TABLE `agent_profile` (
  `agent_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `agent_profile`
--

INSERT INTO `agent_profile` (`agent_id`, `id`, `email`, `image_url`, `password`, `phone`, `username`) VALUES
(1, 1, 'tarikbelaid1233@gmail.com', 'Mon_image.png', 'belaid', '0777871239', 'tarik');

-- --------------------------------------------------------

--
-- Structure de la table `client_entity`
--

CREATE TABLE `client_entity` (
  `id` bigint(20) NOT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `addresse` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `numero_de_piece_identite` varchar(255) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  `piece_identite` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `client_entity`
--

INSERT INTO `client_entity` (`id`, `account_type`, `addresse`, `fname`, `lname`, `nationality`, `numero_de_piece_identite`, `file`, `piece_identite`) VALUES
(1, 'account de 5000DH', 'casa', 'Mouhssine', 'belaid', 'Morocco', 'MJ14905', NULL, NULL),
(2, 'account de 5000DH', 'CASA', 'achraf', 'belaid', NULL, 'MJ14905', NULL, '');

-- --------------------------------------------------------

--
-- Structure de la table `creance_entity`
--

CREATE TABLE `creance_entity` (
  `id` bigint(20) NOT NULL,
  `creance` varchar(255) DEFAULT NULL,
  `ref` varchar(255) DEFAULT NULL,
  `creancier_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `creance_entity`
--

INSERT INTO `creance_entity` (`id`, `creance`, `ref`, `creancier_id`) VALUES
(1, 'TELEPHONE ET INTERNET ', '13010138933421013137', 1),
(2, 'SIM', '1313310108586123653', 1),
(3, 'PRODUIT INTERNET SIM', '21124591114013197', 2),
(4, 'PRODUIT FIXE SIM', '39190121298041313', 2),
(5, 'PRODUIT MOBILE SIM', '11331786910849133', 2),
(6, 'FACTURES REDAL', '496731110247021013', 3),
(7, 'FACTURES AMENDIS ', '803109126111134625', 4),
(8, 'TANGER', '1101201011113036107', 4),
(9, 'FACTURES ALCS', '11124117129144117120', 5);

-- --------------------------------------------------------

--
-- Structure de la table `creancier_entity`
--

CREATE TABLE `creancier_entity` (
  `creancier_id` bigint(20) NOT NULL,
  `impayes` varchar(255) DEFAULT NULL,
  `logo_creancier` varchar(255) DEFAULT NULL,
  `logo_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `creancier_entity`
--

INSERT INTO `creancier_entity` (`creancier_id`, `impayes`, `logo_creancier`, `logo_name`) VALUES
(1, '10%', 'marocTelecome.png', 'IAM RECHARGES'),
(2, '12%', 'marocTelecome.png', 'IAM FACTURES'),
(3, '11.5%', 'redal.png', 'REDAL'),
(4, '13%', 'amendis.jpeg', 'AMENDIS TANGER'),
(5, '14%', 'alcs.png', 'ALCS');

-- --------------------------------------------------------

--
-- Structure de la table `otp`
--

CREATE TABLE `otp` (
  `id` bigint(20) NOT NULL,
  `otp` varchar(255) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `otp`
--

INSERT INTO `otp` (`id`, `otp`, `client_id`) VALUES
(1, '244673', 1);

-- --------------------------------------------------------

--
-- Structure de la table `profile_client`
--

CREATE TABLE `profile_client` (
  `client_id` bigint(20) DEFAULT NULL,
  `profile_id` bigint(20) NOT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `profile_client`
--

INSERT INTO `profile_client` (`client_id`, `profile_id`, `cover`, `email`, `password`, `phone`) VALUES
(1, 1, 'Mon_image.png', 'mouh@gmail.com', 'tarik', '0777871239'),
(2, 2, 'Mon_image.png', 'achraf@gmail.com', 'taroik', '0666343536');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_27blqkeba8ylg8ondsf5j5fmm` (`client_id`);

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `agence_entity`
--
ALTER TABLE `agence_entity`
  ADD PRIMARY KEY (`agence_id`);

--
-- Index pour la table `agent`
--
ALTER TABLE `agent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr2pu6lq4b52hob7i0boc18369` (`agence_id`);

--
-- Index pour la table `agent_profile`
--
ALTER TABLE `agent_profile`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_618ryqj0bguha5n4i7rw38khw` (`agent_id`);

--
-- Index pour la table `client_entity`
--
ALTER TABLE `client_entity`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `creance_entity`
--
ALTER TABLE `creance_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsjmrjm0kv8mnhlkvi0pc7ttmp` (`creancier_id`);

--
-- Index pour la table `creancier_entity`
--
ALTER TABLE `creancier_entity`
  ADD PRIMARY KEY (`creancier_id`);

--
-- Index pour la table `otp`
--
ALTER TABLE `otp`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_t7dce8a0bf30qpc86fn6p2jqd` (`client_id`);

--
-- Index pour la table `profile_client`
--
ALTER TABLE `profile_client`
  ADD PRIMARY KEY (`profile_id`),
  ADD KEY `FKbvxyx303lvtkrqnjq64kvh5oy` (`client_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `account`
--
ALTER TABLE `account`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `agence_entity`
--
ALTER TABLE `agence_entity`
  MODIFY `agence_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `agent`
--
ALTER TABLE `agent`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `agent_profile`
--
ALTER TABLE `agent_profile`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `client_entity`
--
ALTER TABLE `client_entity`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `creance_entity`
--
ALTER TABLE `creance_entity`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `creancier_entity`
--
ALTER TABLE `creancier_entity`
  MODIFY `creancier_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `otp`
--
ALTER TABLE `otp`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `profile_client`
--
ALTER TABLE `profile_client`
  MODIFY `profile_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FK4iv39neci4ix7pq8o74oxutrp` FOREIGN KEY (`client_id`) REFERENCES `client_entity` (`id`);

--
-- Contraintes pour la table `agent`
--
ALTER TABLE `agent`
  ADD CONSTRAINT `FKr2pu6lq4b52hob7i0boc18369` FOREIGN KEY (`agence_id`) REFERENCES `agence_entity` (`agence_id`);

--
-- Contraintes pour la table `agent_profile`
--
ALTER TABLE `agent_profile`
  ADD CONSTRAINT `id` FOREIGN KEY (`agent_id`) REFERENCES `agent` (`id`);

--
-- Contraintes pour la table `creance_entity`
--
ALTER TABLE `creance_entity`
  ADD CONSTRAINT `FKsjmrjm0kv8mnhlkvi0pc7ttmp` FOREIGN KEY (`creancier_id`) REFERENCES `creancier_entity` (`creancier_id`);

--
-- Contraintes pour la table `otp`
--
ALTER TABLE `otp`
  ADD CONSTRAINT `FKtgwds5vqcjeqckv8kq9e47inu` FOREIGN KEY (`client_id`) REFERENCES `client_entity` (`id`);

--
-- Contraintes pour la table `profile_client`
--
ALTER TABLE `profile_client`
  ADD CONSTRAINT `FKbvxyx303lvtkrqnjq64kvh5oy` FOREIGN KEY (`client_id`) REFERENCES `client_entity` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
