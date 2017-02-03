
--role 1 for user

/*
CREATE TABLE TBL_USR (
	ACCOUNTNAME VARCHAR(20) NOT NULL CONSTRAINT ACCOUNTNAME_PK PRIMARY KEY,
	PASSWORD VARCHAR(20),
	EMAIL VARCHAR(100),
	NICKNAME VARCHAR(20),
	FIRSTNAME VARCHAR(20),
	LASTNAME VARCHAR(20),
	BIRTHDAY VARCHAR(30), --
	FAVOURITEGENRE VARCHAR(30),
	FAVOURITECAST VARCHAR(30),
	status varchar(20),
	ROLE varchar(2)
);

*/


--Select * from TBL_USR where ACCOUNTNAME ='qiaofeng'
--update TBL_USR set FIRSTNAME = 'maomao' ,LASTNAME = 'nihaoma' , NICKNAME = '',status = 'yes' where ACCOUNTNAME = 'qiaofeng'

INSERT INTO TBL_USR VALUES ('a','123','yimuxia@gmail.com','bazhang','ba','zhang','1989','xiaoge','dashen','yes','1');
INSERT INTO TBL_USR VALUES ('b','123','hanjiji@gmail.com','miejuezhang','miejue','zhang','1989','xiaoge','dashen','no','1');
INSERT INTO TBL_USR VALUES ('c','123','huangjiji@gmail.com','lingbobu','lingbo','zhang','1989','xiaoge','dashen','no','1');
INSERT INTO TBL_USR VALUES ('manager','123','yimuxia@gmail.com','bazhang','ba','zhang','1989','xiaoge','dashen','yes','2');	



/*
CREATE TABLE TBL_MOVIE (
	Title VARCHAR(40) NOT NULL CONSTRAINT Title_pk PRIMARY KEY ,
	Poster VARCHAR(20) ,
	actors VARCHAR(300),
	Genre VARCHAR(300) NOT NULL,
	Director VARCHAR(50),
	Synopsis VARCHAR(1000),
	AGEOFRATING VARCHAR(1),
	rating VARCHAR(1),
	NUMBEROFRATING VARCHAR(10),
	relaseDate date
);
*/	

--select * from TBL_MOVIE
--where Title like '%TR%';

--update TBL_MOVIE set rating = ? where Title = ?

--now showing 
--METROPOLIS rate 5

--Select * from TBL_MOVIE where  UPPER(Genre) like '%DRAM%'

INSERT INTO TBL_MOVIE VALUES ('METROPOLIS',
'pMETROPOLIS','wangzhou,huangshuo,hanjiji,xiaopang',
'Drama , Action & Adventure , Art House & International , Classics , Science Fiction & Fantasy','David Dobkin',
'Big city lawyer Hank Palmer returns to his childhood home where his father, nnects with his estranged family','7',
'5','1','2014-06-14');  

INSERT INTO TBL_MOVIE VALUES ('THE ADVENTURES OF ROBIN HOOD',
'pADVENTURES','wangzhou,huangshuo,hanjiji,xiaopang',
'Action & Adventure , Romance , Classics','David Dobkin',
'Big city lawyer Hank Palmer returns to his childhood home where his father, nnects with his estranged family','7',
'0','0','2013-12-14');  

INSERT INTO TBL_MOVIE VALUES ('KING KONG',
'pKINGKong','wangzhou,huangshuo,hanjiji,xiaopang',
'Action & Adventure , Horror , Classics','David Dobkin',
'Big city lawyer Hank Palmer returns to his childhood home where his father, nnects with his estranged family','7',
'3','3','2014-03-14');  

INSERT INTO TBL_MOVIE VALUES ('SEVEN SAMURAI',
'pSEVENSAMURAI','wangzhou,huangshuo,hanjiji,xiaopang',
'Drama , Action & Adventure , Art House & International , Classics','David Dobkin',
'Big city lawyer Hank Palmer returns to his childhood home where his father, nnects with his estranged family','7',
'3','1','2012-09-14');  

INSERT INTO TBL_MOVIE VALUES ('THE TREASURE OF THE SIERRA MADRE',
'pTREASURE','wangzhou,huangshuo,hanjiji,xiaopang',
'Western , Drama , Action & Adventure','David Dobkin',
'Big city lawyer Hank Palmer returns to his childhood home where his father, nnects with his estranged family','7',
'3','1','2014-01-18');  

