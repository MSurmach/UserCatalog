CREATE TABLE users
(
    id        SMALLSERIAL PRIMARY KEY NOT NULL,
    login     VARCHAR(64),
    password  VARCHAR(64),
    firstname VARCHAR(64),
    lastname  VARCHAR(64),
    address   VARCHAR(64),
    birthday  DATE,
    about     TEXT
)