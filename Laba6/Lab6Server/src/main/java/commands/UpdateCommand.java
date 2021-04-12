package commands;

import data.SpaceMarine;
import exceptions.EmptyCollection;
import exceptions.IncorrectId;
import exceptions.WrongArgumentException;
import managers.Asker;
import managers.CollectionManager;

import java.io.Serializable;

/**
 * Command 'update'. Updates the information about selected marine.
 */
public class UpdateCommand extends AbstractCommand implements Command, Serializable {
    private static final long serialVersionUID = 8983558202217591746L;
    private CollectionManager collectionManager;
    private Asker asker;
    private int sizeCollection;

    public UpdateCommand(CollectionManager collectionManager) {
        super("update id", "обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
        this.asker = asker;
    }

    /**
     * Execute of 'update' command.
     */
    @Override
    public void execute(String argument) {
        sizeCollection = collectionManager.getSizeCollection() - 1;
        try {
            if (argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            if (collectionManager.collectionIsEmpty()) {
                throw new EmptyCollection();
            }
            if (Long.parseLong(argument) < 0 || Integer.parseInt(argument) > sizeCollection) {
                throw new IncorrectId();
            }
            collectionManager.updateCollection(new SpaceMarine(
                    Long.parseLong(argument) + 1,
                    asker.askName(),
                    asker.askCoordinates(),
                    asker.askLocalDate(),
                    asker.askHealth(),
                    asker.askHeartCount(),
                    asker.askAchievements(),
                    asker.askMeleeWeapon(),
                    asker.askChapter()), Long.parseLong(argument));
            System.out.println("Обновление бойца окончено!");
        } catch (WrongArgumentException exception) {
            System.out.println("Используйте: '" + getName() + "' id");
        } catch (NumberFormatException exception) {
            System.out.println("Айди должен быть представлен числом!");
        } catch (IncorrectId e) {
            System.out.println("Айди солдата должен лежать в диапозоне [0;" + sizeCollection + "]");
        } catch (EmptyCollection e) {
            System.out.println("Коллекция пуста, поэтому Вы не можете её обновить. Для начала добавьте элемент в коллекцию");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}