package commands;

import exceptions.EmptyCollection;
import exceptions.WrongArgumentException;
import managers.CollectionManager;

/**
 * Command 'remove_first'. Deletes the first element from the collection.
 */
public class RemoveFirstCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveFirstCommand(CollectionManager collectionManager) {
        super("remove_first", "удалить первый элемент из коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'remove_first' command.
     * @return
     */
    @Override
    public String execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            if (collectionManager.collectionIsEmpty()) {
                throw new EmptyCollection();
            }
            collectionManager.removeFirst();
        } catch (WrongArgumentException exception) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (EmptyCollection e) {
            System.out.println("Коллекция пуста, поэтому Вы не удалить из неё элементы. Для начала добавьте элемент в коллекцию");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
        return argument;
    }
}