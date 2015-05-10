package InMemoryDBWithPersistence;

public interface IInventory {

    public boolean addMovie(String name, double price, int quantity);

    public boolean addQuantity(String name, int quantity);

    public boolean sellMovie(String name, int noOfCopies);

    public boolean changePrice(String name, int price);

}
