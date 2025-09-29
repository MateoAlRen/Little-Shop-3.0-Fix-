package Utils;

import Database.CheckProducts;   // Import product check utility
import Database.FindProducts;    // Import product search utility
import Utils.Counters.Statistics;

import javax.swing.*;

public class Search {
    public static void Button(JFrame frame){
        // Create "Search products" button
        JButton searchProducts = new JButton("Search products");
        searchProducts.setBounds(160, 225, 150, 30);
        frame.add(searchProducts);

        // Add action listener for button
        searchProducts.addActionListener(e -> {
            // Check if products exist
            if (!CheckProducts.Check()) {
                JOptionPane.showMessageDialog(null,"There's no products!");
                return;
            }

            // Input dialog for product ID
            JTextField textField = new JTextField(10);
            int option = JOptionPane.showConfirmDialog(
                    frame,
                    new Object[]{"Write ID of the product:", textField},
                    "Find Product",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            // If OK clicked
            if (option == JOptionPane.OK_OPTION) {
                String input = textField.getText().trim();

                // Check empty input
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You must enter a product ID!");
                    return;
                }

                try {
                    int id = Integer.parseInt(input); // Convert input to int
                    String foundId = FindProducts.Find(id); // Search product

                    // If product found
                    if (foundId != null) {
                        JOptionPane.showMessageDialog(null, foundId);
                        Statistics.ProductsSearched++;
                    } else {
                        JOptionPane.showMessageDialog(null, "The product doesn't exist!");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID. Must be a number!");
                }
            }
        });
    }
}
