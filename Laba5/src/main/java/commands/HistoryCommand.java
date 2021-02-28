package commands;

public class HistoryCommand extends AbstractCommand implements Command{
    public HistoryCommand() {
        super("history", "вывести последние 9 команд (без их аргументов)");
    }

    @Override
    public void execute(String argument) {
        System.out.println("Hello from HistoryCommand");
    }
}
//TODO: доделать команду
