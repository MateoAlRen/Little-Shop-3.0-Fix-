package Utils.Validations;

import Database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerifyName {
    // Method to check if the product name already exists in DB
    public static Boolean Verify(String name) {
        Connection conn = ConfigDB.openConnection();
        if (name == null) return false;
        boolean duplicate = true;

        // Normalize input (lowercase and trimmed)
        String checkProduct = name.toLowerCase().trim();

        try {
            // Query to check if product name already exists
            String sql = "SELECT 1 FROM Products WHERE product_name = ? LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, checkProduct);

            ResultSet rs = stmt.executeQuery();

            // If a row exists, mark as duplicate
            if (rs.next()) {
                duplicate = false;
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("There is an error: " + e.getMessage());
        }

        return duplicate;
    }
}
