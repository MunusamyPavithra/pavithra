package depaul.edu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessor {
    public static boolean processPayment(double amount) {
        if (amount > 0) {
            System.out.println("Processing payment...");
            System.out.println("Payment successful! Amount paid: $" + amount);
            return true;
        } else {
            System.out.println("Processing payment...");
            System.out.println("Payment failed. Invalid amount.");
            return false;
        }
    }
}