package commands;

import exceptions.WrongArgumentException;
import managers.CollectionManager;

import java.io.Serializable;

/**
 * Command 'clear'. Clears the collection.
 */
public class ClearCommand extends AbstractCommand implements Command , Serializable {
    private static final long serialVersionUID = 8983558202217591746L;
    CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'clear' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            collectionManager.clearCollection();
            System.out.println("Колеекция успешно очищена!");
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
