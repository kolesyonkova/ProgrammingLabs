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
            commandManager.addToHistory(exchangeClass.getName());
            switch (exchangeClass.getName().trim()) {
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
                case "clear":
                    exchangeClass.setAnswer(collectionManager.clearCollection());
                    break;
                case "info":
                    exchangeClass.setAnswer(collectionManager.infoCollection());
                    break;
                case "history":
                    exchangeClass.setAnswer(commandManager.getHistory(exchangeClass.getArgument()));
                    break;
                case "remove_all_by_health":
                    exchangeClass.setAnswer(collectionManager.removeAllByHealth(Long.parseLong(exchangeClass.getArgument())));
                    break;
                case "remove_first":
                    exchangeClass.setAnswer(collectionManager.removeFirst());
                    break;
                case "group_counting_by_id":
                    exchangeClass.setAnswer(collectionManager.groupCountingById());
                    break;
                case "remove_by_id":
                    exchangeClass.setAnswer(commandManager.removeById.execute(exchangeClass.getArgument()));
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
