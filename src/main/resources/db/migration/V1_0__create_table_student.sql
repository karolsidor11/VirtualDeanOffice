DROP TABLE IF EXISTS `student`;

CREATE TABLE `student`
(
    `id`          bigint        (20)        NOT NULL,
    `uuid`        binary        (255)       DEFAULT NULL,
    `city`        varchar       (255)       DEFAULT NULL,
    `country`     varchar       (255)       DEFAULT NULL,
    `houseNumber` int           (11)        DEFAULT NULL,
    `street`      varchar       (255)       DEFAULT NULL,
    `zipCode`     varchar       (255)       DEFAULT NULL,
    `email`       varchar       (255)       DEFAULT NULL,
    `gender`      varchar       (255)       DEFAULT NULL,
    `lastName`    varchar       (255)       DEFAULT NULL,
    `name`        varchar       (255)       DEFAULT NULL,
    `password`    varchar       (255)       DEFAULT NULL,
    `version`     bigint        (20)        DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8