-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 09-Maio-2018 às 02:32
-- Versão do servidor: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loja_de_cd v2`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `adm`
--

CREATE TABLE `adm` (
  `id_adm` int(8) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `adm`
--

INSERT INTO `adm` (`id_adm`, `nome`, `login`, `senha`) VALUES
(1, 'witallo', 'witallo', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cd`
--

CREATE TABLE `cd` (
  `id_cd` int(8) NOT NULL,
  `id_genero` int(8) NOT NULL,
  `capa` varchar(50) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `preco` varchar(50) NOT NULL,
  `anoLancamento` varchar(50) NOT NULL,
  `disponibilidade` varchar(50) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `artista` varchar(50) NOT NULL,
  `musica` varchar(50) NOT NULL,
  `promocao` int(10) NOT NULL,
  `desconto` varchar(50) NOT NULL,
  `por` varchar(50) NOT NULL,
  `venda` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cd`
--

INSERT INTO `cd` (`id_cd`, `id_genero`, `capa`, `titulo`, `preco`, `anoLancamento`, `disponibilidade`, `descricao`, `artista`, `musica`, `promocao`, `desconto`, `por`, `venda`) VALUES
(5, 1, 'cadu', 'cadu', '19.90', '2018', '20', 'bom', 'luan', 'fucaracao', 0, '10', '', ''),
(6, 1, 'objeto', 'objeto', '19.90', '2019', '20', 'bom', 'luan', 'meteoro', 1, '10', '', ''),
(8, 1, 'cadu', 'cadu', '19.90', '2018', '20', 'bom', 'luan', 'fucaracao', 0, '10', '', ''),
(9, 1, 'cadu', 'cadu', '19.90', '2018', '20', 'bom', 'luan', 'fucaracao', 0, '10', '', ''),
(12, 1, 'objeto', 'objeto', '19.90', '2019', '20', 'bom', 'luan', 'meteoro', 1, '10', '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(8) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `sobreNome` varchar(50) NOT NULL,
  `telefone` varchar(50) NOT NULL,
  `cpf` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nome`, `sobreNome`, `telefone`, `cpf`, `email`, `login`, `senha`) VALUES
(1, 'losca', 'silva', '1234567890', '1234567890', 'lucas@gmail.com', 'lucas', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `genero`
--

CREATE TABLE `genero` (
  `id_genero` int(10) NOT NULL,
  `nomeGenero` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `genero`
--

INSERT INTO `genero` (`id_genero`, `nomeGenero`) VALUES
(1, 'pop');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adm`
--
ALTER TABLE `adm`
  ADD PRIMARY KEY (`id_adm`);

--
-- Indexes for table `cd`
--
ALTER TABLE `cd`
  ADD PRIMARY KEY (`id_cd`),
  ADD KEY `id_genero` (`id_genero`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id_genero`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adm`
--
ALTER TABLE `adm`
  MODIFY `id_adm` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `cd`
--
ALTER TABLE `cd`
  MODIFY `id_cd` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `genero`
--
ALTER TABLE `genero`
  MODIFY `id_genero` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cd`
--
ALTER TABLE `cd`
  ADD CONSTRAINT `cd_ibfk_1` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id_genero`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
