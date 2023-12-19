INSERT INTO admins (username, password) VALUES ('adminTest4', 'passTest');

INSERT INTO guests (first_name, last_name, email) VALUES ('John', 'John', 'johndoe@exampleTest2.com');
INSERT INTO guests (first_name, last_name, email) VALUES ('Dimka', 'Test', 'Test@Test2example.com');
INSERT INTO guests (first_name, last_name, email) VALUES ('Rick', 'Morty', 'RickAndMorty@netlifx.com');

INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('101', 'Standard', 150);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('103', 'Lux', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('104', 'Standard', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('105', 'Lux', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('201', 'Prime', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('202', 'Lux', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('203', 'Lux', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('204', 'Standard', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('205', 'Prime', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('301', 'Standard', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('302', 'King', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('303', 'Prime', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('304', 'Lux', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('305', 'Lux', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('401', 'Prime', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('402', 'Lux', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('403', 'Lux', 200);
INSERT INTO rooms (room_number, room_type, price_per_night) VALUES ('404', 'Prime', 300);

INSERT INTO reservations (guest_id, room_id, check_in_date, check_out_date, total_price) VALUES (1, 1, '2023-01-01', '2023-01-03', 300.00);
INSERT INTO reservations (guest_id, room_id, check_in_date, check_out_date, total_price) VALUES (2, 2, '2023-02-15', '2023-02-20', 1000.00);
