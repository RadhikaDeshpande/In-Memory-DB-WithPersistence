package InMemoryDBWithPersistence;

public class SellMovieCommand implements java.io.Serializable, ICommand {

    private static final long serialVersionUID = 1L;

    private transient Inventory inventory;

    private String name;

    private int noOfCopies;

    public SellMovieCommand(String name, int noOfCopies) {

        this.name = name;

        this.noOfCopies = noOfCopies;

    }

    @Override

    public boolean execute() {

// TODO Auto-generated method stub

        return inventory.sellMovie(name, noOfCopies);

    }

    @Override

    public void setInventory(Inventory inventory) {

        this.inventory = inventory;

    }

}