INSERT INTO TBL_MOVIE VALUES ('UP',
'pUP','wangzhou,huangshuo,hanjiji,xiaopang',
'Action & Adventure , Animation , Kids & Family , Comedy','David Dobkin',
'Big city lawyer Hank Palmer returns to his childhood home where his father, nnects with his estranged family','7',
'3','2','2014-02-18');  


---coming soon

INSERT INTO TBL_MOVIE VALUES ('THE 39 STEPS',
'pTHE39STEPS','wangzhou,huangshuo,hanjiji,xiaopang',
'Animation , Kids & Family , Comedy','David Dobkin',
'Big city lawyer Hank Palmer returns to his childhood home where his father, nnects with his estranged family','7',
'0','0','2015-02-18');  

INSERT INTO TBL_MOVIE VALUES ('JAWS',
'pjaws','wangzhou,huangshuo,hanjiji,xiaopang',
'Action & Adventure , Animation , Kids & Family , Comedy','David Dobkin',
'Big city lawyer Hank Palmer returns to his childhood home where his father, nnects with his estranged family','7',
'0','0','2014-12-18');  

INSERT INTO TBL_MOVIE VALUES ('WALL-E',
'pWALL-E','wangzhou,huangshuo,hanjiji,xiaopang',
'Action & Adventure ,Kids & Family , Comedy','David Dobkin',
'Big city lawyer Hank Palmer returns to his childhood home where his father, nnects with his estranged family','7',
'0','0','2016-02-18');  



--
--select * from TBL_MOVIE

/*
create table TBL_CINEMA(
Location varchar(100) not null constraint location_pk primary key,
Capacity varchar(20) not null,
Amenities varchar(20) not null
);
*/

INSERT INTO TBL_CINEMA VALUES ('bondi','200','ATM');
INSERT INTO TBL_CINEMA VALUES ('eastgarden','200','ATM');
INSERT INTO TBL_CINEMA VALUES ('randwick','300','snack bar');
INSERT INTO TBL_CINEMA VALUES ('hillsale','400','resturant');
INSERT INTO TBL_CINEMA VALUES ('city','500','widescreen');

--select * from TBL_CINEMA;

/*
CREATE TABLE TBL_SHOWTIME(

	PrimekyNumber SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY,
	
	--PrimekyNumber SMALLINT NOT NULL CONSTRAINT PRIMEKY_PK PRIMARY KEY ,
	Title VARCHAR(40),
	Location VARCHAR(100),
	SeatLeft varchar(20),
	ShowingDate date,
	ShowingTime time,
	CONSTRAINT fk_location FOREIGN KEY (Location) REFERENCES TBL_CINEMA(Location),
	CONSTRAINT fk_title FOREIGN KEY (Title) REFERENCES TBL_MOVIE(Title),
	PRIMARY KEY(Location,ShowingDate,ShowingTime)
);

*/

--select * from TBL_SHOWTIME
-- loaction : bondi 200  eastgarden 200 randwick 300 hillsale 400 city 500


--  METROPOLIS  2014-06-14 release

--Select * from TBL_SHOWTIME where Title = 'METROPOLIS' and ShowingDate = '2014-09-29'

INSERT INTO TBL_SHOWTIME VALUES (default,'METROPOLIS','bondi','200','2014-09-29','12:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'METROPOLIS','eastgarden','200','2014-10-08','12:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'METROPOLIS','hillsale','400','2014-09-12','12:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'METROPOLIS','city','500','2015-09-12','13:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'METROPOLIS','randwick','300','2014-09-12','08:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'METROPOLIS','bondi','200','2014-09-29','14:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'METROPOLIS','bondi','200','2014-10-08','12:00:00');


--THE ADVENTURES OF ROBIN HOOD  2013-12-14

INSERT INTO TBL_SHOWTIME VALUES (default,'THE ADVENTURES OF ROBIN HOOD','hillsale','400','2014-08-12','12:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'THE ADVENTURES OF ROBIN HOOD','city','500','2015-09-12','7:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'THE ADVENTURES OF ROBIN HOOD','randwick','300','2014-10-12','08:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'THE ADVENTURES OF ROBIN HOOD','bondi','200','2014-09-19','12:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'THE ADVENTURES OF ROBIN HOOD','bondi','200','2014-10-18','12:00:00');




--KING KONG 2014-03-14

