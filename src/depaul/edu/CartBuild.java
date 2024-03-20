package depaul.edu;

public class CartBuild {
    private ShoppingCart cart;

    //Constructs a CartBuild object and initializes the shopping cart instance.
    public CartBuild() {
        this.cart = ShoppingCart.getInstance();
    }

    public CartBuild addItem(Product product, int quantity) {
        cart.addToCart(product, quantity);
        return this;
    }

    // Builds and returns the finalized shopping cart instance
    public ShoppingCart build() {
        return cart;
    }
}