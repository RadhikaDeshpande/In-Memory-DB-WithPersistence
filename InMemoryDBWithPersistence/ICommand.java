package InMemoryDBWithPersistence;

public interface ICommand {

    public boolean execute();

    public void setInventory(Inventory inventory);

}