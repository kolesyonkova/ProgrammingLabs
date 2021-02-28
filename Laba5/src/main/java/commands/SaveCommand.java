package commands;

import managers.CollectionManager;
import managers.FileManager;

public class SaveCommand extends AbstractCommand implements Command{
    CollectionManager collectionManager;
    FileManager fileManager;
    public SaveCommand(CollectionManager collectionManager,FileManager fileManager) {
        super("save", "сохранить коллекцию в файл");
        this.fileManager=fileManager;
        this.collectionManager=collectionManager;
    }

    @Override
    public void execute(String argument) {
        System.out.println("Hello from SaveCommand");
        fileManager.saveCollection(collectionManager.getMarineStack());
    }
}
//TODO: доделать команду