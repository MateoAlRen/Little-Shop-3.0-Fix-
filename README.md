# Product Management CRUD Application

[![Java](https://img.shields.io/badge/Java-17+-blue)](https://www.java.com/)
[![MySQL](https://img.shields.io/badge/MySQL-8+-green)](https://www.mysql.com/)

A Java desktop application for managing products with **Create, Read, Update, Delete, and Search** operations, using a MySQL database and a Swing GUI.

---

## Features

- **Create Product**: Add new products (Food or Electrical Appliance) with validated name, price, and stock.
- **Read Products**: Display all products with ID, Name, Price, and Stock.
- **Update Product**: Update Name, Price, or Stock of an existing product by ID.
- **Delete Product**: Delete a product by ID with confirmation.
- **Search Product**: Find a product by ID and display its details.
- **Exit**: Shows a summary of actions performed (Created, Updated, Searched, Deleted).

---

## Technologies

- Java 17+
- Swing GUI
- MySQL
- JDBC

---

## Database Setup

1. Create a MySQL database named `ProductsCrud`.
2. Create the `Products` table:

```sql
CREATE TABLE Products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    product_price DOUBLE NOT NULL,
    product_stock INT NOT NULL
);
```
## Update credentials in ConfigDB.java:
String url = "jdbc:mysql://localhost:3306/ProductsCrud";
String user = "root";
String password = "YOUR_PASSWORD";


## How to Run:

Clone the repository or copy the project files.

Open in an IDE (IntelliJ, Eclipse, etc.).

Ensure MySQL is running.

## Notes

All interactions use Swing dialogs.

Designed for simple desktop CRUD management.

Extendable for additional product types or features.
