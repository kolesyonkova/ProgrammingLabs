package run;

import commands.AddCommand;
import commands.ClearCommand;
import data.SpaceMarine;
import managers.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        Asker asker = new Asker(userScanner);
        CollectionManager collectionManager=new CollectionManager(fileManager);
        CommandManager commandManager = new CommandManager(new AddCommand(collectionManager,asker), new ClearCommand());
        ConsoleManager consoleManager = new ConsoleManager(userScanner, commandManager, fileManager);
        consoleManager.userMode();
    }
}

