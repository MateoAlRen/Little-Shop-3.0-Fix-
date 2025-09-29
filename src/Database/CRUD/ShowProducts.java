package Database.CRUD;

import Database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Class to display all products from the database
public class ShowProducts {

    // Show method returns true if products exist and are displayed
    public static boolean Show() {

        // Open database connection
        Connection conn = ConfigDB.openConnection();

        if (conn != null) {
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                // SQL query to select all products
                String sql = "SELECT * FROM Products";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                StringBuilder message = new StringBuilder("Products:\n");
                boolean hasProducts = false;

                // Loop through all results
                while (rs.next()) {
                    hasProducts = true;

                    int productId = rs.getInt("product_id");
                    String productName = rs.getString("product_name");
                    double productPrice = rs.getDouble("product_price");
                    int productStock = rs.getInt("product_stock");

                    // Append product info to message
                    message.append("ID: ").append(productId)
                            .append(" - Name: ").append(productName)
                            .append(" - Price: ").append(productPrice)
                            .append(" - Stock: ").append(productStock)
                            .append("\n");
                }

                // Display products in a non-modal dialog if any exist
                if (hasProducts) {
                    JOptionPane showPane = new JOptionPane(message.toString(), JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = showPane.createDialog(null, "Products");
                    dialog.setLocation(550, 450);
                    dialog.setModal(false);
                    dialog.setVisible(true);
                } else { // No products found
                    JOptionPane.showMessageDialog(null, "There's no products available!");
                    return false;
                }

            } catch (SQLException e) {
                e.printStackTrace(); // Print any SQL errors
            } finally {
                // Close resources
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else { // Connection failed
            System.out.println("There's a problem with the connection");
            return false;
        }

        return true; // Products displayed successfully
    }
}
