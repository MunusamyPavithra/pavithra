package depaul.edu;

class Electronics implements Product {
    private String name;
    private double price;

    // Constructor for creating  new Electronics instance with the specified name and price
    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}