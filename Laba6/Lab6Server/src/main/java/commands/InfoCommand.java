package commands;

import exceptions.WrongArgumentException;
import managers.CollectionManager;

import java.io.Serializable;

public class InfoCommand extends AbstractCommand implements Command, Serializable {
    private static final long serialVersionUID = 8983558202217591746L;
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
     */
    @Override
    public void execute(String argument) {
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
    }
}