INSERT INTO TBL_SHOWTIME VALUES (default,'KING KONG','hillsale','400','2014-06-12','12:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'KING KONG','city','500','2015-07-12','13:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'KING KONG','randwick','300','2014-03-22','08:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'KING KONG','bondi','200','2014-09-19','2:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'KING KONG','bondi','200','2014-10-28','12:00:00');


--SEVEN SAMURAI 12 year

INSERT INTO TBL_SHOWTIME VALUES (default,'SEVEN SAMURAI','hillsale','400','2014-11-12','12:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'SEVEN SAMURAI','city','500','2015-09-02','13:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'SEVEN SAMURAI','randwick','300','2014-08-17','08:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'SEVEN SAMURAI','eastgarden','200','2014-09-21','12:00:00');


--UP

INSERT INTO TBL_SHOWTIME VALUES (default,'UP','hillsale','400','2014-09-12','23:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'UP','city','500','2015-09-12','09:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'UP','randwick','300','2014-09-12','21:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'UP','eastgarden','200','2014-09-29','13:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'UP','bondi','200','2014-10-08','17:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'UP','hillsale','400','2014-09-12','01:00:00');

INSERT INTO TBL_SHOWTIME VALUES (default,'UP','eastgarden','180','2014-10-29','13:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'UP','bondi','180','2014-10-27','17:00:00');
INSERT INTO TBL_SHOWTIME VALUES (default,'UP','hillsale','380','2014-09-17','01:00:00');




--SELECT * FROM TBL_SHOWTIME;


--TBL_COMENTS
/*
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
*/

--select * from TBL_COMENTS

--insert into TBL_COMENTS VALUES('qiaofeng','4','UP',CURRENT_DATE,CURRENT_TIME,'holly shit fiem niujigalabiubiupiujigua');

INSERT INTO TBL_COMENTS VALUES ('bazhang','3','UP','2014-09-12','17:00:00','holly shit fiem niujigalabiubiupiujigua');
INSERT INTO TBL_COMENTS VALUES ('miejuezhang','3','KING KONG','2015-09-12','17:00:00','holly shit fiem');
INSERT INTO TBL_COMENTS VALUES ('bazhang','3','KING KONG','2015-09-12','17:00:00','holly shit fiem');

INSERT INTO TBL_COMENTS VALUES ('miejuezhang','3','UP','2014-09-12','17:00:00','holly shit fiem niujigalabiubiupiujigua');
INSERT INTO TBL_COMENTS VALUES ('bazhang','3','KING KONG','2015-11-12','17:00:00','holly shit fiem');
INSERT INTO TBL_COMENTS VALUES ('miejuezhang','3','KING KONG','2015-08-12','17:00:00','holly shit fiem');

-----

INSERT INTO TBL_COMENTS VALUES ('miejuezhang','5','METROPOLIS','2014-01-12','17:00:00','holly shit fiem niujigalabiubiupiujigua');
INSERT INTO TBL_COMENTS VALUES ('bazhang','3','THE TREASURE OF THE SIERRA MADRE','2010-11-12','17:00:00','holly shit fiem');
INSERT INTO TBL_COMENTS VALUES ('miejuezhang','3','SEVEN SAMURAI','2012-08-12','17:00:00','holly shit fiem');



--select * from TBL_MOVIE

/*


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
*/


--select * from TBL_ORDER 

INSERT INTO TBL_ORDER VALUES (default,'a','UP','20','eastgarden','2014-10-29','13:00:00');
INSERT INTO TBL_ORDER VALUES (default,'b','SEVEN SAMURAI','25','bondi','2014-1-27','17:00:00');
INSERT INTO TBL_ORDER VALUES (default,'a','SEVEN SAMURAI','21','bondi','2014-12-27','17:00:00');
INSERT INTO TBL_ORDER VALUES (default,'b','THE TREASURE OF THE SIERRA MADRE','22','bondi','2014-11-27','17:00:00');
INSERT INTO TBL_ORDER VALUES (default,'a','THE TREASURE OF THE SIERRA MADRE','2','bondi','2014-9-27','17:00:00');
INSERT INTO TBL_ORDER VALUES (default,'b','KING KONG','20','hillsale','2014-09-7','01:00:00');
INSERT INTO TBL_ORDER VALUES (default,'a','KING KONG','20','hillsale',CURRENT_DATE,'01:00:00');
