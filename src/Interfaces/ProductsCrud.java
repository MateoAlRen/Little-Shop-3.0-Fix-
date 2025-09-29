package Interfaces;

// Interface defining CRUD operations for products
public interface ProductsCrud<T> {
    // Create a new product
    void addProduct();

    // Read or display products
    void readProduct();

    // Update an existing product
    void update();

    // Delete a product
    void delete();

    // Search for a product
    void search();
}
