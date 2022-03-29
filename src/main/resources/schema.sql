create table if not exists Users (
username varchar(32) not null,
password varchar(32) not null,
rating integer not null,
createdAt timestamp not null
);

create table if not exists GameSession(
id identity,
playerOne varchar(32) not null,
playerTwo varchar(32) not null,
boardId bigint not null,
createdAt timestamp not null,
holes varchar(30) not null
);

alter table GameSession
    add foreign key (playerOne) references Users(username);
alter table GameSession
    add foreign key (playerTwo) references Users(username);



