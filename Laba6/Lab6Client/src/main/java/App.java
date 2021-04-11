import commands.*;
import exchange.ExchangeOfCommands;
import managers.*;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int port = 3000;
        String host = "localhost";
        Scanner userScanner = new Scanner(System.in);
        Asker asker = new Asker(userScanner);
        CollectionManager collectionManager = new CollectionManager();
        ExchangeOfCommands exchangeOfCommands = new ExchangeOfCommands(new ShowCommand(collectionManager), "");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("somefile"));
        objectOutputStream.writeObject(exchangeOfCommands);
        System.out.println("Записал!");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("somefile"));
        ExchangeOfCommands exchangeOfCommands1 = (ExchangeOfCommands) objectInputStream.readObject();
        System.out.println(exchangeOfCommands1);
        Client client = new Client(host, port);
        CommandManager commandManager = new CommandManager(client, new AddCommand(collectionManager, asker, client), new ClearCommand(collectionManager), new GroupCountingByIdCommand(collectionManager), new ShowCommand(collectionManager), new HelpCommand(), new HistoryCommand(), new InfoCommand(collectionManager), new RemoveAllByHealthCommand(collectionManager), new RemoveAnyByAchievementsCommand(collectionManager), new RemoveFirstCommand(collectionManager), new RemoveGreaterCommand(collectionManager, asker), new UpdateCommand(collectionManager, asker), new ExitCommand(), new RemoveById(collectionManager));
        ConsoleManager consoleManager = new ConsoleManager(userScanner, commandManager);
        consoleManager.userMode();
    }
}
