package Utils;

import Database.CRUD.ShowProducts;
import Utils.Counters.Statistics; // Import counters
import javax.swing.*;

public class Read {
    public static void Button(JFrame frame){
        JButton seeProducts = new JButton("See products");
        seeProducts.setBounds(160, 175, 150, 30);
        frame.add(seeProducts);

        seeProducts.addActionListener(e -> {
            ShowProducts.Show();
            Statistics.ProductsSearched++; // Increase counter
            System.out.println("Products searched: " + Statistics.ProductsSearched);
        });
    }
}
