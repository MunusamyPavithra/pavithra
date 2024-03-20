package depaul.edu;

import java.util.HashMap;
import java.util.Map;

class ProductCatalog {
    private Map<String, Double> products;

    // Constructor to initialize the product catalog with default products
    public ProductCatalog() {
        products = new HashMap<>();
        products.put("Laptop", 1000.0);
        products.put("T-shirt", 20.0);
        products.put("Jeans", 50.0);
        products.put("TV", 1500.0);
        products.put("Fridge", 1500.0);

    }

    //Displays the product catalog
    public void displayCatalog() {
        System.out.println("Product Catalog:");
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }

    //checks the products if its existing
    public boolean containsProduct(String productName) {
        return products.containsKey(productName);
    }

    // Retrieving product price
    public double getProductPrice(String productName) {
        return products.getOrDefault(productName, 0.0);
    }

    public Product createProduct(String productName) {
        if (!containsProduct(productName)) {
            throw new IllegalArgumentException("Product not found in the catalog: " + productName);
        }
        double price = getProductPrice(productName);
        if (productName.equalsIgnoreCase("Laptop") || productName.equalsIgnoreCase("TV")) {
            return new Electronics(productName, price);
        } else {
            return new Clothing(productName, price);
        }
    }
}
