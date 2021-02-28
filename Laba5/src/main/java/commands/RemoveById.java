package commands;

import data.SpaceMarine;
import exceptions.EmptyCollection;
import exceptions.IncorrectId;
import exceptions.WrongArgumentException;
import managers.CollectionManager;

public class RemoveById extends AbstractCommand implements Command{
    private int sizeCollection;
    private CollectionManager collectionManager;
    public RemoveById(CollectionManager collectionManager) {
        super("remove_by_id", "удалить элемент из коллекции по его id");
        this.collectionManager=collectionManager;
    }

    @Override
    public void execute(String argument) {
        sizeCollection = collectionManager.getSizeCollection()-1;
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
            collectionManager.removeById(Long.parseLong(argument));
            System.out.println("Удаление бойца окончено!");
        } catch (WrongArgumentException exception) {
            System.out.println("Используйте: '" + getName() + "'");
        }catch (NumberFormatException exception) {
            System.out.println("Айди должен быть представлен числом!");}
        catch (IncorrectId e) {
            System.out.println("Айди солдата должен лежать в диапозоне [0;" + sizeCollection + "]");
        } catch (EmptyCollection e) {
            System.out.println("Коллекция пуста, поэтому Вы не можете удалить из неё элементы. Для начала добавьте элемент в коллекцию");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
