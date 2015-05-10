package InMemoryDBWithPersistence;

import java.util.ArrayList;

public class InventoryOperation {

    private ArrayList<ICommand> commandList;

    public InventoryOperation() {

        this.commandList = new ArrayList<ICommand>();

    }

    public int getCommandListSize() {

        return this.commandList.size();

    }

// Commands will be added to a list, CommandList is written to a file

// And commands will be executed.

    public boolean performOperation(ICommand command) {

        this.commandList.add(command);

        SerializeIO.writeToFile(commandList, SerializeIO.COMMAND_FILE_NAME,false);
        return command.execute();

    }

    public void clearCommands() {

        this.commandList.clear();

        SerializeIO.writeToFile(commandList, SerializeIO.COMMAND_FILE_NAME,false);

    }

// Reads the commands from the command data file

    public ArrayList<ICommand> readOperation() {

        @SuppressWarnings("unchecked")

        ArrayList<ICommand> commands = (ArrayList<ICommand>) SerializeIO .readFromFile(SerializeIO.COMMAND_FILE_NAME);

        return commands;

    }

}






