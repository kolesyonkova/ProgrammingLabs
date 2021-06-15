package run;

import commands.*;
import gui.MainFrameManager;
import gui.StartMenu;
import managers.*;
import util.Client;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main application class. Creates all instances and runs the program.
 *
 * @author Колесенкова Екатерина P3112
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Перед началом работы с сервером вам необходимо будет войти/зарегестрироваться");
        System.out.println("Сделать вы можете это при помощи команд login и register");
        Client.start();
        Scanner userScanner = new Scanner(System.in);
        final String myenv = "WC_FILE";
        FileManager fileManager = new FileManager(myenv);
        Asker asker = new Asker(userScanner);
        CollectionManager collectionManager = new CollectionManager(fileManager);
        CommandManager commandManager = new CommandManager(new AddCommand(collectionManager, asker), new ClearCommand(collectionManager), new GroupCountingByIdCommand(collectionManager), new ShowCommand(collectionManager), new SaveCommand(collectionManager, fileManager), new HelpCommand(), new HistoryCommand(), new InfoCommand(collectionManager), new RemoveAllByHealthCommand(collectionManager), new RemoveAnyByAchievementsCommand(collectionManager), new RemoveFirstCommand(collectionManager), new RemoveGreaterCommand(collectionManager, asker), new UpdateCommand(collectionManager, asker), new ExitCommand(), new RemoveById(collectionManager));
        ConsoleManager consoleManager = new ConsoleManager(userScanner, commandManager, fileManager);
        //  collectionManager.loadCollectionFromStartFile();
     //   consoleManager.userMode();
        MainFrameManager mainFrameManager = MainFrameManager.getInstance();
        StartMenu startMenu;
        startMenu = new StartMenu();
        mainFrameManager.initialization(startMenu.getStartMenuPanel());

    }
}

