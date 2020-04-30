
/*************************************************************************USER DATA*************************************************************************/

INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES ('1','admin','Admin','Admin01','admin01',010101,'M',01,'admin');
INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES ('2','user','Maneesh','maani12k','user12',1890,'Male',21,'DodoMan');


/*************************************************************************DIAGNOSTIC CENTRE DATA*************************************************************************/

INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES ('1','Jalandhar',7508027308,'784 Model Town');
INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES ('2','Phagwara',7508027308,'980 Banga road');
INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES ('3','Allahabad',7508027308,'34 Meerapur');
INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES ('4','New Delhi',7508027308,'456 SouthDelhi');
INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES ('5','Banglore',7508027308,'26-B White Fields');


/*********************************************************************************TEST DATA*************************************************************************************/

INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES ('1','Blood','1');
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES ('2','BP','1');
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES ('3','Corona','2');
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES ('4','Sugar','2');
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES ('5','Liver','3');
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES ('6','Brain','3');


/*********************************************************************************APPOINTMENT DATA***************************************************************************/

INSERT INTO `appointment` (appointment_id,approval_status,appointment_date,appointment_time,centre_id,user_id,test_id) VALUES (2,false,'24-4-2020','9:05am','2','2','2');

