--DROP TABLE TBL_USR;
--DROP TABLE TBL_MOVIE;
--DROP TABLE TBL_CINEMA;
--DROP TABLE TBL_SHOWTIME;
--DROP TABLE TBL_COMENTS;
--DROP TABLE TBL_ORDER;

--select * from TBL_USR;
CREATE TABLE TBL_USR (
	ACCOUNTNAME VARCHAR(20) NOT NULL CONSTRAINT ACCOUNTNAME_PK PRIMARY KEY,
	PASSWORD VARCHAR(20),
	EMAIL VARCHAR(100),
	NICKNAME VARCHAR(20),
	FIRSTNAME VARCHAR(20),
	LASTNAME VARCHAR(20),
	BIRTHDAY VARCHAR(30), --
	FAVOURITEGENRE VARCHAR(1000),
	FAVOURITECAST VARCHAR(1000),
	status varchar(20),
	ROLE varchar(2)
);

CREATE TABLE TBL_MOVIE (
	Title VARCHAR(40) NOT NULL CONSTRAINT Title_pk PRIMARY KEY ,
	Poster VARCHAR(20) ,
	actors VARCHAR(300),
	Genre VARCHAR(300) NOT NULL,
	Director VARCHAR(50),
	Synopsis VARCHAR(1000),
	AGEOFRATING VARCHAR(3),
	rating VARCHAR(4),
	NUMBEROFRATING VARCHAR(10),
	relaseDate date
);

--select * from TBL_MOVIE;

create table TBL_CINEMA(
Location varchar(100) not null constraint location_pk primary key,
Capacity varchar(20) not null,
Amenities varchar(20) not null
);

--select * from TBL_CINEMA	;

CREATE TABLE TBL_SHOWTIME(

	PrimekyNumber SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY,
	
	Title VARCHAR(40),
	Location VARCHAR(100),
	SeatLeft varchar(20),
	ShowingDate date,
	ShowingTime time,
	CONSTRAINT fk_location FOREIGN KEY (Location) REFERENCES TBL_CINEMA(Location),
	CONSTRAINT fk_title FOREIGN KEY (Title) REFERENCES TBL_MOVIE(Title),
	PRIMARY KEY(Location,ShowingDate,ShowingTime)
);

--select * from TBL_SHOWTIME;

---Select * from TBL_ORDER where ACCOUNTNAME = 'a';


create table TBL_COMENTS(
NICKNAME varchar(20) not null,
RATING VARCHAR(1) NOT NULL,
Title varchar(40) not null,
CONSTRAINT fk_titleComm FOREIGN KEY (Title) REFERENCES TBL_MOVIE(Title),
COMDATE DATE not null,
COMTIME time not null,
Reviews varchar(1000) not null,
PRIMARY KEY(NICKNAME,COMDATE,COMTIME)
);

--select * from TBL_COMENTS;





create table TBL_ORDER(
	PrimekyNumber SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY,
	ACCOUNTNAME VARCHAR(20) NOT NULL ,
	Title VARCHAR(40) not null,
	tickets varchar(20),
	Location varchar(100) not null,
	constraint fk_titleOrder foreign key(Title) references TBL_MOVIE(Title),
	constraint fk_locations foreign key(Location) references TBL_CINEMA(Location),
	constraint fk_ACCOUNT foreign key(ACCOUNTNAME) references TBL_USR(ACCOUNTNAME),
	ShowingDate date,
	ShowingTime time,
	PRIMARY KEY(PrimekyNumber)
);