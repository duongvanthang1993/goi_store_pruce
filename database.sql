-- Tạo database nếu chưa có
CREATE DATABASE IF NOT EXISTS demo;
USE demo;

-- Đảm bảo bảng users có đầy đủ các trường id, name, email, country
CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(120) NOT NULL,
    email VARCHAR(220) NOT NULL,
    country VARCHAR(120),
    PRIMARY KEY (id)
);

-- Dữ liệu mẫu (nếu cần)
INSERT INTO users(name, email, country) VALUES
('Minh', 'minh@codegym.vn', 'Viet Nam'),
('Kante', 'kante@che.uk', 'Kenia')
ON DUPLICATE KEY UPDATE name=VALUES(name);

-- -----------------------------------------------------
-- BƯỚC 1: ĐỊNH NGHĨA CÁC STORED PROCEDURES
-- -----------------------------------------------------

-- 1. Stored Procedure lấy danh sách users
DROP PROCEDURE IF EXISTS getAllUsers;
DELIMITER $$
CREATE PROCEDURE getAllUsers()
BEGIN
    SELECT * FROM users;
END$$
DELIMITER ;

-- 2. Stored Procedure sửa thông tin user
DROP PROCEDURE IF EXISTS updateUser;
DELIMITER $$
CREATE PROCEDURE updateUser(
    IN p_id INT,
    IN p_name VARCHAR(120),
    IN p_email VARCHAR(220),
    IN p_country VARCHAR(120)
)
BEGIN
    UPDATE users
    SET name = p_name,
        email = p_email,
        country = p_country
    WHERE id = p_id;
END$$
DELIMITER ;

-- 3. Stored Procedure xoá user theo id
DROP PROCEDURE IF EXISTS deleteUser;
DELIMITER $$
CREATE PROCEDURE deleteUser(IN p_id INT)
BEGIN
    DELETE FROM users
    WHERE id = p_id;
END$$
DELIMITER ;

