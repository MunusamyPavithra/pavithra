package depaul.edu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserAuthentication {
    private static Scanner scanner = new Scanner(System.in);
    private static UserManagement userManagement = new UserManagement();
    private static ProductCatalog productCatalog = new ProductCatalog();
    private static Map<String, ShoppingCart> userCarts = new HashMap<>();
    private static Map<String, Boolean> loggedInUsers = new HashMap<>();


    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Product Catalog");
            System.out.println("4. Place Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    displayProductCatalog();
                    break;
                case 4:
                    placeOrder();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to registering new user
    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (UserManagement.register(username, password)) {
            loggedInUsers.put(username, true);
        }
    }

    // Method to login existing users
    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (UserManagement.login(username, password)) {
            loggedInUsers.put(username, true);
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    // method to Display the products in the Catalog
    private static void displayProductCatalog() {
        productCatalog.displayCatalog();
    }

    // Method for placeorder , check if user is logged and allows users to create shopping cart and add products in cart
    private static void placeOrder() {
        System.out.println("Place Order");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (!loggedInUsers.containsKey(username) || !loggedInUsers.get(username)) {
            System.out.println("Please log in first.");
            return;
        }

        if (!userCarts.containsKey(username)) {
            userCarts.put(username, ShoppingCart.getInstance());
        }

        ShoppingCart cart = userCarts.get(username);

        while (true) {
            productCatalog.displayCatalog();
            System.out.print("Enter product name to add to cart (type 'done' to finish): ");
            String productName = scanner.nextLine();
            if (productName.equalsIgnoreCase("done")) {
                break;
            }

            if (!productCatalog.containsProduct(productName)) {
                System.out.println("Product not found.");
                continue;
            }

            Product product = productCatalog.createProduct(productName);

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            cart.addToCart(product, quantity);
            System.out.println("Product added to cart.");
        }

        double totalPrice = cart.getTotalPrice();
        // display ordersummary
        System.out.println("Order Summary:");
        cart.displayCart();
        System.out.println("Total Price: $" + totalPrice);
        // proceeding for user payment
        System.out.print("Proceed to payment? (yes/no): ");
        String proceed = scanner.nextLine();
        if (proceed.equalsIgnoreCase("yes")) {
            if (PaymentProcessor.processPayment(totalPrice)) {
                System.out.println("Payment successful! Your order has been placed.");
                userCarts.put(username, ShoppingCart.getInstance());
            } else {
                System.out.println("Payment failed. Please try again later.");
            }
        } else {
            System.out.println("Order not placed. Returning to main menu.");
        }
    }
}