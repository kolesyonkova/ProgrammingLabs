package managers;

import exchange.ExchangeOfCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Operates command input.
 */
public class ConsoleManager {
    CommandManager commandManager;
    FileManager fileManager;
    private int counter;
    private Scanner userScanner;
    private List<String> scriptStack = new ArrayList<>();

    public ConsoleManager(CommandManager commandManager, FileManager fileManager) {
        this.userScanner = userScanner;
        this.commandManager = commandManager;
        this.fileManager = fileManager;
    }

    /**
     * Mode for work with commands from user input.
     *
     * @param command
     */
    public void userMode(ExchangeOfCommands command) {
        String[] userCommand = new String[2];
        try {
            userCommand[0] = command.getCommand().getName();
            userCommand[1] = command.getArgument();
            commandManager.addToHistory(command.getCommand().getName());
            startCommand(userCommand);
        } catch (NoSuchElementException exception) {
            System.out.println("Введён конец файла! Завершаю программу.");
            System.exit(0);
        } catch (IllegalStateException exception) {
            System.out.println("Непредвиденная ошибка!");
        }
    }

    /**
     * Selects and start command execute.
     */
    public void startCommand(String[] userCommand) {
        try {
            switch (userCommand[0]) {
                case "add":
                    commandManager.addCollection(userCommand[1]);
                    break;
                case "help":
                    commandManager.help(userCommand[1]);
                    break;
                case "show":
                    System.out.println("Я тут в шоу");
                    commandManager.showCollection(userCommand[1]);
                    break;
                case "info":
                    commandManager.info(userCommand[1]);
                    break;
                case "update":
                    commandManager.updateCollection(userCommand[1]);
                    break;
                case "remove_by_id":
                    commandManager.removeById(userCommand[1]);
                    break;
                case "clear":
                    commandManager.clearCollection(userCommand[1]);
                    break;
                case "save":
                    commandManager.saveCollection(userCommand[1]);
                    break;
                case "exit":
                    commandManager.exitCommand(userCommand[1]);
                    break;
                case "remove_first":
                    commandManager.removeFirstCommand(userCommand[1]);
                    break;
                case "remove_greater":
                    commandManager.removeGreaterCommand(userCommand[1]);
                    break;
                case "history":
                    commandManager.getHistory(userCommand[1]);
                    break;
                case "remove_all_by_health":
                    commandManager.removeAllByHealthCommand(userCommand[1]);
                    break;
                case "remove_any_by_achievements":
                    commandManager.removeAnyByAchievements(userCommand[1]);
                    break;
                case "group_counting_by_id":
                    commandManager.groupCountingByIdCommand(userCommand[1]);
                    break;
                default:
                    System.out.println("Не является внутренней командой. Повтороте ввод или напишите help для получения актуального списка команд.");
            }
        } catch (ExceptionInInitializerError e) {
            System.out.println("Что-то пошло не так");
        }
    }

}
