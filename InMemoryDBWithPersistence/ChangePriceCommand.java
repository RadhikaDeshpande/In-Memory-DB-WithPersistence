package InMemoryDBWithPersistence;

public class ChangePriceCommand implements java.io.Serializable, ICommand {

    private static final long serialVersionUID = 1L;

    private transient Inventory inventory;

    private String name;

    private int price;

    public ChangePriceCommand(String name, int price) {

        this.name = name;

        this.price = price;

    }

    @Override

    public boolean execute() {

// TODO Auto-generated method stub

        return inventory.changePrice(name, price);

    }

    @Override

    public void setInventory(Inventory inventory) {

// TODO Auto-generated method stub

        this.inventory = inventory;

    }

}