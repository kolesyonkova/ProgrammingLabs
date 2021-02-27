package commands;

import data.SpaceMarine;
import managers.Asker;
import managers.CollectionManager;

import java.util.ArrayDeque;

public class AddCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;
    private Asker asker;
    private String[] data;

    public AddCommand(CollectionManager collectionManager, Asker asker) {
        super("add command", "Добавляет объекты в коллекцию");
        this.collectionManager = collectionManager;
        this.asker = asker;
    }

    @Override
    public void execute() {
        collectionManager.addToCollection(new SpaceMarine(
                collectionManager.generateId(),
                asker.askName(),
                asker.askCoordinates(),
                asker.askLocalDate(),
                asker.askHealth(),
                asker.askHeartCount(),
                asker.askAchievements(),
                asker.askMeleeWeapon(),
                asker.askChapter()
        ));
        System.out.println("Создание бойца окончено!");
        //TODO: доделать команду
    }
}
