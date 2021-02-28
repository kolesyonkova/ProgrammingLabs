package commands;

import managers.CollectionManager;

public class ShowCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager=collectionManager;
    }

    @Override
    public void execute(String argument) {
        collectionManager.showCollection();
    }
}
//TODO: доделать try/catch