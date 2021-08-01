-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 01, 2021 at 10:01 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `covid-19`
--

-- --------------------------------------------------------

--
-- Table structure for table `slotbooking`
--

CREATE TABLE `slotbooking` (
  `bookid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `aadhar` varchar(14) DEFAULT NULL,
  `1stSlotDate` date DEFAULT NULL,
  `vaccine` varchar(20) DEFAULT NULL,
  `2ndDoseDate` date DEFAULT NULL,
  `1stdose` varchar(10) DEFAULT 'Not Taken',
  `2nddose` varchar(10) DEFAULT 'Not Taken'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `slotbooking`
--

INSERT INTO `slotbooking` (`bookid`, `userid`, `name`, `gender`, `dob`, `aadhar`, `1stSlotDate`, `vaccine`, `2ndDoseDate`, `1stdose`, `2nddose`) VALUES
(5, 2, 'Ankit Prakash', 'Male', '1999-07-17', 'ABCD-EFGH-IJKL', '2021-08-06', 'Covaxine', NULL, 'Taken', 'Not Taken'),
(7, 7, 'Anurag Chowdhari', 'Male', '2000-06-01', '1234-5678-9101', '2021-09-08', 'Covishield', NULL, 'Not Taken', 'Not Taken'),
(8, 7, 'Yash Sen', 'Male', '2001-07-17', '1010-1111-1111', '2021-08-04', 'Covaxine', NULL, 'Not Taken', 'Not Taken'),
(9, 7, 'Gwen Stacy', 'Female', '2002-07-06', '7612-1221-1111', '2021-08-31', 'Covaxine', NULL, 'Taken', 'Not Taken');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `type` varchar(15) DEFAULT NULL,
  `1stdoseused` int(11) DEFAULT NULL,
  `2nddoseused` int(11) DEFAULT NULL,
  `1stdoseavailable` int(11) DEFAULT NULL,
  `2nddoseavailable` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`type`, `1stdoseused`, `2nddoseused`, `1stdoseavailable`, `2nddoseavailable`) VALUES
('Covaxine', 3, 1, 98, 99),
('Covishield', 0, 0, 100, 100);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userid` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `name`, `username`, `password`, `gender`, `address`, `role`) VALUES
(2, 'Ankit Prakash', 'ankit_1242', 'abc*', 'Male', '19, Jagriti Nagar Varanasi', 'Admin'),
(7, 'Anshuman Singh', 'anshu', '1234', 'Male', 'DLW Varanasi', 'Regular Login');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `slotbooking`
--
ALTER TABLE `slotbooking`
  ADD PRIMARY KEY (`bookid`),
  ADD KEY `userid` (`userid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `slotbooking`
--
ALTER TABLE `slotbooking`
  MODIFY `bookid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `slotbooking`
--
ALTER TABLE `slotbooking`
  ADD CONSTRAINT `slotbooking_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
