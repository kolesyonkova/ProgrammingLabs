package commands;

public class UpdateCommand implements Command {
    @Override
    public void execute(String argument) {
        System.out.println("Hello from UpdateCommand ");
    }
}
//TODO: доделать команду