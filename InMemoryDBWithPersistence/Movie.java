package InMemoryDBWithPersistence;

public class Movie implements java.io.Serializable {

    private transient static final long serialVersionUID = 1L;

    private String name;

    private int quantity;

    private double price;

    private int uniqueId;

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public int getQuantity() {

        return quantity;

    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;

    }

    public double getPrice() {

        return price;

    }

    public void setPrice(double price) {

        this.price = price;

    }

    public int getUniqueId() {

        return uniqueId;

    }

    public void setUniqueId(int uniqueId) {

        this.uniqueId = uniqueId;

    }

    public Movie(String name, double price, int quantity, int uniqueId) {

        this.name = name;

        this.price = price;

        this.quantity = quantity;

        this.uniqueId = uniqueId;

        System.out.println("movie : " + this.name + " added");

    }

    public void addQuantity(int quantity) {

        this.quantity += quantity;

        System.out.println(this.quantity);

    }

    public boolean sellMovie(int noOfCopies) {

        if (this.quantity >= noOfCopies) {

            this.quantity = this.quantity - noOfCopies;

            System.out.println("Copies remaining = " + this.quantity);

            return true;

        } else if (this.quantity == 0) {

            System.out.println("please come again we are out of stock");

            return false;

        } else {

            System.out.println("we only have " + this.quantity + " copies");

            return false;

        }

    }

    public void changePrice(int newPrice) {

        this.price = newPrice;

        System.out.println(this.price);

    }
}