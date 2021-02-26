package commands;

import data.SpaceMarine;
import managers.Asker;
import managers.CollectionManager;

public class AddCommand extends AbstractCommand implements Command {
    CollectionManager collectionManager;
    Asker asker;

    public AddCommand(CollectionManager collectionManager, Asker asker) {
        super("name", "description");
        this.collectionManager=collectionManager;
        this.asker=asker;
    }

    @Override
    public  void execute() {

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
