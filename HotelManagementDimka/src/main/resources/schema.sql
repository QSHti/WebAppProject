CREATE TABLE admins (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100)

    );

CREATE TABLE guests (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100) NOT NULL UNIQUE

    );

CREATE TABLE rooms (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(20) NOT NULL UNIQUE,
    room_type VARCHAR(50) NOT NULL,
    is_available BOOLEAN NOT NULL,
    price_per_night DECIMAL(10, 2) NOT NULL

    );

CREATE TABLE reservations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    guest_id BIGINT NOT NULL,
    room_id BIGINT NOT NULL,
    check_in_date DATE NOT NULL,
    check_out_date DATE NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50),

    CONSTRAINT fk_guest FOREIGN KEY (guest_id) REFERENCES guests(id),
    CONSTRAINT fk_room FOREIGN KEY (room_id) REFERENCES rooms(id)
);
