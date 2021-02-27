package commands;

import managers.CollectionManager;

public class ShowCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager) {
        super("show command", "Выводит все элементы коллекции");
        this.collectionManager=collectionManager;
    }

    @Override
    public void execute() {
        collectionManager.showCollection();
    }
}
//TODO: доделать try/catch