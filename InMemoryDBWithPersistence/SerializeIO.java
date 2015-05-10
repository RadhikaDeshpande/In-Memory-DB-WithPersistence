package InMemoryDBWithPersistence;

import java.io.*;

public class SerializeIO {

    public static final String COMMAND_FILE_NAME = "command.data";

    public static final String MEMENTO_FILE_NAME = "memento.data";

    public static void writeToFile(Object object, String fileName, boolean append) {
        try {

            FileOutputStream fileOut = new FileOutputStream(fileName, append);

            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(object);

            out.flush();

            out.close();

            fileOut.close();



        } catch (IOException i) {
            i.printStackTrace();

        }

    }

    public static Object readFromFile(String fileName) {

        Object object = null;

        try {
            FileInputStream fileIn = new FileInputStream(fileName);

            ObjectInputStream in = new ObjectInputStream(fileIn);

            object = in.readObject();

            in.close();

            fileIn.close();






        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return object;

    }

}

