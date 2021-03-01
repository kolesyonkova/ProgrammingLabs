package run;

import commands.*;
import managers.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);
        String path = "data.csv";
        FileManager fileManager = new FileManager(path);
        Asker asker = new Asker(userScanner);
        CollectionManager collectionManager = new CollectionManager(fileManager);
        CommandManager commandManager = new CommandManager(new AddCommand(collectionManager, asker), new ClearCommand(collectionManager), new GroupCountingByIdCommand(), new ShowCommand(collectionManager), new SaveCommand(collectionManager, fileManager), new HelpCommand(), new HistoryCommand(), new InfoCommand(collectionManager), new RemoveAllByHealthCommand(collectionManager), new RemoveAnyByAchievementsCommand(collectionManager), new RemoveFirstCommand(collectionManager), new RemoveGreaterCommand(collectionManager,asker), new UpdateCommand(collectionManager,asker), new ExitCommand(),new RemoveById(collectionManager));
        ConsoleManager consoleManager = new ConsoleManager(userScanner, commandManager, fileManager);
        collectionManager.loadCollectionFromStartFile();
        consoleManager.userMode();
    }
}

