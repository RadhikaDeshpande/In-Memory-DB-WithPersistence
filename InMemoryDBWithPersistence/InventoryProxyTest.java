package InMemoryDBWithPersistence;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryProxyTest {

    @Test

    public void testAddMovie() {

        InventoryProxy inventoryProxy = new InventoryProxy();

        boolean addMovieStatus = inventoryProxy.addMovie("abc",10, 24);

        assertEquals(addMovieStatus, true);

    }

    @Test

    public void testAddQuantity() {

        InventoryProxy inventoryProxy = new InventoryProxy();

        inventoryProxy.addMovie("abc", 10, 10);

        boolean addQuantityStatus = inventoryProxy.addQuantity("abc",10);

        assertEquals(addQuantityStatus, true);

    }

    @Test

    public void testSellMovie() {

        InventoryProxy inventoryProxy = new InventoryProxy();

        inventoryProxy.addMovie("abc", 10, 10);

        boolean sellMovieStatus = inventoryProxy.sellMovie("abc",3);

        assertEquals(sellMovieStatus, true);

        sellMovieStatus = inventoryProxy.sellMovie ("abc",20);

        assertEquals(sellMovieStatus, false);

    }

    @Test

    public void testChangePrice() {

        InventoryProxy inventoryProxy = new InventoryProxy();

        inventoryProxy.addMovie("abc", 120, 5);

        boolean changePriceStatus = inventoryProxy.changePrice("abc",20);

        assertEquals(changePriceStatus, true);

    }

}

