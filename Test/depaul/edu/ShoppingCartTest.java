package depaul.edu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    private ShoppingCart cart;

    @Before
    public void setUp() {
        cart = ShoppingCart.getInstance();
    }

    @After
    public void tearDown() {
        cart.clearCart();
    }

    @Test
    public void testAddToCart() {
        Product product = new Clothing("T-shirt", 20.0);
        cart.addToCart(product, 2);
        double totalPrice = cart.getTotalPrice();
        assertEquals(40.0, totalPrice, 0.001); // Check if total price matches
    }
}
