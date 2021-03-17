package commands;

import exceptions.EmptyCollection;
import exceptions.WrongArgumentException;
import managers.CollectionManager;

/**
 * Command 'remove_any_by_achievements'. Removes one element from the collection whose achievements field value is equivalent to the specified one
 */
public class RemoveAnyByAchievementsCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveAnyByAchievementsCommand(CollectionManager collectionManager) {
        super("remove_any_by_achievements achievements ", "удалить из коллекции один элемент, значение поля achievements которого эквивалентно заданному");
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'remove_any_by_achievements' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            if (collectionManager.collectionIsEmpty()) {
                throw new EmptyCollection();
            }
            collectionManager.removeAnyByAchievements(argument);
            System.out.println("Удаление окончено!");
        } catch (WrongArgumentException exception) {
            System.out.println("Используйте: '" + getName() + "' achievements");
        } catch (EmptyCollection e) {
            System.out.println("Коллекция пуста, поэтому Вы не можете удалить из неё элементы. Для начала добавьте элемент в коллекцию");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
//TODO: доделать команду