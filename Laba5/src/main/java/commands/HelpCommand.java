package commands;

public class HelpCommand extends AbstractCommand implements Command{
    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public void execute(String argument) {
        System.out.println("Hello from HelpCommand");
    }
    //TODO: доделать команду
}
