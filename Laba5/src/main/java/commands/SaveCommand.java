package commands;

public class SaveCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Hello from SaveCommand");
    }
}
//TODO: доделать команду