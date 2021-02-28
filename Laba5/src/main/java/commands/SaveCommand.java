package commands;

import exceptions.WrongArgumentException;
import managers.CollectionManager;
import managers.FileManager;

public class SaveCommand extends AbstractCommand implements Command {
    CollectionManager collectionManager;
    FileManager fileManager;

    public SaveCommand(CollectionManager collectionManager, FileManager fileManager) {
        super("save", "сохранить коллекцию в файл");
        this.fileManager = fileManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            fileManager.saveCollection(collectionManager.getMarineStack());
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
//TODO: доделать команду