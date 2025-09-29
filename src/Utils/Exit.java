package Utils;

import Utils.Counters.Statistics;

import javax.swing.*;

public class Exit {
    public static void Button(JFrame frame){
        // Create Exit button
        JButton exit = new JButton("Exit");
        exit.setBounds(160, 375, 150, 30);
        frame.add(exit);

        // Confirmation options
        String[] buttons = {"Yes", "No"};

        // Add button action
        exit.addActionListener(e -> {
            // Show confirm dialog
            int confirm = JOptionPane.showOptionDialog(
                    frame,
                    "Do you want to exit?",
                    "Confirm",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    buttons,
                    buttons[0]
            );

            // Build message with statistics
            StringBuilder message = new StringBuilder("Actions committed:\n");
            message.append(" Products Created: ").append(Statistics.ProductsCreated).append("\n")
                    .append(" Products Updated: ").append(Statistics.ProductsUpdated).append("\n")
                    .append(" Products Searched: ").append(Statistics.ProductsSearched).append("\n")
                    .append(" Products Deleted: ").append(Statistics.ProductsDeleted).append("\n")
                    .append("\n");

            // If user confirms, show message and close app
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, message);
                System.exit(0); // Exit program
            }
        });
    }
}

