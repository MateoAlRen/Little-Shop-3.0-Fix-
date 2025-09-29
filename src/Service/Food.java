package Service;

import Models.Products;

public class Food extends Products {
    private final String description;

    public Food(String productName, double productPrice, String description, int productStock) {
        super(productName, productPrice, productStock);
        this.description = description;
    }

    @Override
    public String getProductName() {
        return super.getProductName();
    }

    @Override
    public double getProductPrice() {
        return super.getProductPrice();
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public void getOffStock(int num) {
        int stock = getProductStock();

        if (num > stock) {
            System.out.println("There's not enough products!");  // Not enough stock
        } else {
            setProductStock(stock - num);
        }
    }

}
