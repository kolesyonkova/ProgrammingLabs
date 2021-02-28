package commands;

public class UpdateCommand extends AbstractCommand implements Command {
    public UpdateCommand() {
        super("update id", "обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void execute(String argument) {
        System.out.println("Hello from UpdateCommand ");
    }
}
//TODO: доделать команду