package Service;

import Models.Products;

public class ElectricalAppliance extends Products {
    private final String description;
    public ElectricalAppliance(String productName, double productPrice, String description, int productStock) {
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


}
