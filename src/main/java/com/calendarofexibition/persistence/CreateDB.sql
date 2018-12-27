/*CREATE SCHEMA `calendarofexpositions` ;*/

/*use calendarofexpositions;*/

CREATE TABLE role
(
    roleId int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username varchar(40) NOT NULL,
    role varchar(10) NOT NULL
);
CREATE UNIQUE INDEX role_roleId_uindex ON role (roleId);
CREATE UNIQUE INDEX role_username_uindex ON role (username);

INSERT INTO calendarofexpositions.role (username, role) VALUES ('admin', 'admin')
INSERT INTO calendarofexpositions.role (username, role) VALUES ('consumer', 'consumer')
