package commands;

public class ShowCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Hello from ShowCommand");
    }
}
//TODO: доделать команду