package Service;

import Models.CrudFunctions;

// Service class that extends CrudFunctions to manage product operations
public class ProductService extends CrudFunctions {

    // Constructor initializes all CRUD operations and exit button
    public ProductService(){
        setContainer();   // Setup main container (UI)
        addProduct();     // Add new product
        readProduct();    // Show all products
        search();         // Search product by ID
        update();         // Update existing product
        delete();         // Delete product
        Exit();           // Exit application
    }
}
