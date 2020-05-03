/*********************************************************************************USER DATA********************************************************************************/
INSERT INTO `user` (user_id,user_age,user_contact_no,user_email,user_gender,user_name) VALUES (0,20,7678986567,'princypandey20@gmail.com','f','Princy');
INSERT INTO `user` (user_id,user_age,user_contact_no,user_email,user_gender,user_name) VALUES (0,10,7678986567,'kristeena10@gmail.com','f','Kristeena');
INSERT INTO `user` (user_id,user_age,user_contact_no,user_email,user_gender,user_name) VALUES (0,32,7678986567,'anuragmd09@gmail.com','m','Anurag');
INSERT INTO `user` (user_id,user_age,user_contact_no,user_email,user_gender,user_name) VALUES (0,22,7678986567,'jaiswalnikita@gmail.com','f','Nikhita');
INSERT INTO `user` (user_id,user_age,user_contact_no,user_email,user_gender,user_name) VALUES (0,21,7678986567,'msrk20@gmail.com','m','Shahrukh');


/*************************************************************************DIAGNOSTIC CENTRE DATA*************************************************************************/

INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES (0,'Jalandhar',7508027308,'Model Town');
INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES (0,'Phagwara',7508027308,'Banga road');
INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES (0,'Allahabad',7508027308,'Meerapur');
INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES (0,'New Delhi',7508027308,'SouthDelhi');
INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES (0,'Banglore',7508027308,'White Fields');


/*********************************************************************************TEST DATA*************************************************************************************/

INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES (0,'Blood',1);
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES (0,'BP',2);
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES (0,'Corona',3);
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES (0,'Sugar',4);
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES (0,'Liver',5);



/*********************************************************************************APPOINTMENT DATA***************************************************************************/

INSERT INTO `appointment` (appointment_id,approval_status,appointment_date,appointment_time,centre_id,user_id,test_id) VALUES (0,true,'2020-04-28','8:05pm',1,1,1);
INSERT INTO `appointment` (appointment_id,approval_status,appointment_date,appointment_time,centre_id,user_id,test_id) VALUES (0,false,'2020-04-28','9:05am',2,2,2);
INSERT INTO `appointment` (appointment_id,approval_status,appointment_date,appointment_time,centre_id,user_id,test_id) VALUES (0,true,'2020-04-28','10:05am',3,3,3);
INSERT INTO `appointment` (appointment_id,approval_status,appointment_date,appointment_time,centre_id,user_id,test_id) VALUES (0,false,'2020-04-28','11:05am',4,4,4);
INSERT INTO `appointment` (appointment_id,approval_status,appointment_date,appointment_time,centre_id,user_id,test_id) VALUES (0,true,'2020-04-28','12:05am',5,5,5);




