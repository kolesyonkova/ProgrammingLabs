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
        CommandManager commandManager = new CommandManager(new AddCommand(collectionManager, asker), new ClearCommand(collectionManager), new GroupCountingByIdCommand(), new ShowCommand(collectionManager), new SaveCommand(collectionManager, fileManager), new HelpCommand(), new HistoryCommand(), new InfoCommand(collectionManager), new RemoveAllByHealthCommand(), new RemoveAnyByAchievementsCommand(), new RemoveFirstCommand(), new RemoveGreaterCommand(), new UpdateCommand(), new ExitCommand());
        ConsoleManager consoleManager = new ConsoleManager(userScanner, commandManager, fileManager);
        collectionManager.loadCollectionFromStartFile();
        consoleManager.userMode();
    }
}

