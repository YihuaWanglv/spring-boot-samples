CREATE DATABASE IF NOT EXISTS `passport_0`;

CREATE TABLE IF NOT EXISTS `passport_0`.`user_0` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `passport_0`.`user_1` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE DATABASE IF NOT EXISTS `passport_1`;

CREATE TABLE IF NOT EXISTS `passport_1`.`user_0` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `passport_1`.`user_1` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

