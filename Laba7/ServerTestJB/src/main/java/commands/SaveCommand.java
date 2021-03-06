package commands;

import DAO.DAO;
import exceptions.WrongArgumentException;
import managers.CollectionManager;
import managers.FileManager;

/**
 * Command 'save'. Saves the collection to a file.
 */
public class SaveCommand extends AbstractCommand implements Command {
    CollectionManager collectionManager;
    FileManager fileManager;

    public SaveCommand(CollectionManager collectionManager, FileManager fileManager) {
        super("save", "сохранить коллекцию в файл");
        this.fileManager = fileManager;
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'save' command.
     *
     * @return
     */
    @Override
    public String execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            fileManager.saveCollection(DAO.getDaoSpaceMarine().read());
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
        return argument;
    }
}