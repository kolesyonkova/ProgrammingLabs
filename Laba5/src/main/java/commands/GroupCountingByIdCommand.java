package commands;

public class GroupCountingByIdCommand extends AbstractCommand implements Command {
    public GroupCountingByIdCommand() {
        super("group_counting_by_id", "сгруппировать элементы коллекции по значению поля id, вывести количество элементов в каждой группе");
    }

    @Override
    public void execute(String argument) {
        System.out.println("Hello from GroupCountingByIdCommand");
    }
    //TODO: доделать команду
}
