package InMemoryDBWithPersistence;

import java.util.ArrayList;

//Caretaker of the Inventory

public class InventoryProxy implements IInventory {

    private static int COMMANDS_LIMIT = 10;

    private InventoryOperation inventoryOperation;

    private Inventory inventory;

    private ArrayList<Inventory.Memento> mementoList;

    public InventoryProxy() {

        this.inventory = new Inventory();

        this.inventoryOperation = new InventoryOperation();

        this.mementoList = new ArrayList<Inventory.Memento>();

    }

// Loading the Inventory from memento.data & performing

// the operations on the inventory that are saved in command.data.

    public static InventoryProxy loadInventory() {

        InventoryProxy ip = new InventoryProxy();

        ip.inventory = new Inventory();

        ip.inventory.restoreInventoryFromDataFile();

        ip.inventoryOperation = new InventoryOperation();

        ArrayList<ICommand> commandList = ip.inventoryOperation.readOperation();

        if (commandList != null) {

            for (ICommand command : commandList) {

                command.setInventory(ip.inventory);

                ip.inventoryOperation.performOperation(command);

            }

        }

        return ip;

    }

// Checks for the commands limit, if greater writes all commands to memento

// and clears all the command in the command file.

    public boolean performOperation(ICommand command) {

        if (this.inventoryOperation.getCommandListSize() >= COMMANDS_LIMIT) {
            this.inventory.writeMementoToFile(this.inventory.createMemento());
            this.inventoryOperation.clearCommands();

        }

        command.setInventory(this.inventory);

        return this.inventoryOperation.performOperation(command);

    }

    @Override

    public boolean addMovie(String movieName, double price, int quantity) {

        return this.performOperation(new AddMovieCommand(movieName, price, quantity));

    }

    @Override

    public boolean addQuantity(String movieName, int quantity) {

        return this .performOperation(new AddQuantityCommand(movieName, quantity));




    }

    @Override

    public boolean sellMovie(String movieName, int quantity) {

        return this.performOperation(new SellMovieCommand(movieName, quantity));

    }

    @Override

    public boolean changePrice(String movieName, int price) {

        return this.performOperation(new ChangePriceCommand(movieName, price));

    }

// Current state of inventory has been

// backed up in memory, and added to savedStates.

    public void saveCurrentState() {

        this.mementoList.add(this.inventory.createMemento());

    }

// Rolling back to a state what inventory had before

// crashing or terminating the program.

    public void restorePreviousState() {

        if (this.mementoList.size() > 0)

            this.inventory.restoreInventoryFromMemento(this.mementoList.get(this.mementoList.size() - 1));

    }


}




