# Java and MySQL Integration 

## 1. Setting Classpath for Java

To successfully connect Java with MySQL, you need to include the MySQL Connector JAR file in your classpath.

### Command to Set Classpath:
```bash
set classpath="%classpath%;C:\Program Files (x86)\Java\jdk1.8.0_11\bin\mysql-connector.jar;.;"
```
- mysql-connector.jar: This is the MySQL JDBC driver that allows Java applications to connect to MySQL databases.

## 2. MySQL Setup

### Step 1: Login to MySQL
Use the following command to log in to the MySQL database using the root user:
```bash
mysql -u root -p
```

When prompted, enter the following password:
```bash
password: root
```

### Step 2: Select Database
Once logged in, select the test database:
```bash
USE test;
```

### Step 3: Create emp Table
To create a new table emp, run the following SQL command:
```bash
CREATE TABLE emp (
    id INT,
    name VARCHAR(20),
    address VARCHAR(20)
);
```

### Step 4: Insert Data into emp Table
Insert a new record into the emp table:
```bash
INSERT INTO emp VALUES (1, "ABC", "XYZ");
```

## Summary
- **Java Classpath Setup** : Make sure to include the MySQL JDBC driver in your classpath for Java.
- **MySQL Commands** : Login, create a table, and insert a record using the SQL commands shown above.
