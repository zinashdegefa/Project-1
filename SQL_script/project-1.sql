create table cars (
plateNo serial primary key,
carName varchar(100),
fYear int,
country varchar(100),
model varchar(100),
Price int,
fkPersonId int references persons (person_id)
);

INSERT INTO cars (carName, fYear, country, model, Price, fkPersonId)
VALUES ('Ford', 2000, 'USA', 'xx', 15, 1);





CREATE TABLE Persons (
   personId serial PRIMARY key,
   firstName varchar(255),
    lastName varchar(255),
    address varchar(255),
    city varchar(255)
   );

INSERT INTO Persons (firstName, lastName, address, city)
VALUES ('Zinash', 'Degefa', '123 Street', 'Maryland heights');

INSERT INTO Persons (firstName, lastName, address, city)
VALUES ('Metages', 'Firheta', '456 Street', 'Maryland heights');