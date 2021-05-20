package commands;

import DAO.DAO;
import exceptions.EmptyCollection;
import exceptions.MarineNotFoundException;
import exceptions.WrongArgumentException;
import managers.CollectionManager;

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
     *
     * @return
     */
    @Override
    public String execute(String argument) {
        try {
            if (argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            if (collectionManager.collectionIsEmpty()) {
                throw new EmptyCollection();
            }
            if (!DAO.getDaoSpaceMarine().listOfID().contains(Long.parseLong(argument)))
                throw new MarineNotFoundException();
            return collectionManager.removeFromCollection(argument);
        } catch (WrongArgumentException exception) {
            System.out.println("Используйте: '" + getName() + "' id");
        } catch (NumberFormatException exception) {
            System.out.println("Айди должен быть представлен числом!");
        } catch (MarineNotFoundException exception) {
            System.out.println("Бойца с таким айди в коллекции нет! Айди должен принадлежать :" + DAO.getDaoSpaceMarine().listOfID());
            return "Бойца с таким айди в коллекции нет! Айди должен принадлежать :" + DAO.getDaoSpaceMarine().listOfID();
        } catch (EmptyCollection e) {
            System.out.println("Коллекция пуста, поэтому Вы не можете удалить из неё элементы. Для начала добавьте элемент в коллекцию");
            return "Коллекция пуста, поэтому Вы не можете удалить из неё элементы. Для начала добавьте элемент в коллекцию";
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
        return "Что-то пошло не так! Remove_by_id";
    }
}
