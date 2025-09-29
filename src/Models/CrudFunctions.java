package Models;

import Interfaces.ProductsCrud;
import Utils.Jframes.Container;

import javax.swing.*;

// Abstract class that implements ProductsCrud and defines common CRUD functions
public abstract class CrudFunctions implements ProductsCrud {
    protected JFrame container; // Main application window

    // Initialize main container window
    public void setContainer(){
        container = Container.createWindow();
    }

    // Add product button
    @Override
    public void addProduct(){
        Utils.Create.button(container);
    }

    // Show all products button
    @Override
    public void readProduct() {
        Utils.Read.Button(container);
    }

    // Update product button
    @Override
    public void update() {
        Utils.Update.Button(container);
    }

    // Delete product button
    @Override
    public void delete() {
        Utils.Delete.Button(container);
    }

    // Search product button
    @Override
    public void search() {
        Utils.Search.Button(container);
    }

    // Exit application button
    public void Exit(){
        Utils.Exit.Button(container);
    }
}
