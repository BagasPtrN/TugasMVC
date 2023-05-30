-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2023 at 11:35 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ps_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `ps_rent`
--

CREATE TABLE `ps_rent` (
  `nama` varchar(50) NOT NULL,
  `vip` varchar(10) NOT NULL,
  `tipe` varchar(10) NOT NULL,
  `lama` float NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ps_rent`
--

INSERT INTO `ps_rent` (`nama`, `vip`, `tipe`, `lama`, `id`) VALUES
('amin', 'VIP', 'PS 4', 3.5, 111),
('abdul', 'Reguler', 'PS 5', 2, 112),
('qory', 'Reguler', 'PS 5', 2, 119),
('ido', 'VIP', 'PS 5', 5, 120);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ps_rent`
--
ALTER TABLE `ps_rent`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
