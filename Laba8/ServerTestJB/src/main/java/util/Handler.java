package util;

import DAO.DAO;
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
        System.out.println("Обработка команды - " + exchangeClass);
        try {
            if (exchangeClass.getUser() == null) {
                exchangeClass.setAnswer("Вы не можете работать с сервером, пока не авторитизируетесь!");
                return exchangeClass;
            }
            DAO.getDaoSpaceMarine().setUser(exchangeClass.getUser());
            commandManager.addToHistory(exchangeClass.getName());
            switch (exchangeClass.getName().trim()) {
                case "add":
                    DAO.getDaoSpaceMarine().setUser(exchangeClass.getUser());
                    exchangeClass.getSpaceMarine().setId(collectionManager.generateId());
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
                    if (collectionManager.collectionIsEmpty()) {
                        exchangeClass.setAnswer("Коллекция пуста, поэтому Вы не можете удалить из неё элементы. Для начала добавьте элемент в коллекцию");
                    } else
                        exchangeClass.setAnswer(collectionManager.removeAllByHealth(Long.parseLong(exchangeClass.getArgument())));
                    break;
                case "remove_first":
                    if (collectionManager.collectionIsEmpty()) {
                        exchangeClass.setAnswer("Коллекция пуста, поэтому Вы не можете удалить из неё элементы. Для начала добавьте элемент в коллекцию");
                    } else
                        exchangeClass.setAnswer(collectionManager.removeFirst());
                    break;
                case "group_counting_by_id":
                    exchangeClass.setAnswer(collectionManager.groupCountingById());
                    break;
                case "remove_by_id":
                    exchangeClass.setAnswer(commandManager.removeById.execute(exchangeClass.getArgument()));
                    break;
                case "update":
                    System.out.println(Long.parseLong(exchangeClass.getArgument()) < 1 || Integer.parseInt(exchangeClass.getArgument()) > DAO.getDaoSpaceMarine().countOfElements());
                    if (DAO.getDaoSpaceMarine().countOfElements() == 0) {
                        exchangeClass.setAnswer("Коллекция пуста, поэтому Вы не можете её обновить. Для начала добавьте элемент в коллекцию");
                    } else if (!DAO.getDaoSpaceMarine().listOfID().contains(Long.parseLong(exchangeClass.getArgument()))) {
                        exchangeClass.setAnswer("Айди солдата должен лежать в диапозоне " + DAO.getDaoSpaceMarine().listOfID());
                    } else {
                        exchangeClass.getSpaceMarine().setId(Long.valueOf(exchangeClass.getArgument()));
                        exchangeClass.setAnswer(collectionManager.updateCollection(exchangeClass.getSpaceMarine(), Long.valueOf(exchangeClass.getArgument())));
                    }
                    break;
                case "remove_any_by_achievements":
                    if (collectionManager.collectionIsEmpty()) {
                        exchangeClass.setAnswer("Коллекция пуста, поэтому Вы не можете удалить из неё элементы. Для начала добавьте элемент в коллекцию");
                    } else
                        exchangeClass.setAnswer(collectionManager.removeAnyByAchievements(exchangeClass.getArgument()));
                    break;
                case "remove_greater":
                    if (collectionManager.getSizeCollection() == 0) {
                        exchangeClass.setAnswer("Коллекция пуста, поэтому Вы не можете удалить из неё элементы. Для начала добавьте элемент в коллекцию");
                    } else {
                        exchangeClass.setAnswer(collectionManager.removeGreaterCommand(exchangeClass.getSpaceMarine()));
                    }
                    break;
                case "register":
                    if (DAO.getDaoUser().isExist(exchangeClass.getUser())) {
                        exchangeClass.setAnswer(DAO.getDaoUser().create(exchangeClass.getUser()));
                        if (exchangeClass.getAnswer().equals("1")) {
                            exchangeClass.setAnswer("Пользователь успешно создан!");
                            DAO.getDaoUser().addToListUsers(Integer.valueOf(DAO.getDaoUser().login(exchangeClass.getUser())));
                        }
                    } else exchangeClass.setAnswer("Такой пользователь уже существует.");
                    break;
                case "login":
                    if (DAO.getDaoUser().alreadyInOnline(exchangeClass.getUser())) {
                        exchangeClass.setAnswer("Пользователь уже в сети, вы не можете войти. Завершите все другие сессии, чтобы войти");
                    } else {
                        exchangeClass.setAnswer(DAO.getDaoUser().login(exchangeClass.getUser()));
                        if (exchangeClass.getAnswer() == null)
                            exchangeClass.setAnswer("Такого пользователя не существует.Повторите попытку");
                        else {
                            DAO.getDaoUser().addToListUsers(Integer.valueOf(DAO.getDaoUser().login(exchangeClass.getUser())));
                            exchangeClass.setAnswer("Вы успешно вошли!");
                        }
                    }
                    break;
                case "exit":
                    DAO.getDaoUser().userExit(exchangeClass.getUser());
                    exchangeClass.setAnswer("Клиент успешно вышел!");
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
