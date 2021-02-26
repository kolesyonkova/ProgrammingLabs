package managers;

import java.util.Scanner;

public class ConsoleManager {
    CommandManager commandManager;
    private Scanner userScanner;
    private boolean fileMode = false;
    private boolean userMode = true;

    public ConsoleManager(Scanner userScanner, CommandManager commandManager, FileManager fileManager) {
        this.userScanner = userScanner;
        this.commandManager = commandManager;
    }


    public void userMode() {
        String[] userCommand;
        do {
            userCommand = userScanner.nextLine().trim().split(" ", 2);
            startCommand(userCommand);
            if (fileMode) {//TODO: доделать прикрепление к работе с файлом и ФайлМэнеджером }
                System.out.println("fileMod");
            }
        }while (!userCommand[0].equals("exit"));
    }

    public void scriptMode() {
        //TODO: доделать файл мод
    }


    public void startCommand(String[] userCommand) {
        try {
            //TODO: доделать свитч
            switch (userCommand[0]) {
                case "add":
                    commandManager.addCollection();
                    break;
                case "help":
                    break;
                case "show":
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
                    break;
                case "execute_script":
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
                    System.out.println("Defaul");
            }
        } catch (ExceptionInInitializerError e) {
            System.out.println("Что-то пошло не так");


        }
    }

}
