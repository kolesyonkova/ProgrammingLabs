package commands;

import exceptions.WrongArgumentException;
import managers.CollectionManager;
import util.Client;

/**
 * Command 'remove_by_id'. Removes the element by its ID.
 */
public class RemoveById extends AbstractCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveById(CollectionManager collectionManager) {
        super("remove_by_id", "удалить элемент из коллекции по его id");
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'remove_by_id' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            Long id = Long.parseLong(argument);
            Client.readyToExchange("remove_by_id", argument, null);
        } catch (WrongArgumentException exception) {
            System.out.println("Используйте: '" + getName() + "' id");
        } catch (NumberFormatException exception) {
            System.out.println("Айди должен быть представлен числом!");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
