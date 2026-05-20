USE backup_monitoring_db;

INSERT INTO users(
    name,
    email,
    password,
    role
)
VALUES (
    'Admin',
    'admin@gmail.com',
    'admin123',
    'ADMIN'
);

INSERT INTO servers(
    server_name,
    ip_address,
    storage_capacity,
    status
)
VALUES (
    'Primary Server',
    '192.168.1.10',
    500,
    'ACTIVE'
);

INSERT INTO backups(
    server_id,
    backup_date,
    backup_status,
    backup_size
)
VALUES (
    1,
    NOW(),
    'SUCCESS',
    100
);