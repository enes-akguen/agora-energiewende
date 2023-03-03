-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 03. Mrz 2023 um 03:51
-- Server-Version: 10.4.27-MariaDB
-- PHP-Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `agora_energiewende`
--
CREATE DATABASE `agora_energiewende`; 
USE `agora_energiewende`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `t_emission_factor`
--

CREATE TABLE `t_emission_factor` (
  `date` datetime NOT NULL,
  `emission_factor` tinytext DEFAULT NULL,
  `absolute_emission` tinytext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `t_energy_source`
--

CREATE TABLE `t_energy_source` (
  `date` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `energy` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `t_emission_factor`
--
ALTER TABLE `t_emission_factor`
  ADD PRIMARY KEY (`date`);

--
-- Indizes für die Tabelle `t_energy_source`
--
ALTER TABLE `t_energy_source`
  ADD PRIMARY KEY (`date`,`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
