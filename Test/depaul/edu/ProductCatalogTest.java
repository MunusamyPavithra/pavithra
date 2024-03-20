package depaul.edu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCatalogTest {
    private ProductCatalog catalog;

    @Before
    public void setUp() {
        catalog = new ProductCatalog();
    }

    @Test
    public void testContainsProduct() {
        assertTrue(catalog.containsProduct("Laptop"));
        assertFalse(catalog.containsProduct("Smartphone"));
    }

    @Test
    public void testGetProductPrice() {
        assertEquals(1000.0, catalog.getProductPrice("Laptop"), 0.001);
        assertEquals(0.0, catalog.getProductPrice("Smartphone"), 0.001);
    }

    @Test
    public void testCreateProduct() {
        Product product = catalog.createProduct("T-shirt");
        assertNotNull(product);
        assertEquals("T-shirt", product.getName());
        assertEquals(20.0, product.getPrice(), 0.001);
    }
}