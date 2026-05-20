CREATE DATABASE IF NOT EXISTS backup_monitoring_db;

USE backup_monitoring_db;

CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    role VARCHAR(50)
);

CREATE TABLE servers (
    server_id INT PRIMARY KEY AUTO_INCREMENT,
    server_name VARCHAR(100),
    ip_address VARCHAR(50),
    storage_capacity DOUBLE,
    status VARCHAR(50)
);

CREATE TABLE backups (
    backup_id INT PRIMARY KEY AUTO_INCREMENT,
    server_id INT,
    backup_date DATETIME,
    backup_status VARCHAR(50),
    backup_size DOUBLE,

    FOREIGN KEY(server_id)
    REFERENCES servers(server_id)
);