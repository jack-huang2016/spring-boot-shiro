
CREATE TABLE `test_user` (
  `id` int(11) NOT NULL,
  `password` varchar(100) NOT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `user_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `test_role` (
  `id` int(11) NOT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `test_permission` (
  `id` int(11) NOT NULL,
  `permission_name` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `test_role_permission` (
  `id` int(11) NOT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `test_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `test_role` (`id`),
  CONSTRAINT `test_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `test_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `test_user_role` (
  `id` int(11) NOT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `test_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `test_user` (`id`),
  CONSTRAINT `test_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `test_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


