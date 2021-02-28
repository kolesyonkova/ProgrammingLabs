package commands;

public class RemoveAllByHealthCommand extends AbstractCommand implements Command{
    public RemoveAllByHealthCommand() {
        super("remove_all_by_health health", " удалить из коллекции все элементы, значение поля health которого эквивалентно заданному");
    }

    @Override
    public void execute(String argument) {
        System.out.println("Hello from RemoveAllByHealthCommand");
    }
}
//TODO: доделать команду