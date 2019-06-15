# Host: localhost  (Version 5.5.5-10.1.16-MariaDB)
# Date: 2019-06-15 20:33:03
# Generator: MySQL-Front 5.4  (Build 3.46)
# Internet: http://www.mysqlfront.de/

/*!40101 SET NAMES utf8 */;

#
# Structure for table "books"
#

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `nama_buku` varchar(30) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `deskripsi` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for table "categories"
#

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `tipe` varchar(30) NOT NULL,
  `deskripsi` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
