
INSERT INTO `user` (user_id,user_age,user_contact_no,user_email,user_gender,user_name) VALUES ('1',20,7678986567,'prind@hch.com','f','Princy');

INSERT INTO `user` (user_id,user_age,user_contact_no,user_email,user_gender,user_name) VALUES ('2',20,7678986567,'p','f','Kittu');

INSERT INTO `user` (user_id,user_age,user_contact_no,user_email,user_gender,user_name) VALUES ('3',20,7678986567,'prind@hch.com','m','Anurag');

INSERT INTO `user` (user_id,user_age,user_contact_no,user_email,user_gender,user_name) VALUES ('4',20,7678986567,'prind@hch.com','f','Nikhita');

INSERT INTO `user` (user_id,user_age,user_contact_no,user_email,user_gender,user_name) VALUES ('5',20,7678986567,'prind@hch.com','m','Shahrukh');




INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES ('1','Jalandhar',7508027308,'784 Hargobind Nagar');
INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES ('2','Phagwara',7508027308,'784 Hargobind Nagar');
INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES ('3','Allahabad',7508027308,'784 Hargobind Nagar');
INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES ('4','New Delhi',7508027308,'784 Hargobind Nagar');
INSERT INTO `diagnosticcentre` (centre_id,centre_name,centre_contact_number,centre_address) VALUES ('5','Banglore',7508027308,'784 Hargobind Nagar');


INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES ('1','Blood','1');
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES ('2','BP','1');
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES ('3','Corona','2');
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES ('4','Sugar','2');
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES ('5','Liver','3');
INSERT INTO `test` (test_id,test_name,diagnostic_centre) VALUES ('6','Brain','3');



INSERT INTO `appointment` (appointment_id,approval_status,appointment_date,appointment_time,centre_id,user_id,test_id) VALUES (1,true,'23-4-2020','8:05pm','1','1','1');

INSERT INTO `appointment` (appointment_id,approval_status,appointment_date,appointment_time,centre_id,user_id,test_id) VALUES (2,false,'23-4-2020','8:05pm','2','2','2');



