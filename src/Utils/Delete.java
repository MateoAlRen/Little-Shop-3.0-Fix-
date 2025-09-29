package Utils;

import Database.CRUD.DeleteProduct;
import Database.CheckProducts;
import Database.FindProducts;
import Utils.Counters.Statistics;

import javax.swing.*;

public class Delete {
    public static void Button(JFrame frame){
        // Create Delete button
        JButton deleteProducts = new JButton("Delete product");
        deleteProducts.setBounds(160, 325, 150, 30);
        frame.add(deleteProducts);

        // Add button action
        deleteProducts.addActionListener(e -> {
            // Check if there are products
            if (!CheckProducts.Check()) {
                JOptionPane.showMessageDialog(null, "There's no products!");
                return;
            }

            String foundId = null;
            int id = 0;
            boolean find = false;

            // Loop until valid product is found
            while (!find) {
                // Ask for product ID
                JTextField textField = new JTextField(10);
                int option = JOptionPane.showConfirmDialog(
                        frame,
                        new Object[]{"Write ID of the product you want to delete:", textField},
                        "Find Product",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                // If user confirms
                if (option == JOptionPane.OK_OPTION) {
                    String input = textField.getText().trim();

                    // Validate input
                    if (input.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You must enter a product ID!");
                        return;
                    }

                    try {
                        id = Integer.parseInt(input);
                        foundId = FindProducts.Find(id);

                        // If product exists
                        if (foundId != null) {
                            find = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "The product doesn't exist!");
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID. Must be a number!");
                    }
                } else {
                    return; // Exit if user cancels
                }
            }

            // Confirm delete
            int confirm = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to delete this product?\n" + foundId,
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            // Delete product if confirmed
            if (confirm == JOptionPane.YES_OPTION) {
                boolean deleted = DeleteProduct.Delete(id);

                if (deleted) {
                    JOptionPane.showMessageDialog(null, "Product deleted successfully!");
                    Statistics.ProductsDeleted++; // Update counter
                } else {
                    JOptionPane.showMessageDialog(null, "Error deleting product!");
                }
            }
        });
    }
}
