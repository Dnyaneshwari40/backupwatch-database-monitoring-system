````md
# 🚀 BackupWatch – Database Backup & Monitoring System

> A Java-based console application for managing database servers, scheduling backups, monitoring backup activities, and maintaining backup logs using JDBC and MySQL.

![Java](https://img.shields.io/badge/Java-17-orange)
![JDBC](https://img.shields.io/badge/JDBC-Database-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Status](https://img.shields.io/badge/Project-Completed-success)

---

# 📌 Project Overview

**BackupWatch** is a Java-based console application designed to simulate a real-world **Database Backup & Monitoring System**.

The application helps manage database server backups efficiently by providing features such as authentication, server management, backup scheduling, monitoring, and log maintenance.

The project demonstrates practical implementation of:

- Core Java
- JDBC Connectivity
- MySQL Database
- CRUD Operations
- OOP Concepts
- DAO Architecture
- File Handling
- Exception Handling

---

# ✨ Features

## ✅ Database Connection

- MySQL Database Connectivity using JDBC
- Centralized Database Connection
- Driver Management

---

## ✅ Login Module

### Features

- User Login Authentication
- Email & Password Verification
- Role Display (`ADMIN / USER`)
- Invalid Login Handling

---

## ✅ Server Management (CRUD)

### Features

- Add Server
- View Servers
- Update Server
- Delete Server

---

## ✅ Backup Scheduler

### Features

- Schedule Backup
- Backup Status Tracking
- Backup Size Management
- Backup History

---

## ✅ Monitoring Dashboard

### Dashboard Includes

- Total Servers
- Total Backups
- Successful Backups
- Failed Backups
- Total Storage Used

---

## ✅ Backup Logs

### Features

Stores backup logs inside:

```text
logs/backup_logs.txt
```

### Example Log

```text
[2026-05-20T22:30:10]
Backup Scheduled
Server ID: 1
Status: SUCCESS
Backup Size: 100.0 GB
----------------------
```

---

# 🛠 Technology Stack

| Technology | Purpose |
|------------|----------|
| Java | Core Programming |
| JDBC | Database Connectivity |
| MySQL | Database Management |
| SQL | CRUD Operations |
| OOP | Application Design |
| File Handling | Backup Logs |
| VS Code | Development Environment |

---

# 📁 Project Structure

```text
backupwatch-database-monitoring-system/
│
├── src/
│   │
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

# 🏗 System Architecture

```text
+----------------------+
|        USER          |
+----------------------+
            |
            v
+----------------------+
|     LOGIN MODULE     |
+----------------------+
            |
            v
+----------------------+
|      DASHBOARD       |
+----------------------+
     |        |       |
     |        |       |
     v        v       v
+--------+ +--------+ +------------+
| Server | | Backup | | Monitoring |
|  CRUD  | | Module | | Dashboard  |
+--------+ +--------+ +------------+
       \       |       /
        \      |      /
         \     |     /
          v    v    v
       +----------------+
       |   MySQL DB     |
       +----------------+
               |
               v
       +----------------+
       | Backup Logs    |
       | (Text File)    |
       +----------------+
```

---

# 🗄 Database Setup

## Step 1 – Create Database

Run the following query in MySQL:

```sql
CREATE DATABASE backup_monitoring_db;
```

Select the database:

```sql
USE backup_monitoring_db;
```

---

# 🧾 Database Tables

## 1️⃣ Users Table

```sql
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    role VARCHAR(50)
);
```

### Insert Admin User

```sql
INSERT INTO users(name, email, password, role)
VALUES (
'Admin',
'admin@gmail.com',
'admin123',
'ADMIN'
);
```

---

## 2️⃣ Servers Table

```sql
CREATE TABLE servers (
    server_id INT PRIMARY KEY AUTO_INCREMENT,
    server_name VARCHAR(100),
    ip_address VARCHAR(50),
    storage_capacity DOUBLE,
    status VARCHAR(50)
);
```

---

## 3️⃣ Backups Table

```sql
CREATE TABLE backups (
    backup_id INT PRIMARY KEY AUTO_INCREMENT,
    server_id INT,
    backup_date DATETIME,
    backup_status VARCHAR(50),
    backup_size DOUBLE,

    FOREIGN KEY(server_id)
    REFERENCES servers(server_id)
);
```

---

# 🔗 JDBC Configuration

Download the **MySQL JDBC Connector** and place the JAR file inside:

```text
lib/
```

Example:

```text
mysql-connector-j-9.7.0.jar
```

---

# ▶️ How to Run the Project

## Step 1 – Open CMD in Project Folder

Navigate to:

```text
DatabaseBackupMonitoringSystem
```

---

## Step 2 – Compile Project

```bash
javac -cp "lib/mysql-connector-j-9.7.0.jar;src" src/main/*.java src/dao/*.java src/model/*.java src/service/*.java src/util/*.java src/exception/*.java
```

---

## Step 3 – Run Project

```bash
java -cp "lib/mysql-connector-j-9.7.0.jar;src" main.Main
```

---

# 🔐 Login Credentials

```text
Email:
admin@gmail.com

Password:
admin123
```

---

# 🔄 Application Workflow

```text
Login
   ↓
Dashboard
   ↓
Add Server
   ↓
View Server
   ↓
Update/Delete Server
   ↓
Schedule Backup
   ↓
View Backup History
   ↓
Monitoring Dashboard
   ↓
Save Backup Logs
   ↓
Exit
```

---

# 🖥 Dashboard Menu

```text
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

---

# 🔧 Core Concepts Implemented

This project demonstrates practical implementation of:

- Core Java
- JDBC Connectivity
- MySQL Database
- CRUD Operations
- DAO Architecture
- OOP Concepts
- Exception Handling
- File Handling
- SQL Queries & Aggregations

---

# 📌 Key Functionalities

✔ User Authentication  
✔ Database Server Management  
✔ Backup Scheduling  
✔ Backup History Tracking  
✔ Monitoring Dashboard  
✔ Backup Log Management

---

# 🎯 Project Outcome

**BackupWatch** provides a simplified enterprise-level solution for managing and monitoring database backups through a console-based system.

The project focuses on implementing **real-world backend concepts using Java, JDBC, and MySQL**, while maintaining clean architecture and modular code structure.

This project helped strengthen understanding of:

- Database Connectivity
- Layered Architecture
- SQL Operations
- File Management
- Backend Application Development

---

## ✅ Successfully Implemented Using

**Java + JDBC + MySQL + OOP + File Handling**

---
````
