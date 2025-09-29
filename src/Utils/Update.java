package Utils;

import Database.CRUD.UpdateProducts; // Import update logic
import Database.CheckProducts;       // Import check if products exist
import Database.FindProducts;        // Import product search
import Utils.Counters.Statistics;
import Utils.Validations.VerifyName; // Import name validator
import Utils.Validations.VerifyPrice;// Import price validator

import javax.swing.*;

public class Update {
    public static void Button(JFrame frame){
        // Create "Update products" button
        JButton updateProducts = new JButton("Update products");
        updateProducts.setBounds(160, 275, 150, 30);
        frame.add(updateProducts);

        updateProducts.addActionListener(e -> {
            int id = 0;

            // Check if there are products
            if (!CheckProducts.Check()) {
                JOptionPane.showMessageDialog(null, "There's no products!");
                return;
            }

            boolean find = false;
            String foundId = null;

            // Loop until valid product is found
            while (!find) {
                // Dialog to ask for product ID
                JTextField textField = new JTextField(10);
                int option = JOptionPane.showConfirmDialog(
                        frame,
                        new Object[]{"Write ID of the that do you wan to Update:", textField},
                        "Find Product",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (option == JOptionPane.OK_OPTION) {
                    String input = textField.getText().trim();

                    if (input.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You must enter a product ID!");
                        return;
                    }

                    try {
                        id = Integer.parseInt(input); // Convert input to int
                        foundId = FindProducts.Find(id); // Search product

                        if (foundId != null) {
                            find = true; // Product found
                        } else {
                            JOptionPane.showMessageDialog(null, "The product doesn't exist!");
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID. Must be a number!");
                    }
                } else {
                    return; // Cancel pressed
                }
            }

            // Choose what to update
            String[] buttons = {"Name", "Price", "Stock", "Cancel"};
            int Type = JOptionPane.showOptionDialog(
                    frame,
                    "What do you want to update?  " + foundId,
                    "Type",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    buttons,
                    buttons[0]
            );

            boolean updated = false;
            while (!updated){
                if (Type == 3) { // Cancel
                    JOptionPane.showMessageDialog(frame, "Cancelled.");
                    return;
                } else if (Type == 0) { // Update Name
                    String newName = JOptionPane.showInputDialog(null,"Write the new name: ");
                    boolean checkName = VerifyName.Verify(newName);
                    if (checkName){
                        UpdateProducts.Update(1,id,newName); // Update DB
                        Statistics.ProductsUpdated++;
                        updated = true;
                    } else {
                        JOptionPane.showMessageDialog(null,"That's not a valid name!");
                    }
                } else if (Type == 1){ // Update Price
                    String newPrice = JOptionPane.showInputDialog(null,"Write the new price: ");
                    boolean checkPrice = VerifyPrice.Verify(newPrice);
                    if (checkPrice){
                        UpdateProducts.Update(2,id,Double.parseDouble(newPrice)); // Convert to double
                        Statistics.ProductsUpdated++;
                        updated = true;
                    } else {
                        JOptionPane.showMessageDialog(null,"That's not a valid price!");
                    }
                } else if (Type == 2){ // Update Stock
                    String newStock = JOptionPane.showInputDialog(null, "Write the new stock: ");
                    boolean checkStock = VerifyPrice.Verify(newStock);
                    if (checkStock){
                        UpdateProducts.Update(3,id,Integer.parseInt(newStock)); // Convert to int
                        Statistics.ProductsUpdated++;
                        updated = true;
                    } else {
                        JOptionPane.showMessageDialog(null,"That's not a valid stock!");
                    }
                }
            }
        });
    }
}
