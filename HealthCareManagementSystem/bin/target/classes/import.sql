import.sql





INSERT INTO `centre` (centre_id,centre_name) VALUES (1,'1');
INSERT INTO `centre` (centre_id,centre_name) VALUES (2,'Phagwara');
INSERT INTO `centre` (centre_id,centre_name) VALUES (3,'Mumbai');
INSERT INTO `centre` (centre_id,centre_name) VALUES (4,'Delhi');
INSERT INTO `centre` (centre_id,centre_name) VALUES (5,'Allahabad');
INSERT INTO `centre` (centre_id,centre_name) VALUES (6,'Chandigarh');


INSERT INTO `test` (test_id,test_name,centre_id) VALUES (1,'Blood',1);
INSERT INTO `test` (test_id,test_name,centre_id) VALUES (2,'BP',1);
INSERT INTO `test` (test_id,test_name,centre_id) VALUES (3,'Corona',2);
INSERT INTO `test` (test_id,test_name,centre_id) VALUES (4,'Sugar',2);
INSERT INTO `test` (test_id,test_name,centre_id) VALUES (5,'Liver',3);
INSERT INTO `test` (test_id,test_name,centre_id) VALUES (6,'Brain',3);



INSERT INTO `appointment` (appointment_id,approval_status,appointment_date,appointment_time,centre_id,test_id) VALUES (1,'yes','2342020','8:05pm',1,1);

INSERT INTO `appointment` (appointment_id,approval_status,appointment_date,appointment_time,centre_id,test_id) VALUES (2,'yes','2342020','8:05pm',2,2);



