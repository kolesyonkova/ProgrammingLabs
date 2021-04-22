package commands;

import exceptions.EmptyCollection;
import exceptions.WrongArgumentException;
import managers.CollectionManager;

/**
 * Command 'group_counting_by_id'. Groups the collection items by the value of the id field and outputs the number of items in each group.
 */
public class GroupCountingByIdCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;

    public GroupCountingByIdCommand(CollectionManager collectionManager) {
        super("group_counting_by_id", "сгруппировать элементы коллекции по значению поля id, вывести количество элементов в каждой группе");
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'group_counting_by_id' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            if (collectionManager.collectionIsEmpty()) {
                throw new EmptyCollection();
            }
            collectionManager.groupCountingById();
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (EmptyCollection e) {
            System.out.println("Коллекция пуста, группу сформировать не получится. Для начала добавьте элемент в коллекцию");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
