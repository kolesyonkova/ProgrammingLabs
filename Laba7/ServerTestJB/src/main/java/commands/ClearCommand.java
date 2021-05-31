package commands;

import exceptions.WrongArgumentException;
import managers.CollectionManager;

/**
 * Command 'clear'. Clears the collection.
 */
public class ClearCommand extends AbstractCommand implements Command {
    CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'clear' command.
     * @return
     */
    @Override
    public String execute(String argument) {
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
        return argument;
    }
}
