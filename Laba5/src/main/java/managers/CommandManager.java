package managers;

import commands.AddCommand;
import commands.Command;

public class CommandManager {
    private AddCommand addCommand;
    private Command clearCommand;

    public CommandManager(AddCommand addCommand, Command clearCommand) {
        this.addCommand = addCommand;
        this.clearCommand = clearCommand;
    }
    public void addCollection(){
        System.out.println("я В комманд менеджере!");
        addCommand.execute();
    }
    public void clearCollection(){
        clearCommand.execute();
    }
}
//TODO: доделать тут методы для команд