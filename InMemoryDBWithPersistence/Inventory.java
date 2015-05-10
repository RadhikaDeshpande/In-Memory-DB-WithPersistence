package InMemoryDBWithPersistence;

import java.util.ArrayList;

//Originator Class

public class Inventory implements IInventory {

    private ArrayList<Movie> movieList;

    public Inventory() {

        this.movieList = new ArrayList<Movie>();

    }

    public Movie find(Object o) {

        for (Movie movieObj : this.movieList) {

            if (o instanceof String && movieObj.getName().equals(o))

                return movieObj;

            else if (o instanceof Integer

                    && movieObj.getUniqueId() == (Integer) o)

                return movieObj;

        }

        return null;

    }

    public boolean addMovie(String name, double price, int quantity) {

        try {

            Movie movie = new Movie(name, price, quantity,

                    this.movieList.size());

            this.movieList.add(movie);



        } catch (Exception ex) {
            return false;

        }

        return true;

    }

    public boolean addQuantity(String name, int quantity) {

        Movie movie = this.find(name);

        if (movie == null) {
            System.out.println("movie not found");

            return false;

        }


    movie.addQuantity(quantity);
    return true;




    }

    public boolean sellMovie(String name, int noOfCopies) {

        Movie movie = this.find(name);

        if (movie == null) {

            System.out.println("requested movie does not exist");

            return false;
        }



        return movie.sellMovie(noOfCopies);

    }


    public boolean changePrice(String name, int newPrice) {

        Movie movie = this.find(name);

        if (movie == null) {

            System.out.println("movie not found");

            return false;

        }

        movie.changePrice(newPrice);

        return true;

    }

    public Memento createMemento() {

        System.out.println("Originator/Inventory: Saving to Memento.");

        return new Memento(this);

    }

    public void writeMementoToFile(Memento memento) {

        memento.writeMementoToFile();

    }

    public void restoreInventoryFromDataFile() {

        this.restoreInventoryFromMemento(Memento.readMementoFromFile());

    }

    public void restoreInventoryFromMemento(Memento memento) {

        this.movieList = memento.inventory.movieList;

    }

/* Memento is kept inside Inventory class so as to give full

 * access to originator(Inventory) & narrow access to

 * care taker(InventoryProxy)

 */

    public static class Memento {

        private final Inventory inventory;

        public Memento(Inventory stateToSave) {

            inventory = new Inventory();

            for (Movie movie : stateToSave.movieList) {


                inventory.movieList.add(new Movie(movie.getName(), movie

                        .getPrice(), movie.getQuantity(), movie.getUniqueId()));


            }

        }

        public Memento() {

            this.inventory = new Inventory();

        }

        private void writeMementoToFile() {

            SerializeIO.writeToFile(this.inventory.movieList,

                    SerializeIO.MEMENTO_FILE_NAME, false);


        }

        private static Memento readMementoFromFile() {

            Memento memento = new Memento();

            @SuppressWarnings("unchecked")

            ArrayList<Movie> inventory = (ArrayList<Movie>) SerializeIO.readFromFile(SerializeIO.MEMENTO_FILE_NAME);


            if (inventory != null)
                memento.inventory.movieList = inventory;

                return memento;

        }

    }

}





