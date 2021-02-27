package run;

import commands.AddCommand;
import commands.ClearCommand;
import commands.ShowCommand;
import managers.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);
        String path="data.csv";
        FileManager fileManager = new FileManager(path);
        Asker asker = new Asker(userScanner);
        CollectionManager collectionManager=new CollectionManager(fileManager);
        CommandManager commandManager = new CommandManager(new AddCommand(collectionManager,asker), new ClearCommand(),new ShowCommand(collectionManager));
        ConsoleManager consoleManager = new ConsoleManager(userScanner, commandManager, fileManager);
        consoleManager.startFirstPut();
        consoleManager.userMode();
    }
}

