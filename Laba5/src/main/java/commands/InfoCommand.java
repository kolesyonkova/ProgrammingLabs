package commands;

public class InfoCommand extends AbstractCommand implements Command {
    public InfoCommand() {
        super("info", " вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    @Override
    public void execute(String argument) {
        System.out.println("Hello from InfoCommand");
    }
}
//TODO: доделать команду
