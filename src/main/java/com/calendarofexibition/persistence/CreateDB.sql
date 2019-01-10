/*CREATE SCHEMA `calendarofexpositions` ;*/

/*CREATE TABLE users*/
create table users
(
  UserId       int auto_increment
    primary key,
  UserRole     varchar(10) not null,
  UserLogin    varchar(30) not null,
  UserPassword varchar(20) not null,
  IsActive     tinyint(1)  not null,
  constraint users_UserId_uindex
  unique (UserId),
  constraint users_UserLogin_uindex
  unique (UserLogin)
);
)
  ENGINE = InnoDB;

/*CREATE TABLE consumers*/
create table consumers
(
  UserId      int         not null,
  name        varchar(30) not null,
  surname     varchar(30) null,
  spendMoney  double      null,
  discount    double      null,
  email       varchar(30) not null,
  phoneNumber varchar(20) null,
  constraint consumers_UserId_uindex
  unique (UserId),
  constraint consumers_email_uindex
  unique (email),
  constraint consumers_phoneNumber_uindex
  unique (phoneNumber),
  constraint consumerId
  foreign key (UserId) references users (UserId)
);



/*CREATE TABLE events*/
create table events
(
  eventId       int auto_increment
    primary key,
  title         varchar(40)   not null,
  theme         varchar(40)   null,
  startDate     date          not null,
  endDate       date          not null,
  price         double        not null,
  pathToPicture varchar(40)   null,
  description   varchar(2000) null,
  hallid        int           not null,
  constraint Events_eventId_uindex
  unique (eventId)
);

/*CREATE TABLE expolhalls*/
create table expohalls
(
  hallId      int auto_increment
    primary key,
  name        varchar(30) not null,
  isAvailable tinyint(1)  not null,
  freePlaces  int         not null,
  constraint ExplHalls_hallId_uindex
  unique (hallId)
);


/*CREATE TABLE orders*/
create table orders
(
  orderId    int auto_increment
    primary key,
  consumerId int not null,
  ticketId   int not null,
  constraint Order_orderId_uindex
  unique (orderId),
  constraint orderconsumerId
  foreign key (consumerId) references consumers (UserId),
  constraint OrderTicketId
  foreign key (ticketId) references tickets (ticketId)
);

create index OrderTicketId
  on orders (ticketId);

create index orderconsumerId
  on orders (consumerId);

/*CREATE TABLE tickets*/
create table tickets
(
  ticketId     int auto_increment
    primary key,
  `key`        varchar(32) not null,
  eventId      int         not null,
  constraint ticket_ticketId_uindex
  unique (ticketId),
  constraint Ticket_FK
  foreign key (ticketId) references events (eventId)
);



INSERT INTO `calendarofexposition`.`admins` (`UserId`, `isActive`) VALUES (1, 1);
INSERT INTO `calendarofexposition`.`consumers` (`UserId`, `name`, `surname`, `spendMoney`, `discount`, `email`, `phoneNumber`) VALUES (2, 'Ivan', 'Ivanov', 200, 0, 'Ivan.Ivanov@gmail.com', '+380633216743');

INSERT INTO calendarofexposition.users (UserRole, UserLogin, UserPassword, isActive) VALUES ('admin', 'admin', 'admin', 1);
INSERT INTO calendarofexposition.users (UserRole, UserLogin, UserPassword, isActive) VALUES ('consumer', 'consumer', 'consumer', 1);



SELECT * FROM consumers WHERE UserId IN (SELECT UserId FROM users
WHERE UserLogin = 'consumer' and UserPassword = 'consumer');

INSERT INTO calendarofexposition.users (UserRole, UserLogin, UserPassword, isActive) VALUES ('consumer', ?, ?, 1);
INSERT INTO calendarofexposition.consumers(UserId, name, surname, spendMoney, discount, email, phoneNumber) VALUES (());

START TRANSACTION;
INSERT INTO users (UserRole, UserLogin, UserPassword, IsActive)
  VALUES('consumer', 'testLogin', 'testPassword', 1);
INSERT INTO consumers (userid, name, surname, spendMoney, discount, email, phoneNumber)
  VALUES(LAST_INSERT_ID(), 'Petro', 'Petrov', 22, 0, 'Petro.Petrov@gmail.com', '+380637867678');
COMMIT;

 INSERT INTO users (UserRole, UserLogin, UserPassword, IsActive)VALUES('consumer', 'Natasha', 'pass', 1);

SELECT * FROM users WHERE UserLogin  = ? and UserPassword  = ?;
SELECT * FROM users WHERE UserLogin = ? and UserPassword = ?;