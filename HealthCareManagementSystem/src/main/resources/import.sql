
INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES ('2','user','Maneesh','maani12k','user12',1890,'Male',21,'DodoMan');

INSERT INTO LOGIN(login_id,user) VALUES('1','2');

INSERT INTO `centre` (centre_id,centre_name) VALUES (1,'1');
INSERT INTO `centre` (centre_id,centre_name) VALUES (2,'Phagwara');
INSERT INTO `centre` (centre_id,centre_name) VALUES (3,'Mumbai');
INSERT INTO `centre` (centre_id,centre_name) VALUES (4,'Delhi');
INSERT INTO `centre` (centre_id,centre_name) VALUES (5,'Allahabad');
INSERT INTO `centre` (centre_id,centre_name) VALUES (6,'Chandigarh');

INSERT INTO `test` (test_id,test_name,centre) VALUES (1,'Blood',1);
INSERT INTO `test` (test_id,test_name,centre) VALUES (2,'BP',1);
INSERT INTO `test` (test_id,test_name,centre) VALUES (3,'Corona',2);
INSERT INTO `test` (test_id,test_name,centre) VALUES (4,'Sugar',2);
INSERT INTO `test` (test_id,test_name,centre) VALUES (5,'Liver',3);
INSERT INTO `test` (test_id,test_name,centre) VALUES (6,'Brain',3);

INSERT INTO `appointment` (appointment_id,approval_status,appointment_date,appointment_time,centre_id,user_id,test_id) VALUES (2,'yes','23-4-2020','8:05pm',2,2,2);
