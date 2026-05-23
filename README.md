# 🗄️ BackupWatch - Database Backup & Monitoring System

> Zero-Downtime Database Backup & Monitoring System built with Java, JDBC, and MySQL

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-007396?style=for-the-badge&logo=java&logoColor=white)


[Features](#-features) • [Quick Start](#-quick-start) • [Architecture](#-architecture) • [Database Setup](#-database-setup) • [API Docs](#-dashboard--workflow)

---

## 📖 About

**BackupWatch** is a Java-based console application that simulates a real-world enterprise database backup monitoring environment. Built with a focus on reliability and structured data management, BackupWatch provides a complete pipeline for managing database servers, scheduling backups, tracking history, and generating activity logs.

---

## 🎯 Key Achievements

✅ **100% CRUD Coverage** — Full Create, Read, Update, Delete operations on servers & backups  
✅ **Role-Based Auth** — Admin/User authentication with custom exception handling  
✅ **DAO Architecture** — Clean separation of database logic from business logic  
✅ **Auto Log Generation** — File-based backup logs created dynamically at runtime  
✅ **Live Monitoring Dashboard** — Real-time stats using SQL aggregate functions  
✅ **6-Step Modular Design** — Each feature built as an independent, testable module  

---

## ✨ Features

### 🔌 Database Connection
- Centralized JDBC connection management
- MySQL Driver integration via `DriverManager`
- Single-point connection via `DBConnection.java`

**Concepts Used:** `Connection` `DriverManager` `SQLException`

---

### 🔐 Login Module
- Email & Password Authentication
- Role display — `ADMIN` / `USER`
- Invalid login handled via custom exception

**Concepts Used:** `PreparedStatement` `ResultSet` `InvalidUserException`

---

### 🖥️ Server Management (CRUD)
- Add, View, Update, and Delete database servers
- Full CRUD operations backed by SQL queries

**Concepts Used:** `INSERT` `SELECT` `UPDATE` `DELETE`

---

### 📅 Backup Scheduler
- Schedule backups linked to specific servers
- Track backup status (`SUCCESS` / `FAILED`)
- Store backup size and date

**Concepts Used:** `Foreign Key` `JDBC INSERT & SELECT`

---

### 📊 Monitoring Dashboard
Displays live statistics:
- Total Servers
- Total Backups
- Successful Backups
- Failed Backups
- Total Storage Used

**SQL Functions Used:** `COUNT()` `SUM()`

---

### 📝 Backup Logs
Stores activity logs in:
```
logs/backup_logs.txt
```

Example Log Entry:
```
[2026-05-20T22:30:10]
Backup Scheduled
Server ID: 1
Status: SUCCESS
Backup Size: 100.0 GB
----------------------
```

**Concepts Used:** `FileWriter` `File Handling` `Dynamic File Creation`

---

## 🚀 Quick Start

### Prerequisites
- Java JDK 8+
- MySQL Server (running)
- MySQL Connector JAR (`mysql-connector-j-9.7.0.jar`)
- VS Code or any Java IDE

---

### Installation

**1. Clone the repository**
```bash
git clone https://github.com/your-username/backupwatch-database-monitoring-system.git
cd backupwatch-database-monitoring-system
```

**2. Set up the database**
```sql
CREATE DATABASE backup_monitoring_db;
USE backup_monitoring_db;
```
> Run `database/schema.sql` and `database/sample_data.sql` in MySQL.

**3. Place the JDBC JAR**
```
lib/mysql-connector-j-9.7.0.jar
```

**4. Update DB credentials in `DBConnection.java`**
```java
String USERNAME = "your_mysql_username";
String PASSWORD = "your_mysql_password";
```

---

### Running BackupWatch

**Step 1 – Open CMD in project folder**
```bash
cd DatabaseBackupMonitoringSystem/
```

**Step 2 – Compile**
```bash
javac -cp "lib/mysql-connector-j-9.7.0.jar;src" src/main/*.java src/dao/*.java src/model/*.java src/service/*.java src/util/*.java src/exception/*.java
```

**Step 3 – Run**
```bash
java -cp "lib/mysql-connector-j-9.7.0.jar;src" main.Main
```

---

### Login Credentials
```
Email:    admin@gmail.com
Password: admin123
```

---

## 🏗️ Architecture

```
+----------------+
|     User       |
+----------------+
        |
        v
+----------------+
|  Login Module  |
+----------------+
        |
        v
+----------------+
|   Dashboard    |
+----------------+
   |      |      |
   v      v      v
Server  Backup  Monitoring
CRUD   Scheduler Dashboard
   |      |      |
   +------|------+
          |
          v
+----------------+
|    MySQL DB    |
+----------------+
          |
          v
+----------------+
| Backup Logs    |
| File Storage   |
+----------------+
```

### Components

**`DBConnection.java`**
- Centralized database connection
- Single connection instance for all DAOs

**`UserDAO.java`**
- Login authentication
- Password & email validation

**`ServerDAO.java`**
- Full server CRUD operations
- IP address & storage tracking

**`BackupDAO.java`**
- Backup scheduling & history
- Foreign key relation to servers

**`MonitoringService.java`**
- Aggregate SQL queries
- Real-time stats computation

**`FileUtil.java`**
- Dynamic log file creation
- Append-mode backup logging

---

## 📁 Project Structure

```
BackupWatch/
│
├── src/
│   ├── main/
│   │   ├── Main.java
│   │   └── Dashboard.java
│   │
│   ├── model/
│   │   ├── User.java
│   │   ├── Server.java
│   │   └── Backup.java
│   │
│   ├── dao/
│   │   ├── DBConnection.java
│   │   ├── UserDAO.java
│   │   ├── ServerDAO.java
│   │   └── BackupDAO.java
│   │
│   ├── service/
│   │   ├── LoginService.java
│   │   ├── BackupService.java
│   │   └── MonitoringService.java
│   │
│   ├── util/
│   │   └── FileUtil.java
│   │
│   ├── exception/
│   │   └── InvalidUserException.java
│   │
│   └── logs/
│       └── backup_logs.txt
│
├── database/
│   ├── schema.sql
│   └── sample_data.sql
│
├── lib/
│   └── mysql-connector-j-9.7.0.jar
│
└── README.md
```

---

## 🗃️ Database Setup

### Tables

#### 1. Users Table
```sql
CREATE TABLE users (
    user_id  INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(100),
    email    VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    role     VARCHAR(50)
);

INSERT INTO users (name, email, password, role)
VALUES ('Admin', 'admin@gmail.com', 'admin123', 'ADMIN');
```

#### 2. Servers Table
```sql
CREATE TABLE servers (
    server_id        INT PRIMARY KEY AUTO_INCREMENT,
    server_name      VARCHAR(100),
    ip_address       VARCHAR(50),
    storage_capacity DOUBLE,
    status           VARCHAR(50)
);
```

#### 3. Backups Table
```sql
CREATE TABLE backups (
    backup_id     INT PRIMARY KEY AUTO_INCREMENT,
    server_id     INT,
    backup_date   DATETIME,
    backup_status VARCHAR(50),
    backup_size   DOUBLE,

    FOREIGN KEY (server_id) REFERENCES servers(server_id)
);
```

---

## 📋 Dashboard & Workflow

### Application Workflow
```
Login
  ↓
Dashboard
  ↓
Add / View / Update / Delete Servers
  ↓
Schedule Backup
  ↓
View Backup History
  ↓
Monitoring Dashboard
  ↓
Save Logs
  ↓
Exit
```

### Dashboard Menu
```
===== DATABASE BACKUP SYSTEM =====

1. Add Server
2. View Servers
3. Update Server
4. Delete Server
5. Schedule Backup
6. View Backup History
7. Monitoring Dashboard
8. Save Backup Logs
9. Exit
```

### Sample Monitoring Output
```
===== MONITORING DASHBOARD =====

Total Servers      : 3
Total Backups      : 7
Successful Backups : 6
Failed Backups     : 1
Total Storage Used : 420.5 GB
```

---

## 🧩 OOP & Java Concepts Used

### Encapsulation
Private variables with getters & setters in `User.java`, `Server.java`, `Backup.java`.

### Abstraction
DAO layer hides all database logic — `UserDAO`, `ServerDAO`, `BackupDAO`.

### Exception Handling
Custom `InvalidUserException` thrown on invalid login attempts.

---

## 🛠️ Technology Stack

| Technology    | Purpose                 |
|---------------|-------------------------|
| Java          | Core Programming        |
| JDBC          | Database Connectivity   |
| MySQL         | Database Management     |
| SQL           | CRUD & Aggregates       |
| File Handling | Backup Log Generation   |
| OOP           | System Design           |
| VS Code       | Development Environment |

---

## 🔧 JDBC Concepts Used

- `Connection`
- `PreparedStatement`
- `ResultSet`
- `executeQuery()`
- `executeUpdate()`

---

## 🗄️ SQL Concepts Used

**CRUD:** `INSERT` `SELECT` `UPDATE` `DELETE`

**Aggregate Functions:** `COUNT()` `SUM()`

**Foreign Key:**
```
backups.server_id → servers.server_id
```

---

## 🔮 Future Enhancements

- [ ] GUI using Java Swing
- [ ] Email Notifications on Backup Failure
- [ ] Scheduled Automatic Backups (Cron-style)
- [ ] Backup Restore Feature
- [ ] Cloud Storage Integration
- [ ] Admin / User Role Permissions
- [ ] Multi-user support
- [ ] Backup compression
- [ ] REST API layer
- [ ] Docker containerization

---



Made with ☕ for Java learners and database enthusiasts

⭐ Star this repo if you find it helpful!
