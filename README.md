# Electricity Billing System

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Database Schema](#database-schema)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction
The Electricity Billing System is a Java-based desktop application designed to manage customer information, meter details, and billing information. It provides functionalities for adding new customers, viewing customer details, generating and viewing bills, and administrative functions.

## Features
- Add new customer details.
- Generate unique meter numbers for each customer.
- Store and retrieve customer information.
- View and manage billing details.
- Admin and Customer login functionalities.
- Interactive GUI using Java Swing.

## Technologies Used
- Java
- Swing for GUI
- MySQL for database management
- rs2xml for displaying ResultSet data in tables

## Setup and Installation

### Prerequisites
- Java Development Kit (JDK)
- MySQL Server
- An IDE such as IntelliJ IDEA or Eclipse

### Installation Steps

1. **Clone the Repository:**
   ```sh
   git clone https://github.com/your-username/electricity-billing-system.git
   cd electricity-billing-system
   
### Set up the MySQL Database:

Open MySQL Workbench or any other MySQL client.
Create the database and tables using the provided SQL script:
sql
Copy code
CREATE DATABASE Bill_system; 
USE Bill_system;

CREATE TABLE Signup
(meter_no VARCHAR(20),
username VARCHAR(20),
name VARCHAR(30),
password VARCHAR(30),
usertype VARCHAR(20));

CREATE TABLE newcustomer(name VARCHAR(30),
meter_no VARCHAR(20),
address VARCHAR(50),
city VARCHAR(30),
state VARCHAR(30),
email VARCHAR(50),
phone VARCHAR(12));

CREATE TABLE meter_info(meter_number VARCHAR(30),
meter_location VARCHAR(30),
meter_type VARCHAR(30),
phase_code VARCHAR(30),
bill_type VARCHAR(30),
days VARCHAR(10));

CREATE TABLE tax(cost_per_unit VARCHAR(30),
meter_rent VARCHAR(30),
service_charge VARCHAR(30),
service_tax VARCHAR(30),
swacch_bharat VARCHAR(30),
fixed_tax VARCHAR(30));

INSERT INTO tax VALUES('10','45','20','58','5','8');

CREATE TABLE bill(meter_no VARCHAR(30),
month VARCHAR(30),
unit  VARCHAR(30),
total_bill VARCHAR(30),
status  VARCHAR(30));

### Add External Libraries:

Download rs2xml.jar from here.
Add the rs2xml.jar to your project's build path.
Configure Database Connection:

Ensure your database class has the correct MySQL connection details (username, password, database name).
Usage

### Run the Application:

Open the project in your IDE.
Run the Login class to start the application.
Login:

Use admin credentials to access administrative features.
Use customer credentials to view and manage personal billing information.
Database Schema
Signup: Stores user login information.
newcustomer: Stores customer details.
meter_info: Stores information about meters.
tax: Stores tax and cost details.
bill: Stores billing information.

### Screenshots
![Screenshot 2024-07-17 110339](https://github.com/user-attachments/assets/930c083b-d4ce-49d3-8dac-fb87c8d35b3e)
![Screenshot 2024-07-17 110407](https://github.com/user-attachments/assets/24b0fea3-e49b-4201-88af-f1774dc1c7ed)
![Screenshot 2024-07-17 110455](https://github.com/user-attachments/assets/3c0d972d-f778-404b-a08b-e2a5e421c976)




### Contributing
Contributions are welcome! Please fork the repository and submit pull requests.

### License
This project is licensed under the MIT License.

Contact
For any inquiries or support, please contact:

Name: Rana Satyam Pratap
Email: your-mesatyamrana01@gmail.com
