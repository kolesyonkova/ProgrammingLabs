package commands;

import data.SpaceMarine;
import exceptions.EmptyCollection;
import exceptions.WrongArgumentException;
import managers.Asker;
import managers.CollectionManager;
import util.Client;

/**
 * Command 'remove_greater'. Removes all element from the collection that exceed the specified value.
 */
public class RemoveGreaterCommand extends AbstractCommand implements Command {
    private CollectionManager collectionManager;
    private Asker asker;

    public RemoveGreaterCommand(CollectionManager collectionManager, Asker asker) {
        super("remove_greater", "удалить из коллекции все элементы, превышающие заданный");
        this.collectionManager = collectionManager;
        this.asker = asker;
    }

    /**
     * Execute of 'remove_greater' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
//            if (collectionManager.getSizeCollection() == 0) {
//                throw new EmptyCollection();}

            Client.readyToExchange("remove_greater", "", new SpaceMarine(
                    asker.askName(),
                    asker.askCoordinates(),
                    asker.askLocalDate(),
                    asker.askHealth(),
                    asker.askHeartCount(),
                    asker.askAchievements(),
                    asker.askMeleeWeapon(),
                    asker.askChapter()));
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "' {element}");
        }
//        catch (EmptyCollection e) {
//            System.out.println("Коллекция пуста. Чтобы удалить превосходящие элементы, добавьте их");
//        }
        catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
//TODO: доделать команду