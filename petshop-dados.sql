-- phpMyAdmin SQL Dump
-- version 4.3.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 05, 2015 at 03:25 PM
-- Server version: 5.5.44-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `petshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `agenda`
--

CREATE TABLE IF NOT EXISTS `agenda` (
  `codigo` int(11) NOT NULL,
  `data_hora` datetime NOT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `entrada_animal` tinyint(1) NOT NULL DEFAULT '0',
  `saida_animal` tinyint(1) NOT NULL DEFAULT '0',
  `valor_total` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agenda`
--

INSERT INTO `agenda` (`codigo`, `data_hora`, `descricao`, `entrada_animal`, `saida_animal`, `valor_total`) VALUES
(1, '2015-10-05 09:00:00', 'Pagamento no cartão', 0, 0, 0),
(2, '2015-10-23 13:00:00', NULL, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `agenda_animal`
--

CREATE TABLE IF NOT EXISTS `agenda_animal` (
  `agenda_codigo` int(11) NOT NULL,
  `animal_codigo` int(11) NOT NULL,
  `procedimento_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agenda_animal`
--

INSERT INTO `agenda_animal` (`agenda_codigo`, `animal_codigo`, `procedimento_id`) VALUES
(1, 1, 3),
(1, 2, 4),
(2, 3, 2),
(2, 3, 6);

-- --------------------------------------------------------

--
-- Table structure for table `animal`
--

CREATE TABLE IF NOT EXISTS `animal` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `tipo` varchar(25) NOT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `cor_predominante` varchar(25) NOT NULL,
  `dono_codigo` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `animal`
--

INSERT INTO `animal` (`codigo`, `nome`, `data_nascimento`, `tipo`, `descricao`, `cor_predominante`, `dono_codigo`) VALUES
(1, 'Bidu', '2015-08-12', 'CACHORRO', NULL, 'PRETO', 1),
(2, 'Totó', '2015-06-17', 'CACHORRO', 'Cachorro muito dócil!', 'BRANCO', 1),
(3, 'Félix', '2015-04-14', 'GATO', '', 'CINZA', 2),
(4, 'Luma', '2015-01-01', 'CACHORRO', 'adsadad', 'CARAMELO', 5);

-- --------------------------------------------------------

--
-- Table structure for table `dono`
--

CREATE TABLE IF NOT EXISTS `dono` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `tel_residencial` varchar(15) DEFAULT NULL,
  `tel_celular` varchar(15) NOT NULL,
  `email` varchar(60) NOT NULL,
  `data_nascimento` date DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dono`
--

INSERT INTO `dono` (`codigo`, `nome`, `cpf`, `tel_residencial`, `tel_celular`, `email`, `data_nascimento`) VALUES
(1, 'João', '11111111111', '5556677', '9998877', 'joao@gmail.com', '2000-10-13'),
(2, 'Maria', '22222222222', '5558899', '9993344', 'maria@gmail.com', '1990-10-24'),
(5, 'Rafael', '33344455566', '555', '666', 'abc@abc.com', '1979-02-21');

-- --------------------------------------------------------

--
-- Table structure for table `procedimento`
--

CREATE TABLE IF NOT EXISTS `procedimento` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(250) NOT NULL,
  `preco` double NOT NULL,
  `ativo` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `procedimento`
--

INSERT INTO `procedimento` (`codigo`, `nome`, `descricao`, `preco`, `ativo`) VALUES
(1, 'Banho', '', 80, 1),
(2, 'Banho + Tosa higiênica', '', 95, 1),
(3, 'Banho + Tosa de raça', '', 110, 1),
(4, 'Vacina anti-rábica', '', 45, 1),
(5, 'Banho + Hidratação', '', 90, 1),
(6, 'Corte de unhas', '', 35, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `agenda_animal`
--
ALTER TABLE `agenda_animal`
  ADD PRIMARY KEY (`agenda_codigo`,`animal_codigo`,`procedimento_id`), ADD KEY `animal_fk` (`animal_codigo`), ADD KEY `procedimento_fk` (`procedimento_id`);

--
-- Indexes for table `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`codigo`), ADD UNIQUE KEY `nome` (`nome`,`dono_codigo`), ADD KEY `dono_fk` (`dono_codigo`);

--
-- Indexes for table `dono`
--
ALTER TABLE `dono`
  ADD PRIMARY KEY (`codigo`), ADD UNIQUE KEY `email` (`email`), ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Indexes for table `procedimento`
--
ALTER TABLE `procedimento`
  ADD PRIMARY KEY (`codigo`), ADD UNIQUE KEY `nome` (`nome`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agenda`
--
ALTER TABLE `agenda`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `animal`
--
ALTER TABLE `animal`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `dono`
--
ALTER TABLE `dono`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT for table `procedimento`
--
ALTER TABLE `procedimento`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `agenda_animal`
--
ALTER TABLE `agenda_animal`
ADD CONSTRAINT `procedimento_fk` FOREIGN KEY (`procedimento_id`) REFERENCES `procedimento` (`codigo`),
ADD CONSTRAINT `agenda_fk` FOREIGN KEY (`agenda_codigo`) REFERENCES `agenda` (`codigo`),
ADD CONSTRAINT `animal_fk` FOREIGN KEY (`animal_codigo`) REFERENCES `animal` (`codigo`);

--
-- Constraints for table `animal`
--
ALTER TABLE `animal`
ADD CONSTRAINT `dono_fk` FOREIGN KEY (`dono_codigo`) REFERENCES `dono` (`codigo`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;