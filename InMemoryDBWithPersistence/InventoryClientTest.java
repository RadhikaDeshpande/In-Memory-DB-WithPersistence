package InMemoryDBWithPersistence;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryClientTest {

    @Test

    public void testInventoryClient() {

        InventoryProxy proxy = new InventoryProxy();

// A command will be created and written into file

// upon any operation that changes inventory state is performed.

        assertTrue(proxy.addMovie("MIB1", 100, 3));

        assertTrue(proxy.addMovie("MIB2", 120, 5));

        assertTrue(proxy.addQuantity("MIB1", 5));

        assertTrue(proxy.sellMovie("MIB2", 2));

        assertTrue(proxy.addMovie("Kal Ho Na Ho", 100, 10));

        assertTrue(proxy.addQuantity("Kal Ho Na Ho", 5000));

    }

    @Test

    public void testLoadInventory() {

// Loading the Inventory from memento.data & performing

// the operations on the inventory that are saved in command.data.

        InventoryProxy proxy = InventoryProxy.loadInventory();

        assertTrue(proxy.addQuantity("MIB1", 2));

        assertFalse(proxy.addQuantity("OMG", 5));

    }

    @Test

    public void testSaveAndRestoreStates() {

        InventoryProxy proxy = InventoryProxy.loadInventory();

        assertTrue(proxy.addMovie("MIB2", 120, 5));

// Current state of inventory has been

// backed up in memory, and added to savedStates.

        proxy.saveCurrentState();

        assertTrue(proxy.addMovie("Inception", 12, 5));

        assertTrue(proxy.addQuantity("Inception", 5));

// Rolling back to a state where inventory has only MIB2

// Now, performing any operation on Inception will assert to false.

        proxy.restorePreviousState();

        assertFalse(proxy.addQuantity("Inception", 5));

    }

}