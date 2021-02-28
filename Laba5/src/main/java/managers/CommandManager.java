package managers;

import commands.AddCommand;
import commands.Command;
import commands.SaveCommand;
import commands.ShowCommand;
import data.SpaceMarine;

import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.Stack;

public class CommandManager {
    private AddCommand addCommand;
    private Command clearCommand;
    private ShowCommand showCommand;
    private SaveCommand saveCommand;

    public CommandManager(AddCommand addCommand, Command clearCommand, ShowCommand showCommand, SaveCommand saveCommand) {
        this.addCommand = addCommand;
        this.clearCommand = clearCommand;
        this.showCommand = showCommand;
        this.saveCommand=saveCommand;

    }
    public void saveCollection(String argument){
        saveCommand.execute(argument);
    }
    public void addCollection(String argument) {
        addCommand.execute(argument);
    }

    public void showCollection(String argument) {
        showCommand.execute(argument);
    }

    public void clearCollection(String argument) {
        clearCommand.execute(argument);
    }

    @Override
    public String toString() {
        return "CommandManager{" +
                "addCommand=" + addCommand +
                ", clearCommand=" + clearCommand +
                '}';
    }

}

//TODO: доделать тут методы для команд