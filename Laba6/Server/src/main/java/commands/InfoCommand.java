package commands;

import exceptions.WrongArgumentException;
import managers.CollectionManager;

public class InfoCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;

    /**
     * Command 'info'. Displays information about the collection.
     */
    public InfoCommand(CollectionManager collectionManager) {
        super("info", " вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'info' command.
     * @return
     */
    @Override
    public String execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            collectionManager.infoCollection();
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
        return argument;
    }
}

