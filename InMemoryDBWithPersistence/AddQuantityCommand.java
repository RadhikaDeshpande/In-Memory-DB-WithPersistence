package InMemoryDBWithPersistence;

public class AddQuantityCommand implements java.io.Serializable, ICommand {

    private static final long serialVersionUID = 1L;

    private transient Inventory inventory;

    private String name;

    private int quantity;

    public AddQuantityCommand(String name, int quantity) {

        this.name = name;

        this.quantity = quantity;

    }

    @Override

    public boolean execute() {

// TODO Auto-generated method stub

        return inventory.addQuantity(name, quantity);

    }

    @Override

    public void setInventory(Inventory inventory) {

        this.inventory = inventory;

    }

}