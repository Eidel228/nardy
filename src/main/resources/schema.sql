create table if not exists Users (
login varchar(32) not null,
password varchar(32) not null,
createdAt timestamp not null,
rating bigint not null,
gameSession bigint not null
);

create table if not exists Game_Session(
id identity,
playerOne varchar(32) not null,
playerTwo varchar(32) not null,
createdAt timestamp not null,
holes int array[24]
);

alter table Game_Session
    add foreign key (playerOne) references Users(login);
alter table Game_Session
    add foreign key (playerTwo) references Users(login);

alter table Users
    add foreign key (gameSession) references Game_Session(id);



