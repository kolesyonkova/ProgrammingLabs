package util;

import managers.Asker;
import managers.CollectionManager;
import managers.CommandManager;
import managers.FileManager;

import java.util.Scanner;

public class Handler {
    private static Scanner userScanner;
    private static String myenv;
    private static FileManager fileManager;
    private static CollectionManager collectionManager;
    private static Asker asker;
    private static CommandManager commandManager;

    public Handler(Scanner userScanner, String myenv, CollectionManager collectionManager, FileManager fileManager, Asker asker, CommandManager commandManager) {
        Handler.userScanner = userScanner;
        Handler.myenv = myenv;
        Handler.fileManager = fileManager;
        Handler.collectionManager = collectionManager;
        Handler.asker = asker;
        Handler.commandManager = commandManager;

    }

    public static ExchangeClass startCommand(ExchangeClass exchangeClass) {
        try {
            switch (exchangeClass.getName()) {
                case "add":
                    collectionManager.addToCollection(exchangeClass.getSpaceMarine());
                    exchangeClass.setAnswer("Элемент успешно добавлен в коллецию");
                    break;
                case "help":
                    exchangeClass.setAnswer(commandManager.help(""));
                    break;
                case "show":
                    exchangeClass.setAnswer(collectionManager.showCollection());
                    break;
                default:
                    System.out.println("Не является внутренней командой. Повтороте ввод или напишите help для получения актуального списка команд.");
            }
        } catch (ExceptionInInitializerError e) {
            System.out.println("Что-то пошло не так");
        }
        return exchangeClass;
    }
}
