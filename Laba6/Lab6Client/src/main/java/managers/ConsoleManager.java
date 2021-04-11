package managers;

import exceptions.NoAccessToFileException;
import exceptions.ScriptRecursionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Operates command input.
 */
public class ConsoleManager {
    private CommandManager commandManager;
    private int counter;
    private Scanner userScanner;
    private List<String> scriptStack = new ArrayList<>();



    public ConsoleManager(Scanner userScanner, CommandManager commandManager) {
        this.userScanner = userScanner;
        this.commandManager = commandManager;
    }


    /**
     * Mode for work with commands from user input.
     */
    public void userMode() {
        String[] userCommand;
        try {
            while (true) {
                System.out.println("Введите команду: ");
                userCommand = (userScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                commandManager.addToHistory(userCommand[0]);
                startCommand(userCommand);
            }
        } catch (NoSuchElementException exception) {
            System.out.println("Введён конец файла! Завершаю программу.");
            System.exit(0);
        } catch (IllegalStateException exception) {
            System.out.println("Непредвиденная ошибка!");
        }
    }

    /**
     * Mode for work with commands from a script.
     */
    public void scriptMode(String argument) {
        String[] userCommand;
        boolean isReadable = true;
        scriptStack.add(argument);
        try {
            File file = new File(argument);
            if (file.exists() && !file.canRead()) {
                isReadable = false;
                throw new NoAccessToFileException();
            } else if (file.exists()) {
                isReadable = true;
            }
        } catch (NoAccessToFileException e) {
            System.out.println("Добавьте файлу права на чтение! И попробуйте снова!");
        }
        if (isReadable) {
            try (Scanner scriptScanner = new Scanner(new File(argument))) {
                if (!scriptScanner.hasNext()) throw new NoSuchElementException();
                do {
                    userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                    userCommand[1] = userCommand[1].trim();
                    while (scriptScanner.hasNextLine() && userCommand[0].isEmpty()) {
                        userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                        userCommand[1] = userCommand[1].trim();
                    }
                    System.out.println(String.join(" ", userCommand));
                    if (userCommand[0].equals("execute_script")) {
                        for (String script : scriptStack) {
                            if (userCommand[1].equals(script)) {
                                counter += 1;
                                if (counter > 3) {
                                    throw new ScriptRecursionException();
                                }
                            }
                        }
                    }
                    commandManager.addToHistory(userCommand[0]);
                    startCommand(userCommand);
                } while (scriptScanner.hasNextLine());
            } catch (FileNotFoundException exception) {
                System.out.println("Файл со скриптом не найден!");
            } catch (NoSuchElementException exception) {
                System.out.println("Файл со скриптом пуст!");
            } catch (ScriptRecursionException e) {
                System.out.println("Скрипты не могут вызываться рекурсивно!");
                userMode();
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Перезапустите программу");
            } finally {
                scriptStack.remove(scriptStack.size() - 1);
            }
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
                case "execute_script":
                    scriptMode(userCommand[1]);
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
        } catch (ExceptionInInitializerError | IOException | ClassNotFoundException e) {
            System.out.println("Что-то пошло не так");
        }
    }

}
