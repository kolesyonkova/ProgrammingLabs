package commands;

import data.SpaceMarine;
import exceptions.WrongArgumentException;
import managers.Asker;
import managers.CollectionManager;

public class AddCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;
    private Asker asker;

    public AddCommand(CollectionManager collectionManager, Asker asker) {
        super("add", "добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.asker = asker;
    }

    @Override
    public void execute(String argument) {
        try {

            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            collectionManager.addToCollection(new SpaceMarine(
                    collectionManager.generateId(),
                    asker.askName(),
                    asker.askCoordinates(),
                    asker.askLocalDate(),
                    asker.askHealth(),
                    asker.askHeartCount(),
                    asker.askAchievements(),
                    asker.askMeleeWeapon(),
                    asker.askChapter()));
            System.out.println("Создание бойца окончено!");
        } catch (WrongArgumentException exception) {
            System.out.println("Используйте: '" + getName() + "'");
        }catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
