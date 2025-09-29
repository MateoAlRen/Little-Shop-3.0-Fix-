package Database.CRUD;

import Database.ConfigDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Class to delete a product from the database
public class DeleteProduct {

    // Delete method returns true if a product was deleted successfully
    public static boolean Delete(int productId) {
        // Open database connection
        Connection conn = ConfigDB.openConnection();

        if (conn != null) {
            try {
                // SQL query to delete a product by ID
                String sql = "DELETE FROM Products WHERE product_id = ?";

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, productId); // Set the product ID

                // Execute deletion
                int rowsDeleted = stmt.executeUpdate();

                // Close resources
                stmt.close();
                conn.close();

                // Return true if at least one row was deleted
                return rowsDeleted > 0;

            } catch (SQLException e) {
                // Print SQL errors
                System.out.println("Error deleting product: " + e.getMessage());
                return false;
            }
        }
        // Return false if connection failed
        return false;
    }
}
