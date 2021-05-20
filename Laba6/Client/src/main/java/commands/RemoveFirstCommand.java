package commands;

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
     */
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }

            collectionManager.removeFirst();
        } catch (WrongArgumentException exception) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}