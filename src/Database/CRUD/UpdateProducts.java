package Database.CRUD;

import Database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Class to update product fields in the database
public class UpdateProducts {

    // Update method: option defines which field to update, productId is the product, obj is the new value
    public static boolean Update(int option, int productId, Object obj) {
        Connection conn = ConfigDB.openConnection();

        if (conn != null) {
            try {
                String sql = null;
                PreparedStatement stmt = null;

                // Determine which field to update based on option
                switch (option) {
                    case 1: // Update Name
                        sql = "UPDATE Products SET product_name = ? WHERE product_id = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, (String) obj);
                        stmt.setInt(2, productId);
                        JOptionPane.showMessageDialog(null, "Name updated!");
                        break;

                    case 2: // Update Price
                        sql = "UPDATE Products SET product_price = ? WHERE product_id = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setDouble(1, (Double) obj);
                        stmt.setInt(2, productId);
                        JOptionPane.showMessageDialog(null, "Price updated!");
                        break;

                    case 3: // Update Stock
                        sql = "UPDATE Products SET product_stock = ? WHERE product_id = ?";
                        stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, (Integer) obj);
                        stmt.setInt(2, productId);
                        JOptionPane.showMessageDialog(null, "Stock updated!");
                        break;

                    default: // Invalid option
                        JOptionPane.showMessageDialog(null, "Invalid option selected.");
                        return false;
                }

                // Execute the update query
                int rowsUpdated = stmt.executeUpdate();

                // Close resources
                stmt.close();
                conn.close();

                // Return true if at least one row was updated
                return rowsUpdated > 0;

            } catch (SQLException e) {
                System.out.println("There's a problem with the connection: " + e.getMessage());
                return false; // Return false on error
            }
        }

        return false; // Return false if connection is null
    }
}
