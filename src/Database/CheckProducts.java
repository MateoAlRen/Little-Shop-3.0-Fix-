package Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Class to check if there are any products in the database
public class CheckProducts {

    public static boolean Check() {
        // Open database connection
        Connection conn = ConfigDB.openConnection();

        if (conn != null) {
            PreparedStatement ps;
            ResultSet rs;

            try {
                // SQL query to select all products
                String sql = "SELECT * FROM Products";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                // If at least one product exists, return true
                if (rs.next()) {
                    // Close resources
                    rs.close();
                    ps.close();
                    conn.close();
                    return true;
                }
            } catch (Exception e) {
                throw new RuntimeException(e); // Throw runtime exception if something goes wrong
            }
        } else {
            // Show error if connection fails
            JOptionPane.showMessageDialog(null, "There's a problem with the connection");
        }

        return false; // Return false if no products or connection fails
    }
}
