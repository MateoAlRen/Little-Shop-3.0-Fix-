package Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Class to find a product by its ID in the database
public class FindProducts {

    // Method to search a product by ID and return its info as a string
    public static String Find(int id) {
        Connection conn = ConfigDB.openConnection(); // Open database connection

        if (conn != null) {
            try {
                // Prepare SQL query with parameter to avoid SQL injection
                String sql = "SELECT * FROM Products WHERE product_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery(); // Execute query

                if (rs.next()) { // If product found
                    StringBuilder message = new StringBuilder("Product:\n");

                    int productId = rs.getInt("product_id");
                    String productName = rs.getString("product_name");
                    double productPrice = rs.getDouble("product_price");
                    int productStock = rs.getInt("product_stock");

                    // Build result string
                    message.append("ID: ").append(productId)
                            .append(" - Name: ").append(productName)
                            .append(" - Price: ").append(productPrice)
                            .append(" - Stock: ").append(productStock)
                            .append("\n");

                    return message.toString(); // Return product info
                } else {
                    // No product found
                    stmt.close();
                    conn.close();
                    return null;
                }

            } catch (Exception e) {
                e.getMessage();
                return null; // Return null on error
            }
        } else {
            // Connection failed
            JOptionPane.showMessageDialog(null, "There's a problem with the connection!");
            return null;
        }
    }
}
