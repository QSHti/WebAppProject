INSERT INTO admins (username, password) VALUES ('admin1', 'pass1');

INSERT INTO guests (first_name, last_name, email) VALUES ('John', 'John', 'johndoe@example.com');
INSERT INTO guests (first_name, last_name, email) VALUES ('Dimka', 'Test', 'Test@example.com');

INSERT INTO rooms (room_number, room_type, is_available, price_per_night) VALUES ('101', 'Standard', TRUE, 150);
INSERT INTO rooms (room_number, room_type, is_available, price_per_night) VALUES ('102', 'Lux', TRUE, 200);

INSERT INTO reservations (guest_id, room_id, check_in_date, check_out_date, total_price) VALUES (1, 1, '2023-01-01', '2023-01-03', 300.00);
INSERT INTO reservations (guest_id, room_id, check_in_date, check_out_date, total_price) VALUES (2, 2, '2023-02-15', '2023-02-20', 1000.00);
