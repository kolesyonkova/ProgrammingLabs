package managers;

import commands.*;

import java.util.ArrayList;
/**
 * Operates with the commands.
 */
public class CommandManager {
    private final int HISTORY_SIZE = 8;
    protected ArrayList<Command> commandManagerArrayList = new ArrayList<>();
    private ArrayList<String> commandsHistory = new ArrayList<>();
    private AddCommand addCommand;
    private ClearCommand clearCommand;
    private GroupCountingByIdCommand groupCountingByIdCommand;
    private ShowCommand showCommand;
    private SaveCommand saveCommand;
    private HelpCommand helpCommand;
    private HistoryCommand historyCommand;
    private InfoCommand infoCommand;
    private RemoveAllByHealthCommand removeAllByHealthCommand;
    private RemoveAnyByAchievementsCommand removeAnyByAchievementsCommand;
    private RemoveFirstCommand removeFirstCommand;
    private RemoveGreaterCommand removeGreaterCommand;
    private UpdateCommand updateCommand;
    private ExitCommand exitCommand;
    private RemoveById removeById;

    public CommandManager(AddCommand addCommand, ClearCommand clearCommand, GroupCountingByIdCommand groupCountingByIdCommand, ShowCommand showCommand, SaveCommand saveCommand, HelpCommand helpCommand, HistoryCommand historyCommand, InfoCommand infoCommand, RemoveAllByHealthCommand removeAllByHealthCommand, RemoveAnyByAchievementsCommand removeAnyByAchievementsCommand, RemoveFirstCommand removeFirstCommand, RemoveGreaterCommand removeGreaterCommand, UpdateCommand updateCommand, ExitCommand exitCommand, RemoveById removeById) {
        this.addCommand = addCommand;
        this.clearCommand = clearCommand;
        this.groupCountingByIdCommand = groupCountingByIdCommand;
        this.showCommand = showCommand;
        this.saveCommand = saveCommand;
        this.helpCommand = helpCommand;
        this.historyCommand = historyCommand;
        this.infoCommand = infoCommand;
        this.removeAllByHealthCommand = removeAllByHealthCommand;
        this.removeAnyByAchievementsCommand = removeAnyByAchievementsCommand;
        this.removeFirstCommand = removeFirstCommand;
        this.removeGreaterCommand = removeGreaterCommand;
        this.updateCommand = updateCommand;
        this.exitCommand = exitCommand;
        this.removeById = removeById;

        commandManagerArrayList.add(addCommand);
        commandManagerArrayList.add(clearCommand);
        commandManagerArrayList.add(groupCountingByIdCommand);
        commandManagerArrayList.add(showCommand);
        commandManagerArrayList.add(saveCommand);
        commandManagerArrayList.add(helpCommand);
        commandManagerArrayList.add(historyCommand);
        commandManagerArrayList.add(infoCommand);
        commandManagerArrayList.add(removeAllByHealthCommand);
        commandManagerArrayList.add(removeAnyByAchievementsCommand);
        commandManagerArrayList.add(removeFirstCommand);
        commandManagerArrayList.add(removeGreaterCommand);
        commandManagerArrayList.add(updateCommand);
        commandManagerArrayList.add(exitCommand);
        commandManagerArrayList.add(removeById);
    }

    /**
     * Start execute of 'save' command.
     */
    public void saveCollection(String argument) {
        saveCommand.execute(argument);
    }

    /**
     * Start execute of 'exit' command.
     */
    public void exitCommand(String argument) {
        exitCommand.execute(argument);
    }

    /**
     * Start execute of 'add' command.
     */
    public void addCollection(String argument) {
        addCommand.execute(argument);
    }

    /**
     * Start execute of 'update' command.
     */
    public void updateCollection(String argument) {
        updateCommand.execute(argument);
    }

    /**
     * Start execute of 'show' command.
     */
    public void showCollection(String argument) {
        showCommand.execute(argument);
    }

    /**
     * Show history of commands.
     */
    public void getHistory(String argument) {
        if (argument.equals("")) {
            historyCommand.execute(argument);
            for (String command : commandsHistory
            ) {
                System.out.println(command);
            }
        } else {
            historyCommand.execute(argument);
        }
    }

    /**
     * Start execute of 'remove_first' command.
     */
    public void removeFirstCommand(String argument) {
        removeFirstCommand.execute(argument);
    }

    /**
     * Start execute of 'clear' command.
     */
    public void clearCollection(String argument) {
        clearCommand.execute(argument);
    }

    /**
     * Add command to history.
     */
    public void addToHistory(String argument) {
        for (Command command : commandManagerArrayList
        ) {
            if (command.getName().split(" ")[0].equals(argument)) {
                if (commandsHistory.size() > HISTORY_SIZE) {
                    commandsHistory.remove(0);
                } else {
                    commandsHistory.add(argument);
                }
            }
        }
    }

    /**
     * Start execute of 'remove_greater' command.
     */
    public void removeGreaterCommand(String argument) {
        removeGreaterCommand.execute(argument);
    }
    /**
     * Start execute of 'remove_all_by_health' command.
     */
    public void removeAllByHealthCommand(String argument) {
        removeAllByHealthCommand.execute(argument);
    }
    /**
     * Start execute of 'remove_by_id' command.
     */
    public void removeById(String argument) {
        removeById.execute(argument);
    }

    public void info(String argument) {
        infoCommand.execute(argument);
    }
    public void removeAnyByAchievements(String argument){
        removeAnyByAchievementsCommand.execute(argument);
    }
    public void groupCountingByIdCommand(String argument){
        groupCountingByIdCommand.execute(argument);
    }
    public void help(String argument) {
        if (argument.equals("")) {
            helpCommand.execute(argument);
            for (Command command : commandManagerArrayList
            ) {
                System.out.println(command);
            }
        } else {
            helpCommand.execute(argument);
        }
    }

    @Override
    public String toString() {
        return "CommandManager{" +
                "addCommand=" + addCommand +
                ", clearCommand=" + clearCommand +
                '}';
    }

}

//TODO: доделать тут методы для команд