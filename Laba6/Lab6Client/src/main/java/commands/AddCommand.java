package commands;

import data.SpaceMarine;
import exceptions.WrongArgumentException;
import managers.Asker;
import managers.Client;
import managers.CollectionManager;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * This is command 'add'. Adds a new element to collection.
 */
public class AddCommand extends AbstractCommand implements Command, Serializable {
    private static final long serialVersionUID = 8983558202217591746L;
    private CollectionManager collectionManager;
    private Asker asker;
    Client client;

    public AddCommand(CollectionManager collectionManager, Asker asker, managers.Client client) {
        super("add", "добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.asker = asker;
        this.client=client;
    }

    /**
     * Execute of 'add' command.
     */
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
        }catch (NoSuchElementException exception) {
            System.out.println("Пользовательский ввод не обнаружен!");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
