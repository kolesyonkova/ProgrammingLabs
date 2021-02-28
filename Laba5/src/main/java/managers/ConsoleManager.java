package managers;

import exceptions.ScriptRecursionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleManager {
    CommandManager commandManager;
    FileManager fileManager;
    private Scanner userScanner;
    private List<String> scriptStack = new ArrayList<>();

    public ConsoleManager(Scanner userScanner, CommandManager commandManager, FileManager fileManager) {
        this.userScanner = userScanner;
        this.commandManager = commandManager;
        this.fileManager = fileManager;
    }

    public void userMode() {
        String[] userCommand = {"", ""};

        do {
            System.out.println("Введите команду: ");
            userCommand = (userScanner.nextLine().trim() + " ").split(" ", 2);
            userCommand[1] = userCommand[1].trim();
            startCommand(userCommand);

        } while (!userCommand[0].equals("exit"));
    }

    public void scriptMode(String argument) {
        String[] userCommand = {"", ""};
        scriptStack.add(argument);
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
                        if (userCommand[1].equals(script)) throw new ScriptRecursionException();
                    }
                }
                startCommand(userCommand);
            } while (scriptScanner.hasNextLine());
        } catch (FileNotFoundException exception) {
            System.out.println("Файл со скриптом не найден!");
        } catch (NoSuchElementException exception) {
            System.out.println("Файл со скриптом пуст!");
        } catch (ScriptRecursionException e) {
            System.out.println("Скрипты не могут вызываться рекурсивно!");
        } finally {
            scriptStack.remove(scriptStack.size() -1);
        }
    }


    public void startCommand(String[] userCommand) {
        try {
            //TODO: доделать свитч
            switch (userCommand[0]) {
                case "add":
                    commandManager.addCollection(userCommand[1]);
                    break;
                case "help":
                    break;
                case "show":
                    commandManager.showCollection(userCommand[1]);
                    break;
                case "info":
                    break;
                case "update":
                    break;
                case "remove_by_id":
                    break;
                case "clear":
                    break;
                case "save":
                    commandManager.saveCollection(userCommand[1]);
                    break;
                case "execute_script":
                    scriptMode(userCommand[1]);
                    break;
                case "exit":
                    break;
                case "remove_first":
                    break;
                case "remove_greater":
                    break;
                case "history":
                    break;
                case "remove_all_by_health":
                    break;
                case "remove_any_by_achievements":
                    break;
                case "group_counting_by_id":
                    break;
                default:
                    System.out.println("Не является внутренней командой. Повтороте ввод или напишите help для получения актуального списка команд.");
            }
        } catch (ExceptionInInitializerError e) {
            System.out.println("Что-то пошло не так");


        }
    }

}
