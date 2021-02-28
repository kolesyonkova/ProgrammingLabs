package commands;

public class RemoveFirstCommand extends AbstractCommand implements Command{
    public RemoveFirstCommand() {
        super("remove_first", "удалить первый элемент из коллекции");
    }

    @Override
    public void execute(String argument) {
        System.out.println("Hello from RemoveFirstCommand");
    }
}
//TODO: доделать команду