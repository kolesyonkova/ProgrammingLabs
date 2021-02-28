package commands;

public class RemoveAnyByAchievementsCommand extends AbstractCommand implements Command{
    public RemoveAnyByAchievementsCommand() {
        super("remove_any_by_achievements achievements", "удалить из коллекции один элемент, значение поля achievements которого эквивалентно заданному");
    }

    @Override
    public void execute(String argument) {
        System.out.println("Hello from RemoveAnyByAchievementsCommand");
    }
}
//TODO: доделать команду