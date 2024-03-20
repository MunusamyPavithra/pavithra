package depaul.edu;

class Clothing implements Product {
    private String name;
    private double price;

    // Constructor for creating a new Clothing instance with the specified name and price.
    public Clothing(String name, double price) {
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

