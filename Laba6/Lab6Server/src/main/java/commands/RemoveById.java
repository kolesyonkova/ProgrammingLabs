package commands;

import data.SpaceMarine;
import exceptions.EmptyCollection;
import exceptions.MarineNotFoundException;
import exceptions.WrongArgumentException;
import managers.CollectionManager;

import java.io.Serializable;

/**
 * Command 'remove_by_id'. Removes the element by its ID.
 */
public class RemoveById extends AbstractCommand implements Command , Serializable {
    private static final long serialVersionUID = 8983558202217591746L;
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
            if (collectionManager.collectionIsEmpty()) {
                throw new EmptyCollection();
            }
            Long id = Long.parseLong(argument);
            SpaceMarine marineToRemove = collectionManager.getById(id);
            if (marineToRemove == null) throw new MarineNotFoundException();
            collectionManager.removeFromCollection(marineToRemove);
            System.out.println("Удаление бойца окончено!");
        } catch (WrongArgumentException exception) {
            System.out.println("Используйте: '" + getName() + "' id");
        } catch (NumberFormatException exception) {
            System.out.println("Айди должен быть представлен числом!");
        } catch (MarineNotFoundException exception) {
            System.out.println("Бойца с таким айди в коллекции нет!");
        } catch (EmptyCollection e) {
            System.out.println("Коллекция пуста, поэтому Вы не можете удалить из неё элементы. Для начала добавьте элемент в коллекцию");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
