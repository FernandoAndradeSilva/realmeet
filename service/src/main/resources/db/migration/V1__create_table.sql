CREATE TABLE room
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    name   VARCHAR(20)           NOT NULL,
    seats  INT                   NOT NULL,
    active TINYINT(1)            NOT NULL,
    CONSTRAINT pk_room PRIMARY KEY (id)
);