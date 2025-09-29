package Utils.Jframes;

import javax.swing.*;

public class Container {
    public static JFrame createWindow() {
        // Set the container and his title.
        JFrame container = new JFrame("LittleShop - 2.0");
        container.setSize(500, 500);
        // Exit Default function.
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Position in the screen.
        container.setLocationRelativeTo(null);
        container.setLayout(null);
        // Message.
        JLabel message = new JLabel("Welcome to the new little shop!");
        message.setBounds(130, 20, 500, 30);
        // Functions.
        container.add(message);
        container.setVisible(true);
        return container;
    }
}
