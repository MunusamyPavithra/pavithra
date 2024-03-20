package depaul.edu;

import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
    private static ShoppingCart instance;
    private Map<Product, Integer> cart;

    private ShoppingCart() {
        cart = new HashMap<>();
    }

    // Retrieves the singleton instance of the shopping cart
    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addToCart(Product product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    // Retrieves the singleton instance of the shopping cart
    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey().getName() + " - Quantity: " + entry.getValue() +
                    ", Price: $" + entry.getKey().getPrice() * entry.getValue());
        }
    }

    // Calculates and returns the total price of every items in the cart
    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    // Clearing cart
    public void clearCart() {
        cart.clear();
    }
}