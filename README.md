# AdaKita - Online Loan Platform

**Project Context:** University Course Project | Object Oriented Programming <br>
**Version:** 1.0 (Spring Boot / MySQL / Thymeleaf)

---

## Overview

**AdaKita** is a web-based online loan platform that provides fast, secure, and transparent financial solutions for users.
The system supports two account types — **Personal** (individual) and **Business** (company) — each with distinct loan limits and account features. This project demonstrates full-stack web application development using **Spring Boot**, **MySQL**, and **Thymeleaf** with integrated authentication, authorization, and loan management modules.

---

## Features

### Personal User

* Personal account registration and login
* Loan requests up to **Rp 5.000.000**
* Maximum of **5 active loans**
* User profile with personal details (birth date, education, occupation, ID number)
* Loan history and profile editing

### Business User

* Business account registration and login
* Loan requests up to **Rp 10.000.000**
* Maximum of **5 active loans**
* Business profile with company details (name, type, address)
* Loan history and profile editing

### General Features

* Authentication and authorization using **Spring Security**
* **Admin dashboard** for managing users and loans
* Modern, responsive user interface
* Full **loan management** workflow: submission, repayment, and history tracking

---

## Technology Stack

| Category              | Technology                   | Description                                            |
| --------------------- | ---------------------------- | ------------------------------------------------------ |
| **Backend Framework** | Spring Boot 3.4.0            | RESTful application structure and server logic.        |
| **Language**          | Java 21                      | Core application programming language.                 |
| **Database**          | MySQL 8.0+                   | Relational data storage for accounts and loans.        |
| **Security**          | Spring Security              | Provides authentication and role-based access control. |
| **ORM**               | Spring Data JPA / Hibernate  | Simplifies data persistence and entity management.     |
| **Template Engine**   | Thymeleaf                    | Handles server-side rendering of web pages.            |
| **Frontend**          | Bootstrap 5, CSS, JavaScript | Builds responsive and user-friendly UI.                |
| **Build Tool**        | Maven                        | Manages dependencies and project lifecycle.            |

---

## Prerequisites

Ensure the following are installed before running the application:

* **Java JDK 21** or higher
* **Maven 3.6+**
* **MySQL 8.0+**
* Optional: IDE (IntelliJ IDEA, Eclipse, VS Code)

---

## Installation & Setup

### 1. Clone Repository

```bash
git clone https://github.com/OceanCharlie/AdaKita.git
cd AdaKita
```

### 2. Setup Database

Create a new MySQL database named `adakita`:

```sql
CREATE DATABASE adakita;
```

Then configure your connection in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/adakita
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Build Project

```bash
mvn clean install
```

### 4. Run Application

```bash
mvn spring-boot:run
```

or run directly from your IDE by executing the `AdakitaApplication.java` class.
Access the application at `http://localhost:8080`.

---

## Project Structure

```
AdaKita/
├── src/
│   ├── main/
│   │   ├── java/com/springboot/adakita/adakita/
│   │   │   ├── AdakitaApplication.java
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── entity/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
├── pom.xml
└── README.md
```

---

## Data Model

### Account (Base Class)

| Field       | Description        |
| ----------- | ------------------ |
| account_id  | Account ID         |
| username    | Username           |
| gmail       | User email         |
| password    | Encrypted password |
| name        | Full name          |
| telp_number | Phone number       |
| poin        | Reward points      |

### AccountPersonal

Extends `Account`

* `date_of_birth`, `pendidikan`, `pekerjaan`, `ktp`
* Max loan: Rp 5.000.000
* Max active loans: 5

### AccountPerusahaan

Extends `Account`

* `nama_perusahaan`, `jenis_usaha`, `alamat`
* Max loan: Rp 10.000.000
* Max active loans: 5

### Pinjaman

* `pinjaman_id`, `account_id`, `jumlah_pinjaman`, `tujuan_peminjaman`,
  `tanggal_pinjaman`, `jumlah_pengembalian`, `tanggal_pengembalian`

---

## Security

The application implements **Spring Security** for:

* User authentication (login/logout)
* Role-based authorization
* Password encryption
* Session management

---

## Main Endpoints

| Endpoint             | Description               |
| -------------------- | ------------------------- |
| `/`                  | Redirect to home          |
| `/home`              | Home page                 |
| `/login`             | Login page                |
| `/sign-up`           | Registration page         |
| `/sign-up-personal`  | Register personal account |
| `/sign-up-business`  | Register business account |
| `/admin/home`        | Admin dashboard           |
| `/pinjaman/personal` | Personal loan page        |
| `/pinjaman/business` | Business loan page        |
| `/profile/personal`  | Personal profile          |
| `/profile/business`  | Business profile          |
| `/history/personal`  | Personal loan history     |
| `/history/business`  | Business loan history     |

---

## Testing

Run all tests using:

```bash
mvn test
```

---

## Configuration

Edit `src/main/resources/application.properties` to customize environment variables:

```properties
spring.application.name=adakita
spring.datasource.url=jdbc:mysql://localhost:3306/adakita
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
server.servlet.session.timeout=30
```
---
