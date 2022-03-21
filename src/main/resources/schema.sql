create table if not exists Users (
login varchar(32) not null,
password varchar(32) not null,
rating integer not null,
createdAt timestamp not null
);

create table if not exists GameSession(
playerOne varchar(32) not null,
playerTwo varchar(32) not null,
boardId bigint not null,
createdAt timestamp not null
);

create table if not exists Board(
id identity,
holes integer array[24] not null,
isWhite binary array[24]
);

alter table GameSession
    add foreign key (playerOne) references Users(login);
alter table GameSession
    add foreign key (playerTwo) references Users(login);
alter table GameSession
    add foreign key (boardId) references Board(id);




