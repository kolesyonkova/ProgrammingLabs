package managers;

import commands.AddCommand;
import commands.Command;
import commands.ShowCommand;
import data.SpaceMarine;

import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.Stack;

public class CommandManager {
    private AddCommand addCommand;
    private Command clearCommand;
    private ShowCommand showCommand;


    public CommandManager(AddCommand addCommand, Command clearCommand, ShowCommand showCommand) {
        this.addCommand = addCommand;
        this.clearCommand = clearCommand;
        this.showCommand = showCommand;

    }

    public void addCollection() {
        addCommand.execute();
    }

    public void showCollection() {
        showCommand.execute();
    }

    public void clearCollection() {
        clearCommand.execute();
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