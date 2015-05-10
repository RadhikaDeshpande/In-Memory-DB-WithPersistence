package InMemoryDBWithPersistence;

public class AddMovieCommand implements java.io.Serializable, ICommand {

    private static final long serialVersionUID = 1L;

    private transient Inventory inventory;

    private String name;

    private double price;

    private int quantity;

    public AddMovieCommand(String name, double price, int quantity) {

        this.name = name;

        this.price = price;

        this.quantity = quantity;

    }

    @Override

    public boolean execute() {

// TODO Auto-generated method stub

        return inventory.addMovie(name, price, quantity);

    }

    @Override

    public void setInventory(Inventory inventory) {

        this.inventory = inventory;

    }

}