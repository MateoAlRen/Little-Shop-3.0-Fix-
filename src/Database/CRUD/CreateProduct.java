package Database.CRUD;

import Database.ConfigDB;
import Models.Products;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Class to create/add a new product to the database
public class CreateProduct {

    // Create method takes a Products object and inserts it into the database
    public static void Create(Products product) {
        // Open database connection
        Connection conn = ConfigDB.openConnection();

        if (conn != null) {
            try {
                // SQL query to insert a product with name, price, and stock
                String sql = "INSERT INTO Products (product_name,product_price,product_stock) VALUES (?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);

                // Set values for SQL placeholders
                stmt.setString(1, product.getProductName());
                stmt.setDouble(2, product.getProductPrice());
                stmt.setInt(3, product.getProductStock());

                // Execute insertion
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    // Show success message if a row was inserted
                    JOptionPane.showMessageDialog(null, "Product saved successfully!");
                }

                // Close resources
                stmt.close();
                conn.close();

            } catch (SQLException e) {
                // Show error message if something went wrong
                JOptionPane.showMessageDialog(null, "There's an error in the connection: " + e.getMessage());
            }
        }
    }
}
