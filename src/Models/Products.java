package Models;

public abstract class Products {
    private final String productName;
    private final double productPrice;
    protected int productStock;

    public Products(String productName, double productPrice, int productStock){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductStock(){
        return productStock;
    }

    public abstract String getDescription();

    public void getOffStock(int content) {
    }
}
