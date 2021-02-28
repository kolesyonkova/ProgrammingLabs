package commands;

public class ClearCommand extends AbstractCommand implements Command{
    public ClearCommand() {
        super("clear", "очистить коллекцию");
    }

    @Override
    public void execute(String argument) {
        System.out.println("Hello from ClearCommand");
        //TODO: доделать команду
    }
}
