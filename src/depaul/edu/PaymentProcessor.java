package depaul.edu;


class PaymentProcessor {
    //Processing payment based on the  amount
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