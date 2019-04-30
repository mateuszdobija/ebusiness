# --- !Ups
CREATE TABLE `Category` (
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Publisher` (
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `surname` varchar(80) NOT NULL,
  `nacionality` varchar(80) NOT NULL,
  `birth_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Audiobook` (
  `isbn` varchar(13) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author_id` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `language` varchar(80) DEFAULT NULL,
  `pages_number` int(11) DEFAULT NULL,
  `category` varchar(80) DEFAULT NULL,
  `publisher` varchar(80) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`isbn`),
  KEY `category` (`category`),
  KEY `publisher` (`publisher`),
  CONSTRAINT `Audiobook_ibfk_1` FOREIGN KEY (`category`) REFERENCES `Category` (`name`),
  CONSTRAINT `Audiobook_ibfk_2` FOREIGN KEY (`publisher`) REFERENCES `Publisher` (`name`),
  CONSTRAINT `Audiobook_ibfk_3` FOREIGN KEY (`author_id`) REFERENCES `Author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `Book` (
  `isbn` varchar(13) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author_id` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `language` varchar(80) DEFAULT NULL,
  `pages_number` int(11) DEFAULT NULL,
  `category` varchar(80) DEFAULT NULL,
  `publisher` varchar(80) DEFAULT NULL,
  `description` text,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  KEY `category` (`category`),
  KEY `publisher` (`publisher`),
  CONSTRAINT `Books_ibfk_1` FOREIGN KEY (`category`) REFERENCES `Category` (`name`),
  CONSTRAINT `Books_ibfk_2` FOREIGN KEY (`publisher`) REFERENCES `Publisher` (`name`),
  CONSTRAINT `Books_ibfk_3` FOREIGN KEY (`author_id`) REFERENCES `Author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Ebook` (
  `isbn` varchar(13) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author_id` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `language` varchar(80) DEFAULT NULL,
  `pages_number` int(11) DEFAULT NULL,
  `category` varchar(80) DEFAULT NULL,
  `publisher` varchar(80) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`isbn`),
  KEY `category` (`category`),
  KEY `publisher` (`publisher`),
  CONSTRAINT `Ebook_ibfk_1` FOREIGN KEY (`category`) REFERENCES `Category` (`name`),
  CONSTRAINT `Ebook_ibfk_2` FOREIGN KEY (`publisher`) REFERENCES `Publisher` (`name`),
  CONSTRAINT `Ebook_ibfk_3` FOREIGN KEY (`author_id`) REFERENCES `Author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `surname` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# --- !Downs

DROP TABLE IF EXISTS `Audiobook`;