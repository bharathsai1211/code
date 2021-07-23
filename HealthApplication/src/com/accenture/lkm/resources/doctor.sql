CREATE DATABASE DOCTOR;


-- Table Script goes here.
CREATE TABLE DOCTOR(
     DOCTORID INT(10) PRIMARY KEY,
    DOCTORNAME VARCHAR(40),
     SPECIALITY VARCHAR(40)
);  
CREATE TABLE APPOINTMENT(
	APPOINTMENTID INT(10) PRIMARY KEY,
	PATIENTNAME VARCHAR(40),
	VISITDATE datetime,
	DOCTORID INT(10) references DOCTOR(DOCTORID)
);
INSERT INTO DOCTOR VALUES(1,'Dr.Ramesh','Cardiologist');
INSERT INTO DOCTOR VALUES(2,'Dr.Srinivas','Neurologist');
INSERT INTO DOCTOR VALUES(3,'Dr.Praveena','Gynecologist');

INSERT INTO APPOINTMENT VALUES(1,'Ricky','2015-01-22',1);
INSERT INTO APPOINTMENT VALUES(2,'John','2015-01-12',2);
INSERT INTO APPOINTMENT VALUES(3,'Priya','2015-01-24',3);


commit;