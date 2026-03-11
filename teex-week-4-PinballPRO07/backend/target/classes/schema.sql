DROP TABLE IF EXISTS `ansie`.`openexamquestions`;
DROP TABLE IF EXISTS `ansie`.`mcexamoptions`;
DROP TABLE IF EXISTS `ansie`.`mcexamquestions`;

CREATE TABLE `openexamquestions`
(
    `id`          bigint      NOT NULL AUTO_INCREMENT,
    `title`       varchar(255) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    `published`   tinyint(1) DEFAULT NULL,
    `type`        varchar(45) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `mcexamquestions`
(
    `id`          bigint      NOT NULL AUTO_INCREMENT,
    `title`       varchar(255) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    `published`   tinyint(1) DEFAULT NULL,
    `type`        varchar(45) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `mcexamoptions`
(
    `id`               bigint       NOT NULL AUTO_INCREMENT,
    `mcexamquestionid` bigint DEFAULT NULL,
    `option`           varchar(255) NOT NULL,
    `correct`          tinyint(1) NOT NULL,
    PRIMARY KEY (`id`),
    KEY                `mcexamquestionid_idx` (`mcexamquestionid`),
    CONSTRAINT `mcexamquestionid` FOREIGN KEY (`mcexamquestionid`) REFERENCES `mcexamquestions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

