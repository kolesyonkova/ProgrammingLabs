package commands;

import exceptions.LowHealthException;
import exceptions.WrongArgumentException;
import managers.CollectionManager;

/**
 * Command 'remove_all_by_health'. Remove from the collection all items whose health field value is equivalent to the specified one.
 */
public class RemoveAllByHealthCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveAllByHealthCommand(CollectionManager collectionManager) {
        super("remove_all_by_health health", " удалить из коллекции все элементы, значение поля health которого эквивалентно заданному");
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'remove_all_by_health' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            if (Long.parseLong(argument) <= 0) {
                throw new LowHealthException();
            }
            collectionManager.removeAllByHealth(argument);
        } catch (WrongArgumentException exception) {
            System.out.println("Используйте: '" + getName() + "' health");
        } catch (NumberFormatException exception) {
            System.out.println("Здоровье должны быть представлено числом!");
        } catch (LowHealthException e) {
            System.out.println("Здоровье должно быть больше 0!");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}