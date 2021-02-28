package commands;

public class RemoveGreaterCommand extends AbstractCommand implements Command{
    public RemoveGreaterCommand() {
        super("remove_greater {element}", "удалить из коллекции все элементы, превышающие заданный");
    }

    @Override
    public void execute(String argument) {
        System.out.println("Hello from RemoveGreaterCommand");
    }
}
//TODO: доделать команду