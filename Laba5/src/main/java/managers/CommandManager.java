package managers;

import commands.*;
import exceptions.WrongArgumentException;

import java.util.ArrayList;

public class CommandManager {
    private ArrayList<Command> commandManagerArrayList = new ArrayList<>();
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

    public CommandManager(AddCommand addCommand, ClearCommand clearCommand, GroupCountingByIdCommand groupCountingByIdCommand, ShowCommand showCommand, SaveCommand saveCommand, HelpCommand helpCommand, HistoryCommand historyCommand, InfoCommand infoCommand, RemoveAllByHealthCommand removeAllByHealthCommand, RemoveAnyByAchievementsCommand removeAnyByAchievementsCommand, RemoveFirstCommand removeFirstCommand, RemoveGreaterCommand removeGreaterCommand, UpdateCommand updateCommand, ExitCommand exitCommand) {
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
        this.exitCommand=exitCommand;

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
    }

    public void saveCollection(String argument) {
        saveCommand.execute(argument);
    }
    public void exitCommand(String argument){
        exitCommand.execute(argument);
    }
    public void addCollection(String argument) {
        addCommand.execute(argument);
    }

    public void showCollection(String argument) {
        showCommand.execute(argument);
    }

    public void clearCollection(String argument) {
        clearCommand.execute(argument);
    }
    public void info(String argument){
        infoCommand.execute(argument);
    }
    public void help(String argument) {
        if(argument.equals("")){
        helpCommand.execute(argument);
        for (Command command:commandManagerArrayList
             ) {
            System.out.println(command);
        }
        }else {helpCommand.execute(argument);}
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